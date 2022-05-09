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
let N, M;
let avg, arr, visited, tem;
let T;
const input = function (){
  [N,M] = scanner.nextLine().split(" ").map(Number);
  let info = scanner.read.splice(0, N).map(line => line.split(" ").map(Number));
  //console.log(info);
  avg = Array.from({length : N + 1}, () => Array.from({length : M + 1}, () => 0));
  visited = Array.from({length : N + 1}, () => Array.from({length : M + 1}, () => 0));
  arr = Array.from({length : N + 1}, () => []);
  T = scanner.nextNumber();
  tem = [];
  for(let i = 1; i <= N; i ++){
    arr[i] = [0,...info[i - 1]];
  }
  for(let i = 1; i <= N; i ++){
    for(let j = 0; j < M; j ++){
      let sum = 0
      for(let k = (j * 3) + 1; k <= (j * 3) + 3; k ++){
        sum += arr[i][k];
      }
      avg[i][j + 1] = (Math.floor(sum / 3) >= T) ? 255 : 0
      if(avg[i][j + 1] === 255) tem.push([i,j+1]);
    }
  }
  //console.log(avg);
}
const dir = [[-1,0],[1,0],[0,-1],[0, 1]];
const bfs = function (Y, X, count){
  visited[Y][X] = count;
  let Q = [[Y,X]];
  let nY,nX;
  while(Q.length !== 0){
    let [pY, pX] = Q.shift();
    dir.forEach(([dY,dX]) => {
      nY = pY + dY;
      nX = pX + dX;
      if(nY < 1 || nY > N ) return;
      if(nX < 1 || nX > M ) return;
      if(avg[nY][nX] === 0) return;
      if(visited[nY][nX] !== 0) return;
      visited[nY][nX] = count;
      Q.push([nY, nX]);
    })
  }
}
const pro = function (){
  let count = 0;
  // for(let i = 1; i <= N; i ++){
  //   for(let j = 1; j <= M ; j ++){
  //     if(avg[i][j] === 0) continue;
  //     if(visited[i][j] !== 0) continue;
  //     count ++;
  //     bfs(i,j,count); 
  //   }
  // }
  console.log(tem)
  tem.forEach(([y,x]) => {
    if(visited[y][x] !== 0) return;
    count ++ 
    bfs(y,x, count)
  })
  console.log(count);
}

const solve = function(){
  input();
  pro();
}

solve();