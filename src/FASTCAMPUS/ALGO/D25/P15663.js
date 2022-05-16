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

let N, M, Arr, visited;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  Arr = [];
  visited = [];
  for(let i = 0; i < N; i ++){
    Arr[i] = scanner.nextNumber();
  }
}
const dfs = function(arr){
  if(arr.length == M){
    console.log(arr.join(" "));
    return;
  }
  let last = 0;
  for(let i = 0; i < N; i ++){
    if(visited.indexOf(i) != -1) continue;
    if(last === Arr[i]) continue;
    arr.push(Arr[i]);
    visited.push(i);
    last = Arr[i];
    dfs(arr);
    arr.pop();
    visited.pop();
  }
};
const pro = function (){
  Arr.sort((a,b) => {
    return a - b;
  })
  dfs([]);
}

const solve = function(){
  input();
  pro();
}

solve();