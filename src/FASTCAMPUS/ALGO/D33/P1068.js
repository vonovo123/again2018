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
// N : 노드의 개수 ( 1 <= N <= 50 )
// A 0번 노드부터 N-1번 노드까지의 부모
// D : 지울 노드의 번호
let N, A, D, tree;
const input = function (){
  N = scanner.nextNumber();
  A = scanner.nextLine().split(" ").map(Number);
  D = scanner.nextNumber();
  tree = Array.from({length: N}, () => []);
}
const pro = function (){
  A.forEach((v,i) => {
    if(v === -1) return;
    tree[v].push(i);
  })
  tree.forEach((vertices, i) => {
    if(i === D){
        let cand = [...vertices];
        while(cand.length != 0){
          let pop = cand.shift();
          cand = [...cand, ...tree[pop]];
          tree[pop] = null;
        }
        vertices.forEach(v => {
          tree[v] = null;
        })
        tree[i] = null;
    } else {
        if(vertices && vertices.indexOf(D) !== -1){
          vertices.splice(vertices.indexOf(D), 1);
        }
    }
  })
  let count = 0;
  tree.forEach(v =>{
    if(Array.isArray(v) && v.length === 0){
      count ++;
    }
  })
  console.log(count);
}
const solve = function(){
  input();
  pro();
}

solve();