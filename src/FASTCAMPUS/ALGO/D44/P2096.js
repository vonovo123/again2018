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
let Dy_min;
let Dy_max;
const input = function (){
  N  = scanner.nextNumber();
  Dy_min = Array.from({length : 2}, () => Array.from({length : 3}, () => 0));
  Dy_max = Array.from({length : 2}, () => Array.from({length : 3}, () => 0));
}

const pro = function (){
  arr = scanner.nextLine().split(" ").map(Number);
  for(let i = 0; i < 3; i ++){
    Dy_min[1][i] = arr[i];
    Dy_max[1][i] = arr[i];
  }
  for(let i = 2; i <= N; i ++){
   arr = scanner.nextLine().split(" ").map(Number);
   for(let cur = 0; cur < 3; cur ++){
    Dy_min[i % 2][cur] = Number.MAX_VALUE;
    Dy_max[i % 2][cur] = 0;
    for(let prev = 0; prev < 3; prev ++){
      if(Math.abs(cur - prev) > 1) continue;
      Dy_max[i % 2][cur] = Math.max(Dy_max[i % 2][cur], Dy_max[(i + 1) % 2][prev] + arr[cur]);
      Dy_min[i % 2][cur] = Math.min(Dy_min[i % 2][cur], Dy_min[(i + 1) % 2][prev] + arr[cur]);
    }
   }
  }
  console.log(Math.max(Dy_max[N % 2][0], Dy_max[N % 2][1] ,Dy_max[N % 2][2]) + " " + Math.min(Dy_min[N % 2][0], Dy_min[N % 2][1] ,Dy_min[N % 2][2]));
}

const solve = function(){
  input();
  pro();
}

solve();