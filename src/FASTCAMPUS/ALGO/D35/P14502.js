const fs = require('fs');
class Scanner {
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().split('\n');
    this.stringToken = [];
  }
  next(){
    if(this.stringToken.length === 0){
      if(this.read.length > 0){
        this.stringToken = this.read.shift().split(" ");
      } else {
        return null;
      }
    } 
    return this.stringToken.shift();
  }

  nextNumber(){
    const next = this.next();
    if(next){
      return Number(next);
    } else {
      return null;
    }
    
  }

  nextLine(){
    if(this.read.length > 0){
      return this.read.shift();
    } else {
      return null;
    }
    
  }
}
const scanner = new Scanner('stdin.txt');
// N*M  크기의 직사각형 연구소(3 <= N, M <= 8)
// 0 : 빈칸(3 <= 빈칸 ), 1 :  벽, 2 : 바이러스(2<= 바이러스 <= 10)
// 연구소에 벽 세우기
// 빈칸, 빈벽으로 이루어짐
// 새로 세울수 있는 벽의 개수는 항상 3개
// 바이러스는 상하좌우로 퍼져나갈수 있음.
// 벽 3개를 새운후 안전영역 크기의 최댓값

let N, M, A, visited, V ;
let table = [[-1, 0] , [1, 0], [0, -1], [0, 1]]
let max = 0;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  A = Array.from({length : N}, () => new Array(M));
  visited = Array.from({length : N}, () => new Array(M).fill(0));
  A.forEach((_, i) => {
    A[i] = scanner.nextLine().split(" ").map(Number);
  })
  V = [];
}

const bfs = function(A){
  let copy = A.map(c => c.map(l => l));
  // if(copy[1][0] === 1 && copy[0][1] === 1 && copy[3][5] === 1){
  //   console.log(copy.map(c => c.join('')).join('\n'));
  // }
  let Q = [...V];
  while(Q.length !== 0){
    let [y, x] = Q.shift();
    for(let i = 0; i < table.length; i ++){
      let ny = y + table[i][0];
      let nx = x + table[i][1];
      if(ny < 0 || ny > N - 1) continue;
      if(nx < 0 || nx > M - 1) continue;
      if(copy[ny][nx] === 2 || copy[ny][nx] === 1) continue;
      if(copy[ny][nx] === 0) {
        copy[ny][nx] = 2
        Q.push([ny, nx]);
      };
    }
   
  }
   
  let count = 0;
    copy.forEach(c => {
      c.forEach(l => {
        if(l === 0) count ++;
      })
    })
    max = Math.max(count, max);
    // if(copy[1][0] === 1 && copy[0][1] === 1 && copy[3][5] === 1){
    //   console.log(copy.map(c => c.join('')).join('\n'));
    //   console.log(count);
    // }
}
const dfs = function(y, x, c){
  if( c === 3){
    bfs(A);
    return;
  }
  if(y === N ) return;
  if(A[y][x] === 0){
    A[y][x] = 1;
    if(x === M - 1){
      dfs( y + 1, 0, c + 1);
    } else {
      dfs( y, x + 1, c + 1);
    }
    A[y][x] = 0;
    if(x === M - 1){
      dfs( y + 1, 0, c);
    } else {
      dfs( y, x + 1, c);
    }
  } else {
    if(x === M - 1){
      dfs( y + 1, 0, c);
    } else {
      dfs( y, x + 1, c);
    }
  }
}
const pro = function (){
  A.forEach((_, y) => {
    _.forEach((r, x) => {
      if(r === 2){
        V.push([y,x]);
      }
    })
  })
  dfs(0, 0, 0);
  console.log(max);
}

const solve = function(){
  input();
  pro();
}

solve();