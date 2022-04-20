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
let N, S, A;
let min = 100000;
const input = function (){
  N = scanner.nextNumber();
  S = scanner.nextNumber();
  A = scanner.nextLine().split(" ");
  A = A.map(a => parseInt(a));
}

const pro = function (){
  let sum = 0;
  let R = 0
  for(let L = 0; L < A.length; L ++){
    if(L  > 0){
      sum -= A[L - 1];
    }
    while(R < A.length  && sum < S){
      sum +=  A[R];
      R ++;
    }
    if(sum >= S){
      min = Math.min(min, R - L);
    }
    
  }
  console.log(min);
}

const solve = function(){
  input();
  pro();
}

solve();