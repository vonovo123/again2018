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
let K,N,A;
const input = function (){
  K = scanner.nextNumber();
  N = scanner.nextNumber();
  A = [...scanner.read];
  console.log(A);
}
const determination = function(A, D){
  let sum = 0;
  A.forEach(k => {
    sum += Math.floor(k/D);
  })
  console.log(`D: ${D}, sum : ${sum}`);
  return sum >= N;
}
const pro = function (){
  let L = 1;
  let R = Math.pow(2,31) - 1;
  let result = 0;
  while(L <= R){
    let mid = Math.floor((L+R) / 2);
    if(determination(A,mid)){
      L = mid + 1;
      result = mid;
    } else {
      R = mid - 1;
    }
  }
  console.log(result);
}

const solve = function(){
  input();
  pro();
}

solve();