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
let graph;
let visited
let X;
const input = function (){
  [N,M] = scanner.nextLine().split(" ").map(Number);
  visited = Array.from({length : N + 1}, () => 0);
  graph = Array.from({length : N + 1}, () => []);
  let infos = scanner.read.splice(0, M);
  infos.forEach(info => {
    [A, B] = info.split(" ").map(Number);
    graph[B].push(A);
  })
  X = scanner.nextNumber();
}

const pro = function (){
  let Q = [];
  let count = 0;
  Q.push(X);
  while(Q.length !== 0){
    let pop = Q.pop();
    for(let i = 0; i < graph[pop].length; i ++){
      let v = graph[pop][i];
      if(visited[v] !== 0) continue;
      count ++;
      visited[v] = 1;
      Q.push(v);
        
    }
  }  
console.log(count);
}

const solve = function(){
  input();
  pro();
}

solve();