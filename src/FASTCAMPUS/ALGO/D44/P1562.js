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
let Dy;
const input = function (){
  N = scanner.nextNumber();
  //Dy[i][j][low][high];
  // i : 자리수
  // j : 끝 자리의 수
  // low : 수에 포함되는 0~9 즁 가장 작은 수
  // high : 수에 포함되는 0~9 중 가장 큰 수
  Dy = Array.from({length : 101}, () => Array.from({length: 10}, () => Array.from({length: 10}, () => Array.from({length: 10}, () => 0))));
}
let mod = 1000000000;
const pro = function (){
    for(let i = 1; i <= 9; i ++){
      Dy[1][i][i][i] = 1;
    }

    for(let i = 2; i <= 100; i ++){
      for(let j = 0; j<= 9; j ++){
        for(let low = 0; low <=9; low ++){
          for(let high = 0; high <= 9; high ++){
            //console.log(i,j,low,high);
            if(j === 0){
              Dy[i][j][Math.min(low, j)][Math.max(high, j)] = (Dy[i][j][Math.min(low, j)][Math.max(high, j)] + Dy[i - 1][j + 1][low][high] ) % mod; 
            } else if( j === 9){
              Dy[i][j][Math.min(low, j)][Math.max(high, j)] = (Dy[i][j][Math.min(low, j)][Math.max(high, j)] + Dy[i - 1][j - 1][low][high] ) % mod;
            } else {
              Dy[i][j][Math.min(low, j)][Math.max(high, j)] = (Dy[i][j][Math.min(low, j)][Math.max(high, j)] + Dy[i - 1][j + 1][low][high] ) % mod;
              Dy[i][j][Math.min(low, j)][Math.max(high, j)] = (Dy[i][j][Math.min(low, j)][Math.max(high, j)] + Dy[i - 1][j - 1][low][high] ) % mod;
            }
          }
        }
      }
    }
    let sum = 0;
    for(let i = 0; i <= 9; i ++){
      sum = (sum + Dy[N][i][0][9])%mod;
    }
    console.log(sum)
    
}

const solve = function(){
  input();
  pro();
}

solve();