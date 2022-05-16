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
let T;
let N;
let A;
const input = function (){
  T = scanner.nextNumber();
  N = [];
  for(let i = 0; i < T; i ++){
    N.push(scanner.nextNumber());
  }
  A = Array.from({length : 11}, ()=> 0);
  console.log(A);
}

const pro = function (){
  A[1] = 1;
  A[2] = 2;
  A[3] = 4;

}

const solve = function(){
    input();
    pro();
}

solve();