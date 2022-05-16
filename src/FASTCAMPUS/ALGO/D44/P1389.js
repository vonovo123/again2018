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
let N, M, edges, visited;
const input = function (){
  [N, M] =scanner.nextLine().split(" ").map(Number);
  let info = scanner.read.splice(0);
  edges = Array.from({length : N + 1}, () => []);
  info.forEach(line => {
    let [A, B] = line.split(" ").map(Number);
    edges[A].push(B);
    edges[B].push(A);
  })
}
const bfs = function (start) {
  let Q = [];
  let count = 0
  Q.push(start);
  visited[start] = count;
  while(Q.length !== 0){
    let pop = Q.shift();
    edges[pop].forEach(next => {
      if(visited[next] === -1){
        visited[next] = visited[pop] + 1;
        Q.push(next);
      }
    })
  }
}
const pro = function (){
  let min = Number.MAX_VALUE;
  let minIdx = 0;
  for(let i = 1; i <=N; i ++){
    visited = Array.from({length : N + 1}, () => -1);
    bfs(i);
    let sum = 0;
    for(let i = 1; i <= N; i ++){
      sum += visited[i];
    }
    if(sum < min){
      minIdx = i;
      min = sum
    }
  }
  console.log(minIdx);
  
}

const solve = function(){
  input();
  pro();
}

solve();