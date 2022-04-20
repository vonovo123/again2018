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
let miro;
let visited;
let template = [[-1, 0], [1, 0], [0, -1], [0, 1]];
let min = Number.MAX_VALUE;
const input = function (){
  [N, M] = scanner.nextLine().split(" ").map(Number);
  miro = Array.from({length : N + 1}, () => [0]);
  visited = Array.from({length : N + 1}, () => [0]);
  let arr = scanner.read.splice(0, M);
  for(let i = 1; i <= arr.length; i ++){
    let tmp = arr[i - 1].split('').map(Number);
    for(let j = 1; j <= tmp.length; j ++){
      miro[i][j] = tmp[j - 1];
      visited[i][j] = Infinity;
    }
  }
}
const bfs = function(Y, X){
  let Q = [];
  Q.push([Y,X]);
  visited[Y][X] = 1;
  while(Q.length !== 0){
    let [pY, pX] = Q.pop();
    for(let i = 0; i < 4; i ++){
      let [y, x] = template[i];
      let nY = pY + y;
      let nX = pX + x;
      if(nY < 1)  continue;
      if(nY > N)  continue;
      if(nX < 1)  continue;
      if(nX > M)  continue;
      if(miro[nY][nX] === 0) continue;
      if(visited[nY][nX] <= visited[pY][pX] + 1) continue;
      visited[nY][nX] = visited[pY][pX] + 1;
      Q.push([nY,nX]);
    }
  }
}
const pro = function (){
  bfs(1, 1);
  // for(let i = 1; i <=N; i ++){
  //   let tmp =""
  //   for(let j = 1; j <= M; j ++){
  //     tmp += visited[i][j];
  //   }
  //   console.log(tmp);
  // }
  console.log(visited[N][M]);
}

const solve = function(){
  input();
  pro();
}

solve();