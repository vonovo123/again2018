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
// N 개로 이루어진 수열 A
// N - 1 개의 연산자(+ - * /)
// 완전 탐색의 경우
// 연산자 종류 4 / 연산자 카드의 수 N - 1
// 시간 복잡도 : 각 카드는 중복 불가 / 순서가 다르면 다른 케이스  O(N!/(N-M)!)
// Max N = 11 N = M
// 10!
let N;
const inputArray = [0,];
const operations = [0,];
let max = -1000000000;
let min = 1000000000;
const input = async function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  for(let i = 1; i <= N ; i ++){
    inputArray.push(scanner.nextNumber());
  }
  for(let i = 1; i <=4; i ++){
    operations.push(scanner.nextNumber());
  }
}

input().then(() => {
  rec_func(1, inputArray[1]).then(() => {
    console.log(max);
    console.log(min);
  });
});
const calulate = function(operation, value, k){
  const next = inputArray[k + 1];
  if(operation === 1){
    value += next;
  } else if(operation === 2){
    value -= next;
  } else if(operation === 3){
    value *= next;
  } else if(operation === 4){
    if(value / next < 0){
      value = Math.ceil(value / next);
    } else {
      value = Math.floor(value / next);
    }
    
  }
  return value;
}

const rec_func = async function(k, value){
  if(k === N){
    if(min > value) min = value;
    if(max < value) max = value;
  } else {
    for(let i = 1; i <= 4; i ++){
      if(operations[i]> 0){
        operations[i] --;
        rec_func(k + 1, calulate(i, value, k));
        operations[i] ++;
      }
    }
  }
}


