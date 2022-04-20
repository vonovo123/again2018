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
let N;
let arr, visited;
const input = function (){
  N = scanner.nextNumber();
  arr = Array.from({length : N}, () => []);
  visited =  Array.from({length : N}, () => Array.from({length : N}, ()=>0));
  let infos = scanner.read.splice(0, N);
  infos.forEach((info, i) => {
    info.split(" ").map(Number).forEach((v, j) => {
      if(v !== 0){
        arr[i].push(j);
        //arr[j].push(i);
      }
    })
  })
}
const bfs = function(start){
  let Q = [start];
  let flag = false;
  while(Q.length !== 0){
    let pop = Q.shift();
    arr[pop].forEach(c => {
      if(visited[start][c] ===0){
        visited[start][c] = 1;
        Q.push(c);
      }
    })
  }
}
const pro = function (){
  for(let i = 0; i < N; i ++){
    bfs(i);
  }
  let answer = '';
  visited = visited.map(v => {
      return v.join(" ");
  })
  console.log(visited.join('\n'));
}

const solve = function(){
  input();
  pro();
}

solve();