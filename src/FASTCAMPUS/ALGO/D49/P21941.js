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
let S, len, ava, M, info, DP;
const input = function (){
  S = scanner.next();
  len = S.length;
  ava = Array.from({length : len}, () => []);
  M = scanner.nextNumber();
  info = scanner.read.splice(0);
  DP = Array.from({length : len + 1}, () => 0);
}

const pro = function (){
  info.forEach(inf => {
    let [a, x] = inf.split(" ")
    let score = Number(x);
    let strlen = a.length;
    if(score <= strlen) return;
    let idx = 0;
    while(idx < len) {
      let cur = S.indexOf(a, idx);
      if(cur === -1) break;
      ava[cur].push([strlen, score]);
      idx = cur + 1;
    }
  })
  for(let i = 0; i < len; i ++){
    for(let j = 0; j < ava[i].length; j ++){
      let size = ava[i][j][0];
      let score = ava[i][j][1];
      DP[i + size] = Math.max(DP[i + size], DP[i] + score);
    }
    DP[i + 1] = Math.max(DP[i + 1], DP[i] + 1);
  }
  console.log(DP[len]);
}

const solve = function(){
  input();
  pro();
}

solve();