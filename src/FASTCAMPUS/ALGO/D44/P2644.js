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
let N
let A, B;
let m;
let rel, edges, visited;

const input = function (){
  N = scanner.nextNumber();
  [A, B] = scanner.nextLine().split(" ").map(Number);
  m = scanner.nextNumber();
  rel = scanner.read.splice(0).map(v => v.split(" ").map(Number));
  edges = Array.from({length : N + 1}, () => []);
  visited = Array.from({length : N + 1}, () => -1);
}
const bfs = function(start){
  let Q = [[start,0]];
  visited[start] = 0;
  while(Q.length !== 0){
    let [pop, count] = Q.shift();
    edges[pop].forEach(v => {
      if(visited[v] === -1){
        visited[v] = count + 1;
        Q.push([v, count + 1]);
      }
    })
  }
}
const pro = function (){
  rel.forEach(r => {
    [p, c] = r;
    edges[p].push(c);
    edges[c].push(p);
  })
  bfs(A);
  console.log(visited[B])
}
const solve = function(){
  input();
  pro();
}

solve();