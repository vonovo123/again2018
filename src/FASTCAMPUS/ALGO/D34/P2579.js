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

let N, A, table;
const input = function (){
  N = scanner.nextNumber();
  A=[0];
  for(let i = 1; i <= N ; i ++){
    A[i] = scanner.nextNumber()
  }
  table = Array.from({length : N + 1}, () => new Array());
}

const pro = function (){
  //0 : 2칸전에서 오는경우
  //1 : 1칸전에서 오는경우
  table[1][0] = 0;
  table[1][1] = A[1];
  if(N >= 2){
    table[2][0] = A[2]; 
    table[2][1] = A[1] + A[2];
  }
  
  for(let i = 3; i <= N ; i ++){
    //전계단을 안밟는 경우는 
    table[i][0] = Math.max(table[i-2][0], table[i-2][1]) + A[i];
    //전계단을 밟는 경우는 전전 계단을 안밟는 경우만 가능
    table[i][1] = table[i - 1][0] + A[i];
  }
  console.log(Math.max(table[N][0], table[N][1]));
}

const solve = function(){
  input();
  pro();
}

solve();