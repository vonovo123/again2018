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
const T = scanner.nextNumber();
let N,M,A,B;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  A = [];
  B = [];
  for(let i = 0; i < N; i ++){
    A[i] = scanner.nextNumber();
  }
  for(let i = 0; i < M; i ++){
    B[i] = scanner.nextNumber();
  }
}
//X미만의 수 중 제일 오른쪽 인덱스를 구하는 함수
const lower_bound = function(A, L, R, X){
  let result = L - 1;
  while(L <= R){
    let mid = parseInt((L + R) / 2);
    if(A[mid] < X){
      result = mid;
      L = mid + 1;
    } else {
      R = mid - 1;
    }
  }
  return result + 1;
}

const pro = function (){
  B.sort((a,b) => a-b);
  let answer = 0;
  for(let i = 0; i < A.length; i ++){
    answer += lower_bound(B, 0, B.length - 1, A[i]);
  }
  console.log(answer)
}

const solve = function(){
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
}

solve();