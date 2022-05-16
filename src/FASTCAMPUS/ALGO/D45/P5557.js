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
let A, Dy;
const input = function (){
  N = scanner.nextNumber();
  A = [0, ...scanner.nextLine().split(" ").map(Number)];
  Dy = Array.from({length : N + 1}, () => Array.from({length :21}, () => 0))
}

const pro = function (){
  Dy[1][A[1]] = 1;
  for(let i = 2; i <= N - 1; i ++){
    let target = A[i];
    for(let prev = 0; prev <= 20; prev ++){
       [prev + target, prev - target].forEach(cur => {
          if(cur < 0 ||cur > 20 ) return;
          Dy[i][cur] += Dy[i - 1][prev];
       })
    }
  }
  console.log(Dy[N - 1][A[N]]);
}

const solve = function(){
  input();
  pro();
}

solve();