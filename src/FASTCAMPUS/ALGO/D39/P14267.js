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
let n, m;
let A, parents, T, point;
const input = function (){
  [n, m] = scanner.nextLine().split(" ").map(Number);
  A = Array.from({length : n + 1}, () => new Array());
  point = Array.from({length : n + 1}, () => 0);
  parents = [0, ...scanner.nextLine().split(" ").map(Number)];
  T = scanner.read.splice(0, m).map(t => t.split(" ").map(Number));
}
// const dfs = function(parent, p){
//   A[parent].forEach(child => {
//     point[child] += p;
//     dfs(child, p); 
//   })
// }
const pro = function (){
  //console.log(A);
  T.forEach(([c, p])  => {
    point[c] += p;
  })
  
  for(let i = 2; i <= n; i ++){
    point[i] += point[parents[i]];
  }
  let answer = ""
  for(let i = 1; i <= n; i ++){
    answer += point[i] + " ";
  }
  console.log(answer.trim());
}

const solve = function(){
  input();
  pro();
}

solve();