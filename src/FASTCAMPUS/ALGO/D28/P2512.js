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
//정해진 총액 이하에서 가능한 최대의 총예산
//모든 예산이 배정될 수 있는 경우 그대로
//없는경우 특수 정수 상한액을 계산하여 그 이상인 경우 모두 상한액으로 배정 이하인경우 그대로
// 지방의 수 N ( 3 <= N <= 10^4)
// 지방들 A( 1 <= A[i] <= 100000)
// 총예산 M ( 1 <= M <= 10^9)
// 상한액으 출력하시오
// 매게변수 탐색으로 해결할경우
/**
 * 최대 시간복잡도
 * 10^4(지방의 최대수) * log10^9(2)
 */
const scanner = new Scanner('stdin.txt');
let N, A, M;
const input = function (){
  N = scanner.nextNumber();
  A = scanner.nextLine().split(' ');
  M = scanner.nextNumber();
}
const determination = function(D){
  let amount = 0;
  A.forEach(a => {
    a = parseInt(a);
    if(D > a){
      amount += a;
    } else {
      amount += D;
    }
  })
  //console.log(`amount: `, amount);
  //console.log('D: ', D);
  return amount <= M;
}
const pro = function (){
  A.sort((a,b) => a-b);
  let L = N;
  let R = parseInt(A[A.length - 1]);
  let answer = 0;
  while(L <= R){
    let mid = Math.floor((L + R) / 2);
    if(determination(mid)){
      answer = mid;
      L = mid + 1;
    } else {
      R = mid - 1;
    }
  }
  console.log(answer);
}

const solve = function(){
  input();
  pro();
}

solve();