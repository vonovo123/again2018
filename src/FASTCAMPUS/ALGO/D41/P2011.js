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
let code;
let Dy;
let count;
let check;
const input = function (){
  code = scanner.nextLine().split('').map(Number);
  check = Array.from({length : code.length}, () => 0);
  Dy = Array.from({length : code.length}, () => 0);
  count = 0;
}
const preprocess = function(){
  for(let i = 0; i < code.length; i ++){
    if(i + 1 < code.length){
      if(code[i] === 1){
        check[i] = 1;
      } 
      if(code[i] === 2){
        if(code[i + 1] < 7){
          check[i] = 1;
        }
      }
    }
  }
}
const pro = function (){
  preprocess();
  
  if(code[0] !== 0) Dy[0] = 1;
  for(let i= 1 ; i < code.length; i ++){
    if(code[i] !== 0)Dy[i] = Dy[i - 1];
    //이전문자와 하나의 수로 해석가능한 경우
    if(check[i - 1] === 1){
      if(i > 1){
        Dy[i] += Dy[i - 2];
      } else {
        Dy[i] += 1;
      }
      Dy[i] %= 1000000;
    }
    
  }
}

const solve = function(){
  input();
  pro();
  console.log(Dy[code.length - 1]);
}

solve();