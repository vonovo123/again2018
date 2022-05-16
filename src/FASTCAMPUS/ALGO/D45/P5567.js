const fs = require('fs');
const { isFunctionOrConstructorTypeNode } = require('typescript');
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
let n, m;
let edges, visited;

const input = function (){
  n = scanner.nextNumber();
  m = scanner.nextNumber();
  visited = Array.from({length : n + 1}, () => 0);
  friend = Array.from({length : n + 1}, () => -1); 
  edges = Array.from({length : n + 1}, () => []);
  let infos = scanner.read.splice(0).map(info => info.split(" ").map(Number));
  infos.forEach(([a, b]) => {
    edges[a].push(b);
    edges[b].push(a);
  })
}
  const bfs = function(start){
    let Q = [start];
    visited[start] = 1;
    friend[start] = start;
    let count = 0;
    while(Q.length !== 0){
      let pop = Q.shift();
      edges[pop].forEach(v => {
        if(visited[v] === 0){
          if(friend[pop] === 1){
            Q.push(v);
            visited[v] = 1;
            friend[v] = pop;
            count ++;
          }
        }
      })
    }
    console.log(count);
  }
const pro = function (){
  bfs(1);
}

const solve = function(){
  input();
  pro();
}

solve();