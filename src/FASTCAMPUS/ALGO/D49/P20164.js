const fs = require('fs');
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
let N, min, max;
const input = function (){
  max = 0;
  min = Number.MAX_VALUE;
  N = scanner.next();
}
const divide = function(val, count){
  let length = val.length; 
  for(let i = 0; i < val.length; i ++){
    if(val[i] % 2 === 1) count += 1;
  }
  if(length === 1){
    if(max < count) max = count;
    if(min > count) min = count;
  } else if(length === 2){
    divide(Number(val[0]) + Number(val[1]) + "", count);
  } else {
    for(let x = 1; x <= length; x ++){
      for(let y = 1; y <= length; y ++){
        for(let z = 1; z <=length; z ++){
          if(x + y + z === length){
            let a = Number(val.substr(0,x));
            let b = Number(val.substr(x,y));
            let c = Number(val.substr(x + y));
            let sum = (a + b + c) + ""
            divide(sum, count)
          }
        }
      }
    }
  }
}
const pro = function (){
  let count = 0;
  divide(N, count);
  console.log(min, max);
}

const solve = function(){
  input();
  pro();
}

solve();