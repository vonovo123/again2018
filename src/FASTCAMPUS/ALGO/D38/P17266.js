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
let N;
let M;
let x;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  x = scanner.nextLine().split(" ").map(Number);
}
const determination = function(heigth){
  let min = x[0] - heigth;
  let max = x[x.length - 1] + heigth;
  if(min > 0) return false;
  if(max < N) return false;
  for(let i = 0; i < x.length - 1; i ++){
    if(x[i] + heigth < x[i + 1] - heigth) return false;
  }
  return true;
}
const pro = function (){
let left = 1; 
let right = 100000;
let answer = right;
  while(left <= right){
    let mid = Math.floor((left + right) /2);
    
    if(determination(mid)){
      right = mid - 1;
      answer = mid;
    } else {
      left = mid + 1;
    }
  }
  console.log(answer);
}

const solve = function(){
  input();
  pro();
}

solve();