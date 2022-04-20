const fs = require('fs');
const { collapseTextChangeRangesAcrossMultipleVersions } = require('typescript');
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
let N, X, C;
const input = function (){
  N = scanner.nextNumber();
  C = scanner.nextNumber();
  X = [];
  for(let i = 0; i < N; i ++){
    X[i] = scanner.nextNumber();
  }
}
const determination = function(D) {
  let count = 1;
  let last = X[0];
  for(let i = 1; i < N; i ++){
    if(X[i] - last >= D){
      last = X[i];
      count ++;
    } 
  }
  
  return count >= C;
}
const search = function(){
 let L = 1;
 let R = 1000000000;
 let result = 0;
 while(L <= R){
   let mid = parseInt((L + R) / 2);
    if(determination(mid)){
      result = mid;
      L = mid + 1;
    } else {
      R = mid - 1;
    }
 }
console.log(result);
}

const pro = function (){
X.sort((a,b) => a - b)
search();
}
const solve = function(){
  input();
  pro();
}

solve();