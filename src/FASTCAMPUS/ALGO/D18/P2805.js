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
let N, M, A;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  A = [];
  A = scanner.nextLine().split(' ');
  console.log(A);
  // for(let i = 0; i < N; i ++){
  //   A[i] = scanner.nextNumber();
  // }
}
const cut = function(H){
  let sum = 0;
  for(let i = 0; i < N; i ++){
    if(A[i] <= H) continue;
    sum += A[i] - H;
  }
  return sum
}
const search = function(){
  let L = 0;
  let R = 1000000000;
  let answer = 0;
  while(L <= R){
    let mid = parseInt((L + R) / 2);
    if(cut(mid) < M){
      R = mid - 1;
    } else {
      L = mid + 1;
      answer = mid;
    }
  }
  console.log(answer);
}
const pro = function (){
  search();
}

const solve = function(){
  input();
  pro();
}

solve();