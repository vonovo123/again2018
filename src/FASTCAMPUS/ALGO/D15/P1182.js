//시간복잡도 N^M (worst 7^7)
const fs = require('fs');
class Scanner {
  read
  stringToken
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

// N개의 정수로 이루어진 수열 A
// 부분수열의 최대 개수 N
// 다 더한 값이 S가 되는 경우의 수 count
//N의 최대값은 20
// S의 최대값은 1000000
// 수열의 모든 요소의 합의 최댓값은 2000000 => int 범위내
// 완전탐색의경우
// 0과 1 카드를 중복가능하고 순서가 다르면 다른 케이스로 구하기
//O(N^M)
// N : [0, 1], max M : 20 max S : 1000000  |Ai| < 100000
let N, S, count;
const A = [0,];
const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  S = scanner.nextNumber();
  count = 0;
  for(let i = 1; i <= N; i ++){
    A[i] = scanner.nextNumber();
  }
}
const rec_func = function(k, value) {
  if(k == N + 1){
    if(value === S){
      count ++;
    }
  } else {
    rec_func(k + 1, value + A[k]);
    rec_func(k + 1, value);
  }
}
input();
rec_func(1, 0);
if(S === 0) count --;
console.log(count);
s

