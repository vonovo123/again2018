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
let N, edgeCount;
let graph;
const input = function (){
  N = scanner.nextNumber();
  edgeCount = scanner.nextNumber();
  let info = scanner.read.splice(0).map(i => i.split(" ").map(Number));
  graph = Array.from({length : N + 1}, () => []);
  visited = Array.from({length : N + 1}, () => false);
  info.forEach(([a, b]) => {
    graph[a].push(b);
    graph[b].push(a);
  })
}
const bfs = function(){
  visited[1] = true;
  let count = 0;
  let Q = [1];
  while(Q.length > 0){
    let pop = Q.shift();
    graph[pop].forEach(v => {
      if(!visited[v]){
        count += 1;
        visited[v] = true;
        Q.push(v);
      }
    })
  }
  console.log(count);
}
const pro = function (){
  //console.log(graph);
  bfs();
  
}

const solve = function(){
  input();
  pro();
}

solve();