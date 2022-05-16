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
const scanner = new Scanner('./stdin.txt');
let N, C, P, table, min;
const input = function (){
  // 물약의 수
  N = scanner.nextNumber();
  // 물약의 가격
  C = Array.from({length : N + 1}, () => 0);
  // 할인정보
  P = Array.from({length : N + 1}, () => new Array());
  // 최소가격
  min = 0;
  scanner.nextLine().split(" ").forEach((c,i) => {
    C[i + 1] = Number(c);
    min += C[i + 1];
  })
  
  for(let i = 1; i <= N; i ++){
    let count = scanner.nextNumber();
    for(let j = 0; j < count; j ++){
      P[i].push(scanner.nextLine().split(" ").map(Number));
    }
  }
}
const bfs = function(start){
  let price = C[start];
  let visited = [start];
  let q = [start];
  while(q.length !== 0){
    let c = q.shift();
    P[c].forEach(p => {
      let [nc, discount] = p;
      let ncp = C[nc];
      ncp = (ncp - discount > 0)? ncp - discount : 1;
      if(visited.indexOf(nc) === -1){
        price += ncp;
        visited.push(nc);
        q.push(nc);  
      } 
    })
  }
  
  if(visited.length === N){
    if(min > price) min = price;
  }
}
const pro = function (){
  console.log(C);
  console.log(P);
  //for(let i = 1; i <= N; i ++){
    bfs(1);
  //}
  //console.log(min);
}

const solve = function(){
  input();
  pro();
}

solve();