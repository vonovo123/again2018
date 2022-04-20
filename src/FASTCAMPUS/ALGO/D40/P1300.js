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

let N, K;
const input = function (){
  N = scanner.nextNumber();
  K = scanner.nextNumber();
}
const determination = function(candi){
  let sum = 0;
 for(let i = 1; i <= N; i ++){
  sum += Math.min(N, Math.floor(candi / i));
 } 
 return sum >= K;
}
const pro = function (){
  let left = 1;
  let right = Math.pow(N,2);
  let answer = left;
  while(left <= right){
    let mid = Math.floor((left+right) / 2);
    if(determination(mid)){
      answer = mid;
      right = mid - 1;
    } else {
      left = mid  + 1;
    }
  }
  console.log(answer);
}

const solve = function(){
  input();
  pro();
}

solve();