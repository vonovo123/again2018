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
let T, K, A, sum, Dy;
const input = function (){
  K = scanner.nextNumber();
  A = [0, ...scanner.nextLine().split(" ").map(Number)];
  sum = Array.from({length : K + 1}, () => new Array(K + 1).fill(0));
  Dy = Array.from({length : K + 1}, () => new Array(K + 1).fill(0));
}

const pro = function (){
  for(let i = 1; i <=K; i ++){
    for(let j = i; j <= K; j ++){
      sum[i][j] = sum[i][j - 1] + A[j];
    }
  }
  for(let len = 2; len <= K; len ++){
    for(let i = 1; i <= K - len + 1; i ++){
      let j = i + len - 1;
      Dy[i][j] = Number.MAX_VALUE;
      for(let k = i; k <= j - 1; k ++){
        Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k + 1][j] + sum[i][j]);
      } 
    }
  }
  console.log(Dy[1][K]);
}

const solve = function(){
  T = scanner.nextNumber();
  for(let i = 0; i < T; i ++){
    input();
    pro();  
  }
  
}

solve();