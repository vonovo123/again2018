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
const L = scanner.nextNumber();
const C = scanner.nextNumber();
const A = [];
for(let i = 0; i < C; i ++ ){
  A[i] = scanner.next();
  
}
A.sort((a,b) => {
  return a.charCodeAt(0) - b.charCodeAt(0);
});
let answer = '';
const moTable = 'aeiou';
function dfs(idx, arr, ja, mo){
  if(arr.length === L){
      console.log(arr);
      console.log(ja,mo);
    if(ja >= 2 && mo >= 1){
      answer += arr.join('');
      answer += "\n";
      console.log(answer);
      console.log(ja,mo);
    }
    return;
  }
  if(idx >= C) return;
  arr.push(A[idx]);
  if(moTable.indexOf(A[idx]) != -1){
    dfs(idx + 1, arr, ja, mo + 1);
  } else {
    dfs(idx + 1, arr, ja + 1, mo);
  }
  arr.pop();
  dfs( idx + 1, arr, ja, mo);
}

dfs(0,[], 0, 0);
console.log(answer.trim());