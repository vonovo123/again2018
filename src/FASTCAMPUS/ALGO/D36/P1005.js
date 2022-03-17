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
let T, N, K, time, indeg, child, W, done;
const input = function (){
  [N, K] = scanner.nextLine().split(" ").map(Number);
  time = [0, ...scanner.nextLine().split(" ").map(Number)];
  indeg = Array.from({length : N + 1}, () => 0);
  child = Array.from({length : N + 1}, () => new Array());
  done = Array.from({length : N + 1}, () => 0);
  let tmp = scanner.read.splice(0, K);
  tmp.forEach(d => {
    let [from, to] = d.split(" ").map(Number);
    indeg[to] ++ ;
    child[from].push(to);
  })
  W = scanner.nextNumber();
}

const pro = function (){
  let Q = [];
  for(let i = 1; i <= N; i ++){
    if(indeg[i] === 0) {
      Q.push(i);
      done[i] = time[i];
    }
  }
  while(Q.length !== 0){
    let p = Q.shift();
    child[p].forEach(e => {
      indeg[e] --;
      if(indeg[e] === 0) Q.push(e);
      done[e] = Math.max(done[e], done[p] + time[e]);
    })
  }
  console.log(done[W]);
}

const solve = function(){
  T = scanner.nextNumber();
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
}

solve();