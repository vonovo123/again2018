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
let A;
const input = function (){
  N = scanner.nextNumber();
  A = scanner.nextLine().split(" ").map(Number).sort((a,b) => a - b );
}

const pro = function (){
  let left = 0;
  let right = A.length - 1;
  let min =  Number.MAX_VALUE;
  let minA = 0;
  let minB = 0;
  while(left < right){
    let sum = Math.abs(A[left] + A[right]);
    if(min > sum){
      min = sum;
      minA = A[left];
      minB = A[right];
    }
    if(A[left] + A[right] < 0){
      left ++;
    } else {
      right --;
    }

  }
  console.log(minA+" "+minB);
}

const solve = function(){
  input();
  pro();
}

solve();