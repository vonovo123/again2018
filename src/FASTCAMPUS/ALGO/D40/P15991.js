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
let n;
let Dy;
let MOD = 1000000009;
const input = function (){
  n = scanner.nextNumber();
}
const preprocess = function(){
  Dy[0] = 1;
  for(let i = 1; i <= 100000; i ++){
    Dy[i] = Dy[i - 1];
    if(i - 2 >= 0) Dy[i] += Dy[i - 2];
    Dy[i] %= MOD;
    if(i - 3 >= 0) Dy[i] += Dy[i - 3];
    Dy[i] %= MOD;
  }  
}
const pro = function (){
  let res = 0;
  //홀수 개
  for(let mid = 1; mid <= 3; mid ++){
    if(n - mid >= 0 && ((n - mid) % 2) === 0){ //  ((n - mid) / 2) mid ((n - mid) / 2) 형태로 대칭
      res += Dy[(n - mid) / 2];
      res %= MOD;
    }
  }

  //짝수개
  if(n % 2 === 0){
    res += Dy[n / 2];
    res %= MOD;
  }
  console.log(res);
}

const solve = function(){
  let T = scanner.nextNumber();
  Dy = Array.from({length : 100000 + 1}, () => 0);
  preprocess();
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
}

solve();