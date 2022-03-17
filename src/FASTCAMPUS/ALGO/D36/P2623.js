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

let N, M; // N : 가수의 수  M : 피디의 수
let indeg, child;
const input = function (){
  [N, M] = scanner.nextLine().split(" ").map(Number);
  indeg = Array.from({length : N + 1}, () => 0);
  child = Array.from({length : N + 1}, () => new Array());
  for(let i = 0; i < M; i ++){
    let info = scanner.nextLine().split(" ").map(Number);
    for(let j = 1; j < info.length - 1; j ++){
      let from = info[j];
      let to = info[j + 1];
      child[from].push(to);
      indeg[to] ++;
    }
  }
  //console.log(child);
  //console.log(indeg);
}

const pro = function (){
let Q = [];
let ans = [];
  for(let i = 1; i <= N; i ++){
    if(indeg[i] === 0){
      Q.push(i);
    } 
  }
 if(Q.length === 0){
   console.log(0);
   return;
 }
 while(Q.length !== 0){
   let pop = Q.shift();
   //if(ans.indexOf(pop) === -1) 
   ans.push(pop);
   child[pop].forEach(c => {
    indeg[c] --;
    if(indeg[c] === 0) Q.push(c);
   })
 }
 if(ans.length === 6){
  console.log(ans.join("\n")); 
 } else {
   console.log(0);
 }
 
 //console.log(indeg)
}

const solve = function(){
  input();
  pro();
}

solve();