const fs = require('fs');
class Scanner {
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().split('\n');
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

let Limit, visited, posssible;
const input = function (){
  Limit = [];
  for(let i = 0; i < 3; i ++){
    Limit[i] = scanner.nextNumber();
  }
  visited = [];
  let two = [];
  for(let i = 0; i <= 200; i ++){
    for(let i = 0; i <= 200; i ++){
      let one = [];
      for(let i = 0; i <= 200; i ++){
        one.push(0);
      }
      two.push(one);
    }
    visited.push(two);
  }

  posssible = new Array(201);
}

function State (X){
  this._X = X
  this.move = function(from, to, limit){
    let nxt = [this._X[0], this._X[1], this._X[2]];
    if(this._X[from] > limit[to] - this._X[to]){
      nxt[from] =  this._X[from] - (limit[to] - this._X[to])
      nxt[to] = limit[to];
    } else {
      nxt[to] += this._X[from];
      nxt[from] = 0;
    }
    return new State(nxt);
  }

}
const bfs = function(X){
  let state = new State(X);
  let Q = [];
  Q.push(state);
  while(Q.length !== 0){
    state = Q.shift();
    visited[state._X[0]][state._X[1]][state._X[2]] = 1;
    if(state._X[0] === 0)posssible[state._X[2]] = 1;
    for(let i = 0; i < 3; i ++){
      for(let j = 0; j < 3; j ++){
        if(i === j) continue;
        let nxt = state.move(i,j,Limit);
        if(visited[nxt._X[0]][nxt._X[1]][nxt._X[2]] === 0){
          Q.push(nxt);
        }
      }
    }
  }
}

const pro = function (){
  let X = [0, 0, Limit[2]];
  bfs(X); 
  let ans = '';
  posssible.forEach((v, idx) => {
    if(v === 1) ans += idx + ' ';
  })
  console.log(ans);
}

const solve = function(){
  input();
  pro();
}

solve();