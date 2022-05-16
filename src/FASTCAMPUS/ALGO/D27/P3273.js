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
let n, a, X;
const input = function (){
  n = scanner.nextNumber();
  a = scanner.nextLine().split(" ");  
  X = scanner.nextNumber();
  //a = a.map(v => parseInt(v));
}
const bin_search = function(a, L, R, D){
  while(L <= R){
    let mid = parseInt((L + R) / 2);
    if(a[mid] < D){
      L = mid + 1;
    } else if( D < a[mid]){
      R = mid - 1;
    } else {
      return true;
    }
  }
  return false;
}
const pro = function (){
  let count = 0
  a.sort((a,b)=> a - b);
  for(let i = 0; i < n; i ++){
    let D = X - a[i];
    let L = i + 1;
    let R = n - 1;
    
    if(bin_search(a,L,R,D)){
      count += 1;
    }
  }
  console.log(count);
}

const solve = function(){
  input();
  pro();
}

solve();