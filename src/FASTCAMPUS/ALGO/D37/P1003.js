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
let T;
let N;
let Dy;
const input = function (){
  T = scanner.nextNumber();
  N = scanner.read.map(Number);
  Dy = Array.from({length:41}, () => []);
}

const pro = function (){
  Dy[0] = [1, 0];
  Dy[1] = [0, 1];
  for(let i = 2; i <= 40; i ++){
    Dy[i][0] = Dy[i -1][0] + Dy[i - 2][0];
    Dy[i][1] = Dy[i -1][1] + Dy[i - 2][1];
  }
  N.forEach(n => {
    console.log(Dy[n][0] + " " + Dy[n][1]);
  })
}

const solve = function(){
  input();
  pro();
}

solve();