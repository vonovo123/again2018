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
let arr;
let Dy;
const input = function (){
  T = scanner.nextNumber();
  arr = scanner.read.splice(0).map(Number);
  Dy = Array.from({length : 10}, () => Array.from({length:65}, () => 0));
  
}

const pro = function (){
  //각 수가 하나씩만 있는경우
  for(let i = 0; i <= 9; i ++){
    Dy[i][1] = 1;
  }
  // 각자리수가 0만 있는경우
  for(let i = 1; i <= 64; i ++){
    Dy[0][i] = 1;
  }
  for(let i = 1; i <= 64; i ++){
    for(let j = 1; j <= 9; j ++){
      Dy[j][i] = Dy[j- 1][i] + Dy[j][i - 1];
    }
  }
  
  arr.forEach(a => {
    let sum = 0
    for(let i = 0; i <10; i++){
      sum += Dy[i][a];
    }
    console.log(sum);
  })
  
  
}

const solve = function(){
  input();
  pro();
  
}

solve();