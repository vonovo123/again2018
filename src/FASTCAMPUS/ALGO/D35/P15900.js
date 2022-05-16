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
let N, count;
let graph;
const input = function (){
  count = 0;
  N = scanner.nextNumber();
  graph = Array.from({length : N + 1}, () => new Array());
  scanner.read.forEach(e => {
    //console.log(e.split(" ").map(Number));
    let [a, b] = e.split(" ").map(Number);
    graph[a].push(b);
    graph[b].push(a);
  })
  //console.log(graph);
}

function dfs(s, depth, prev){
  if(s !== 1 && graph[s].length === 1){
    count += depth;
    return;
  }
  graph[s].forEach(e => {
    if(prev === e) return;
    dfs(e, depth + 1, s);
  })
}
const pro = function (){
  dfs(1, 0, 0);
  if(count % 2 === 0){
    console.log('No')
  } else {
    console.log('Yes');
  }
  
}

const solve = function(){
  input();
  pro();
}

solve();