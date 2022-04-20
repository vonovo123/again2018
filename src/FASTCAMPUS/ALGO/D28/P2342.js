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
// N개의 강의
// 1<= N <= 10^5
// 강의의 순서를 바꿔선 안된다.
// i번 강의와 j번 강의를 같은 블루레이어 녹음하려면 i와 j 사이의 모든 강의를  녹화해야한다.
// M개의 블루레이
// 1 <= M <= N
// 강의의 시간을 담은 A
// 1 <= A[i] <= 10^4
// M개의 블루레이에 모든 동영상 강의를 녹화한다.
// 블루레이의 크기를 최소화하려고 한다.
// 단 M개의 블루레이의 크기는 모두 같아야한다.
// 가능한 블루레이의 크기중 최소를 구하는 프로그램

// 가능한 블루레이의 최소 크기
// 하나의 블루레이에 1분 짜리 1개 강의 1
// 가능한 블루레이의 최대 크기
//하나의 블루레이에 모든강의(10000분 짜리 100000개) 최대 크기  1000000000(10억);
let N,M,A;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  A = scanner.nextLine().split(' ');
  A = A.map(a => parseInt(a));
}
const determination = function(D){
  let cnt = 1;
  let sum = 0;
  A.forEach(a => {
    if(sum + a > D){
      cnt += 1;
      sum = a;
    } else {
       sum += a;
    }
  })
  return cnt <= M;
}
const pro = function (){
  A.sort((a,b) => a - b);
  console.log(A);
  let L = A[A.length - 1];
  console.log(L);
  let R = 1000000000;
  let result = 0
  while(L <= R){
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