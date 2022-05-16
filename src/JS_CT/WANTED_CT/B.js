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
let N, Q, A;
const input = function (){
  // 집의수, 놀이의 수
  [N, Q] = scanner.nextLine().split(" ").map(Number);
  // 집별 대문 값, 도로정보 
  A = Array.from({length: N + 1}, () => ({value : '', node : []}));
  scanner.nextLine().split(" ").map(Number).forEach((a, idx) => {
    A[idx + 1].value = a;
  })
  scanner.read.splice(0, N - 1).forEach(edge => {
    let[from, to] = edge.split(" ").map(Number);
    A[from].node.push(to)
    A[to].node.push(from)
  })
  //console.log(A);
}
const dfs = function(start, visited, template, end){
  if(start === end){
    console.log(template % 1000000007);
    return;
  }
  if(visited.length === N) return;
  A[start].node.forEach(v => {
    if(visited.indexOf(v) !== -1) return;
    let newTemplate = template + "" + A[v].value;
    dfs(v, [...visited, v], newTemplate, end);
  })
}
const pro = function (){
  scanner.read.splice(0, Q).forEach( q => {
    let [start, end] = q.split(" ").map(Number);
    //console.log(start, end);
    let visited = [start];
    let template = '' + A[start].value;
    dfs(start, visited, template, end);
  })
}

const solve = function(){
  input();
  pro();
}

solve();