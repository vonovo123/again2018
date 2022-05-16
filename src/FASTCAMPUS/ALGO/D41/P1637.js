const fs = require('fs');
const { isConditionalExpression } = require('typescript');
class Scanner {
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().trim().split('\n');
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
let N;
let infos;
const input = function (){
  N = scanner.nextNumber();
  infos = scanner.read.splice(0).map(v => v.split(" ").map(Number));;
}
const count = function (value){
  let total = 0;
  let A,B,C;
  infos.forEach(info => {
    [A,C,B] = info;
    if(value < A) return 0;
    if(C < value ) total += Math.floor((C - A) / B) + 1;
    else  total += Math.floor((value - A) / B) + 1;
  })
  return total;
}

const determination = function(value){

  return count(value) % 2 === 1;
}

const pro = function (){
  let left = 1; right = N;
  let answer = 0;
  while(left <= right){
    let mid = Math.floor((left + right) / 2);
    if(determination(mid)){
      answer = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  if(answer === 0) console.log("NOTHING")
  else console.log(answer + " " + (count(answer) - count(answer - 1)));
}

const solve = function(){
  input();
  pro();
}

solve();