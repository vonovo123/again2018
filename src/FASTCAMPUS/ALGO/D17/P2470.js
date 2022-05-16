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
let N, A;
const input = function (){
  N = scanner.nextNumber();
  A = [];
  for(let i = 0; i < N; i ++){
    A[i] = scanner.nextNumber();
  }
  A.sort((a,b) => a - b);
  console.log(A);
}

const low_bound = function(A,L,R,T){
  let result = L - 1;
  while(L <= R){
    let mid = parseInt((L + R) / 2);
    if( A[mid] <= T){
      result = mid;
      L = mid + 1;
    } else {
      R = mid - 1;
    }
  }
  return result;
}
const pro = function (){
  let min = Number.MAX_VALUE;
  let a = 0;
  let b = 0;
  for(let i = 0; i < N; i ++){
    let result = low_bound(A, 0, N - 1, -A[i]);
    //sconsole.log(`idx : ${i}, result : ${result}`);
    if(result >= 0 && result != i){
      if(min > Math.abs(A[i] + A[result])){
        min = Math.abs(A[i] + A[result]);
        a = A[i];
        b = A[result]
      }
    }
    if(result + 1 < N && result + 1 != i){
      if(min > Math.abs(A[i] + A[result + 1])){
        min = Math.abs(A[i] + A[result + 1]);
        a = A[i];
        b = A[result + 1]
      }
    }
  }
  if(a < b){
    console.log(a + " " + b);
  } else {
    console.log(b + " " + a);
  }
}

const solve = function(){
  input();
  pro();
}
solve();
