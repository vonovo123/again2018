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
let M, N, K;
let infos;
let table, visited;
const input = function (){
[M, N, K] = scanner.nextLine().split(" ").map(Number);
infos = scanner.read.splice(0, K).map(info => info.split(" ").map(Number));
table= Array.from({length : N}, () => Array.from({length : M}, () => 0));
visited= Array.from({length : N}, () => Array.from({length : M}, () => 0));
}
let dir = [[-1,0], [1,0], [0,-1], [0,1]];
 const dfs = function(y, x, marker){
   dir.forEach(([dy, dx]) => {
     let newY = y + dy;
     let newX = x + dx;
     if(newY < 0 || newY >= N) return;
     if(newX < 0 || newX >= M) return;
     if(visited[newY][newX] !== 0) return;
     if(table[newY][newX] === 0) return;
     visited[newY][newX] = marker;
     //console.log("inner", newY,newX);
     dfs(newY, newX, marker);
   } )
 }
const pro = function (){
  infos.forEach(([x, y]) => table[y][x] = 1);
  let marker = 0;
  for(let y = 0; y < N; y ++){
    for(let x = 0; x < M; x ++){
      if(visited[y][x] !== 0) continue;
      if(table[y][x] === 0 ) continue;
      marker += 1;
      visited[y][x]= marker;
      dfs(y,x,marker);
    }
  }
  //console.log(table);
  // for(let y = 0; y < N; y ++){
  //   let line = ""
  //   for(let x = 0; x < M; x ++){
  //     line += visited[y][x];
  //   }
  //   console.log(line);
  // }
  console.log(marker);
}

const solve = function(){
  let T = scanner.nextNumber();
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
  
}

solve();