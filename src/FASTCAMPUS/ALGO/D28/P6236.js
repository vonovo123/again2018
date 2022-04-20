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
// N일동안 M번만 돈을 인출한다.
// K원을 인출해서 하루를 보낼 수 있으면 그대로 사용하고
// 모자라면 다시 넣고 K원을 인출한다.
// 정확히 M번을 맞추기위해 남은 금액(모자란경우)이 그날 사용할 금액보다 많더라도 다시 집어넣고 K원을 인출할 수 있다.
// 최소금액 K 를 구하라
let N, M, A
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  A = [...scanner.read];
}
const determination = function(withdrawl){
  let cnt = 1, sum = 0;
  for (let i = 0; i < N; i++) {
      if (sum + A[i] > withdrawl) {
          cnt++;
          sum = A[i];
      } else {
          sum += A[i];
      }
  }
  return cnt <= M;
}
const pro = function (){

  A = A.map(a => parseInt(a));
  let L = A[0]
  A.forEach(a => {
      if(L < a) L = a;
  })
  let R = 10000;
  let result = 0;  
  while(L <= R ){
    let mid = Math.floor((L + R) / 2);
    if(determination(mid)){
      result = mid;
      R = mid - 1;
    } else {
      L = mid + 1;
    }
  }
  
  console.log(result);
}

const solve = function(){
  input();
  pro();
}

solve();