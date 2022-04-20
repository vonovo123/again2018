const fs = require('fs');
class Scanner {
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().split('\n');
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
let N, A, M, B;
const input = function (){
  N = scanner.nextNumber();
  A = scanner.nextLine().split(' ');
  M = scanner.nextNumber();
  B = [];
  B = scanner.nextLine().split(' ');
  A = A.map(v => parseInt(v));
  B = B.map(v => parseInt(v));
}
const lower_bound = function(A, L, R, D){
  let result = R + 1;
  while(L <= R){
    let MID = parseInt((L + R) / 2);
    if(A[MID] < D){
      L = MID + 1;
    } else {
      result = MID;
      R = MID - 1;
    } 
  }
  return result;
}
const high_bound = function(A, L , R, D){
  let result = R + 1;
  while(L <= R){
    let MID = parseInt((L + R) / 2);
    if(A[MID] <= D){
      L = MID + 1;
    } else {
      R = MID - 1;
      result = MID;
      
    } 
  }
  return result;
}

const pro = function (){
  A.sort((a,b) => a - b);
  console.log(A);
  let answer = [];
  for(let i = 0; i < M; i ++){
    let D = B[i]; 
    let high = high_bound(A, 0, N - 1, D);
    let lower = lower_bound(A, 0, N - 1, D);
    console.log(D);
    console.log(`lower`, lower)
    console.log(`high`, high)
      answer.push(high - lower);
  }
  console.log(answer.join(" "));
}

const solve = function(){
  input();
  pro();
}

solve();