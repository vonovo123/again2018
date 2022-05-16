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
let n,Dy;
const input = function (){
  n = scanner.nextNumber();
  Dy = Array.from({length: 21}, () => 0);
}

const pro = function (){
  Dy[1] = 1;
  for(let i = 2; i <= 20; i ++){
    Dy[i] = Dy[i - 1] + Dy[i - 2];
  }
  console.log(Dy[n]);
}

const solve = function(){
  input();
  pro();
}

solve();