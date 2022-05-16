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
let avg, arr;
let T;
const input = function (){
  [N,M] = scanner.nextLine().split(" ").map(Number);
  let info = scanner.read.splice(0, N).map(line => line.split(" ").map(Number));
  arr = Array.from({length : N + 1}, () => []);
  avg = Array.from({length : N + 1}, () => Array.from({length : M + 1}, () => 0));
  T = scanner.nextNumber();
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
    }
  }
}
const dfs = function (y, x){
  if(y <= -1 || y > N || x <= -1 || x > M)return;
  if(avg[y][x] === 255){
    avg[y][x] = 0;
    dfs(y - 1, x);
    dfs(y + 1, x);
    dfs(y, x - 1);
    dfs(y, x + 1);
  }
}
const pro = function (){
  let count = 0;
  for(let i = 1; i <= N; i ++ ){
    for(let j = 1; j <= M; j ++){
      if(avg[i][j] === 255){
        count ++;
        dfs(i,j);
      }
    }
  }
  console.log(count);
}

const solve = function(){
  input();
  pro();
}

solve();