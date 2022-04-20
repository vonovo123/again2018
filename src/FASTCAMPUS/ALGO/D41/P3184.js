const fs = require('fs');
class Scanner {
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().trim().split('\n');
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
// . := 빈필드 # := 울타리 o := 양 v := 늑대
// 수평 수직으로만 이동
// 울타리를 지나지않고 다른 칸으로 이동할 수 잇다면 두 칸은 같은 영역
// 마당에서 탈출 할 수 잇는 칸은 어떤 영역에도 속하지않는다.
// 영역안의 양 수가 늑대수 보다 많으면 이기고 아니면 먹힌다.
let R, C;
let A;
let visited;
let template = [[-1, 0], [1, 0], [0, -1], [0, 1]];
const input = function (){
  [R , C] = scanner.nextLine().split(" ").map(Number);
  A = scanner.read.splice(0).map(t => t.split(""));
  visited = Array.from({length:R}, () => Array.from({length:C}, () => false));
}
const dfs  = function(Y,X,o,v){
  let ny, nx;
  template.forEach(([y, x]) => {
    ny = Y + y;
    nx = X + x;
    if(ny < 0 || ny >= R) return;
    if(nx < 0 || nx >= C) return;
    if(visited[ny][nx]) return;
    if(A[ny][nx] === '#') return;
    if(A[ny][nx] === 'o') o ++;
    if(A[ny][nx] === 'v') v ++;
    visited[ny][nx] = true;
    [o,v] = dfs(ny,nx,o,v);
  })
  return [o, v];
}
const pro = function (){
  //console.log(A);
  //console.log(visited);
  let totalO = 0 , totalV = 0;
  for(let i = 0; i < R; i ++){
    for(let j = 0; j < C; j ++){
      let o = 0, v = 0;
      if(!visited[i][j]){
        if(A[i][j] === '#') continue;
        visited[i][j] = true;
        if(A[i][j] === 'o') o ++;
        if(A[i][j] === 'v') v ++;
        [o,v] = dfs(i,j,o,v);
        if(o > v) v = 0;
        else o = 0;
        totalO += o;
        totalV += v;
      }
    }
  }
  console.log(totalO +" " + totalV);
}

const solve = function(){
  input();
  pro();
}

solve();