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

let N, M;
const selected = [0,];
let stringBuilder = "";
//1에서 N 까지 자연수 중 M개를 고른 수열 
//중복가능 / 비내림차순이기 때문에 순서가 달라도 하나의 케이스임
//시간복잡도 N^M 보다 작음
const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  M = scanner.nextNumber();
}

const rec_func = function(k){
  if( k === M + 1){
    for(let i = 1; i < k; i ++){
      stringBuilder += (selected[i] + " ");
    }
    stringBuilder += `\n`;
  } else {
    for( let i = 1; i <= N; i ++ ){
      if(k > 1){
        if(selected[k - 1] > i){
          continue;
        }
      } 
      selected.push(i);
      rec_func(k + 1);
      selected.pop();
    }
  }
}
input();
rec_func(1);
console.log(stringBuilder);

