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
let T, K, M, P, edges, child, indeg, order, max;
const input = function (){
  [K, M, P] = scanner.nextLine().split(" ").map(Number);
  edges = scanner.read.splice(0, P);
  //나가는 노드
  child = Array.from({length: M + 1}, () => new Array());
  //들어오는 노드
  indeg = Array.from({length: M + 1}, () => 0);
  max = Array.from({length: M + 1}, () => 0);
  order = Array.from({length: M + 1}, () => 0);
  edges.forEach(e => {
    let [from, to] = e.split(" ").map(Number);
    child[from].push(to);
    indeg[to] ++;
  })
  //console.log(child)
  //console.log(indeg)
}

const pro = function (){
  let Q = [];
  indeg.forEach((v, idx) => {
    if(idx === 0 ) return;
    if(v !== 0) return;
    Q.push(idx);
    order[idx] = 1;
    max[idx] = 1;
  })
  while(Q.length !== 0){
    let pop = Q.shift();
    if(max[pop] >= 2) order[pop] += 1;
    child[pop].forEach(c => {
      indeg[c] --;
      if(indeg[c] === 0) Q.push(c);
      if(order[c] < order[pop]){
        order[c] = order[pop];
        max[c] = 1;
      }  else if(order[c] === order[pop]){
        max[c] += 1;
      }
    })  
  }
  console.log(`${K} ${order[M]}`);
}


const solve = function(){
  T = scanner.nextNumber();
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
}

solve();