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
let N;
let arr;
let Dy;
const input = function (){
  N = scanner.nextNumber();
  arr = Array.from({length : 2}, () => []);
  Dy = Array.from({length : N}, () => Array.from({length : 3}, () => 0));
  let info = scanner.read.splice(0, 2);
  info.forEach((t, idx) => {
    arr[idx] = t.split(" ").map(Number);
  })
  
}

const pro = function (){
  //console.log(arr);
  //0 : 제거안함, 1 : 윗부분 제거, 2: 아랫부분 제거
  Dy[0][0] = 0;
  Dy[0][1] = arr[0][0];
  Dy[0][2] = arr[1][0];
  
  for(let i = 1; i < N; i ++){
    Dy[i][0] = Math.max(Dy[i-1][0], Dy[i-1][1], Dy[i-1][2]);
    Dy[i][1] = Math.max(Dy[i-1][0], Dy[i-1][2]) + arr[0][i];
    Dy[i][2] = Math.max(Dy[i-1][0], Dy[i-1][1]) + arr[1][i];
  }
  console.log(Math.max(Dy[N - 1][0], Dy[N - 1][1], Dy[N - 1][2]));
}

const solve = function(){
  let T = scanner.nextNumber();
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
  
}

solve();