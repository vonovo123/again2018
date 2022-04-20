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
const scanner = new Scanner('./stdin.txt');
// n : 정점의 수  m : 간선의 수
let tt, n, m, parents, info;

const input = function (){
  parents = Array.from({length: n + 1},(_, i) => i);
  info = scanner.read.slice(0, m);
  scanner.read = scanner.read.slice(m); 
  
}

const pro = function (){
  info.forEach(e => {
    let [a, b] = e.split(" ").map(Number);
    union(a,b);
  })
  let count = [];
  for(let i = 1; i <= n; i ++){
    if(find(i) !== 0 && count.indexOf(find(i)) === -1){
      count.push(find(i));
    }
  }
  let ans = count.length;
  let sb = '';
  sb += ("Case ");
  sb += tt;
  sb += ": ";
  if (ans == 0){
      sb += "No trees.";
  } else if (ans == 1){
      sb += ("There is one tree.");
  } else {
      sb += "A forest of ";
      sb += ans;
      sb += " trees.";
  }
  console.log(sb);
}
function union(a, b){
  let ra = find(a);
  let rb = find(b);
  if(ra === rb){
    parents[ra] = 0;
    return;
  } 
  if(ra < rb){
    parents[rb] = ra;
  } else {
    parents[ra] = rb;
  }
}
function find(x){
  if(parents[x] === x) return x;
  return find(parents[x]);
}
const solve = function(){
  tt = 0;
  while(true){
    let [v, e] = scanner.nextLine().split(" ").map(Number);
    if(v === 0 && e === 0) break;
    n = v;
    m = e;
    tt ++;
    input();
    pro();
  }
  
}

solve();