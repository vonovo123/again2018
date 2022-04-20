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
let N, S, M;
let A, Dy;
const input = function (){
  [N,S,M] = scanner.nextLine().split(" ").map(Number);
  A = [0, ...scanner.nextLine().split(" ").map(Number)];
  Dy = Array.from({length : N + 1}, () => Array.from({length : M + 1}, () => 0));
}

const pro = function (){
    if(S + A[1]<= M){
      Dy[1][A[1] + S] = 1;
    }
    if(S - A[1] >= 0){
      Dy[1][A[1] - S] = 1;
    }
  for(let i = 2; i <= N; i ++){
    let V = A[i];
    for(let prev = 0; prev <= M; prev ++){
      if(prev + V <= M){
        if(Dy[i - 1][prev] !== 0) Dy[i][prev + V] = Dy[i - 1][prev];
      }
      if(prev - V >= 0){
        if(Dy[i - 1][prev] !== 0) Dy[i][prev - V] = Dy[i - 1][prev];
      }
    }
  }
  let answer = -1;
  Dy[N].forEach((v,idx) => {
    if(v !== 0) answer = idx;
  })
  console.log(answer);
}

const solve = function(){
  input();
  pro();
}

solve();