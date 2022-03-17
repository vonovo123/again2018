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
let T, N ,parent, A, B, check;
const input = function (){
  N = scanner.nextNumber();
  let table = scanner.read.splice(0, N - 1);
  [A, B] = scanner.nextLine().split(" ").map(Number);
  parent = Array.from({length: N +1}, () => null);
  check = Array.from({length: N +1}, () => null);
  table.forEach(e => {
    let[a, b] = e.split(" ").map(Number);
    parent[b] = a;
  })
}

const pro = function (){
  check[A] = 1;
  while(parent[A]){
    A = parent[A];
    check[A] = 1;
  }
  while(B){
    if(check[B] === 1){
      console.log(B);
      break;
    }
    B = parent[B];
  }

}

const solve = function(){
  T = scanner.nextNumber();
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
  
}

solve();