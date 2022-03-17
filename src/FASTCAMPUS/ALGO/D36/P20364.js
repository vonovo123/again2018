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
let N, Q, duck;
let tree;
const input = function (){
  N = scanner.nextNumber();
  Q = scanner.nextNumber();
  tree = Array.from({length: N + 1}, () => false);
  duck = scanner.read.map(Number)
}

const pro = function (){
  console.log(tree);
  console.log(duck);
  duck.forEach(d => { 
    let res = 0;
    let c = d;
    while(d > 0){
      if(tree[d]) res = d;
      d /= 2;
    }
    tree[c] = true;
    console.log(res);
  })
}

const solve = function(){
  input();
  pro();
}

solve();