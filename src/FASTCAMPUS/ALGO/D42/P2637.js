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
let N, M;
let adjust, indeg, element,count;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  let info = scanner.read.splice(0);
  adjust = Array.from({length : N + 1}, () => []);
  indeg = Array.from({length : N + 1}, () => 0);
  count = Array.from({length : N + 1}, () => Array.from({length: N + 1}, () => 0));
  info.forEach(i => {
    //X := 완제품 Y := 부붐 K := 갯수
    let [X, Y, K] = i.split(" ").map(Number);
    indeg[X] ++;
    adjust[Y].push([X,K]);
    
  })
  //console.log(adjust);
  //console.log(indeg);
}

const pro = function (){
  let Q = [];
  indeg.forEach((v,i) => {
    if(i === 0) return;
    if(v === 0) {
      Q.push(i)
      count[i][i] = 1;
    };
    
  })
  //console.log(count);
  while(Q.length !== 0){
    let pop = Q.shift();
    adjust[pop].forEach(([adj, cnt]) => {
      count[pop].forEach((v, i) => {
        if(v > 0){
          count[adj][i] += v*cnt;
        }
      })
      indeg[adj] --;
      if(indeg[adj] === 0)Q.push(adj);
    })
  }
  let answer = '';
  count[N].forEach((v, i) => {
    if(v !== 0){
      answer += `${i} ${v}\n`;
    }
  })
  console.log(answer.trim());
}

const solve = function(){
  input();
  pro();
}

solve();