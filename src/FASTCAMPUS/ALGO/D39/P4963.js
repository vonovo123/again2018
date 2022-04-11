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
let w, h, A, visited,answer;
const scanner = new Scanner('stdin.txt');

const input = function (){
  A = Array.from({length : h}, () => {return Array.from({length : w}, () => 0)});
  let input = scanner.read.splice(0, h);
  for(let i = 0; i < h; i ++){
    let tmp = input[i].split(' ').map(Number);
    for(let j = 0; j < w; j ++){
      A[i][j] = tmp[j];
    }
  }
  visited = Array.from({length : h}, () => {return Array.from({length : w}, () => 0)});
}
let template = [
  [-1,-1], [-1, 0],[-1,1],
  [0, -1], [0, 1],
  [1, -1], [1, 0],[1, 1], 
]
const dfs = function(Y,X){
  let nY = 0;
  let nX = 0;
  template.forEach(([y, x]) => {
    nY = Y + y;
    nX = X + x;
    if(nY < 0 || nY >= h) return;   
    if(nX < 0 || nX >= w) return;
    if(A[nY][nX] === 0) return;
    if(visited[nY][nX] === 1) return;
    visited[nY][nX] = 1;
    dfs(nY,nX);
  })
}
const pro = function (){
  
  let count = 0
  for(let i = 0; i < h; i ++){
    for(let j = 0; j < w; j ++){
      if(A[i][j] === 0) continue;
      if(visited[i][j] === 0){
        visited[i][j] = 1;
        count += 1;
        dfs(i,j)
      }
    }
  }
  answer  += count;
  answer  += `\n`;
}

const solve = function(){
  answer = '';
  while(true){
    [w, h] = scanner.nextLine().split(" ").map(Number);
    if(w === 0 && h === 0) break;
    input();
    pro();
  }
  console.log(answer.trim())
  
}

solve();