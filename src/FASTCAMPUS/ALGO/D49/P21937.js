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
let N, M;
let need, needed;
let X;
const input = function (){
  [N,M] = scanner.nextLine().split(" ").map(Number);
  need = Array.from({length : N + 1}, () => 0);
  used = Array.from({length : N + 1}, () => 0);
  needed = Array.from({length : N + 1}, () => []);
  let infos = scanner.read.splice(0, M);
  infos.forEach(info => {
    [A, B] = info.split(" ").map(Number);
    need[A] ++ 
    needed[B].push(A);
  })
  X = scanner.nextNumber();
  //console.log(need);
  //console.log(needed);
}

const pro = function (){
  let Q = [];
  let count = 0;
  Q.push(X);
  while(Q.length !== 0){
    let pop = Q.pop();
    for(let i = 0; i < needed[pop].length; i ++){
      let v = needed[pop][i];
      if(used[v] === 0){
        count ++;
        used[v] = 1;
      }
      if(needed[v].length > 0){
        Q.push(v);
      }
        
    }
  }  
console.log(count);
}

const solve = function(){
  input();
  pro();
}

solve();