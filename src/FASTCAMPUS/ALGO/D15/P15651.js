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


// 1 부터 N 까지의 자연수 중 M 개를 고른 수열
// 같은 수를  여러번 골라도 됨 : 중복가능
// 순서가 다르면 다른 수열 : 순서 YES 
// 시간 복잡도 N^M
// Max N : 7 | Max M : 7
// worst case 7^7
// 시간 제한 1초 
// brute force
let N;
let M;
let selected = [0,];
let stringBuilder = "";
const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  M = scanner.nextNumber();
}

const rec_func = function( k ){
  if(k === M + 1){
    for(let i = 1; i < k; i ++){
      stringBuilder += (selected[i] + " ");
    }
    stringBuilder += `\n`;
  } else {
    for(let i = 1; i <= N; i ++){
      selected.push(i);
      rec_func(k + 1);
      selected.pop();
    }
  }
}
input();

rec_func(1);
console.log(stringBuilder)
