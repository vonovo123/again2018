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
let N, A;
const input = function (){
  N = scanner.nextNumber();
  A = scanner.nextLine().split(" ").map(Number).sort((a,b) => a - b);
}

const pro = function (){
  let p1 = 0; p2 = 0; p3 = 0;
  let min = Number.MAX_VALUE;
  for(let i = 0; i < N - 2; i ++){
    let target = A[i];
    let L = i + 1;
    let R = N - 1;
    while(L < R){
      if(Math.abs(target + A[L] + A[R]) < min){
        p1 = target;
        p2 = A[L];
        p3 = A[R];
        min = Math.abs(target + A[L] + A[R]);
      }
      if(target + A[L] + A[R] > 0){
        R --
      } else {
        L ++;
      }
    }
  }
  console.log(`${p1} ${p2} ${p3}`);
}

const solve = function(){
  input();
  pro();
}

solve();