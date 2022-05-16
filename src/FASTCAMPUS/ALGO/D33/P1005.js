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
// 테스트 케이스 T
let T;
// 건물의 수 N(건물 번호 1~N) (2 <= N <= 1000)
// 규칙의 수 K (1 <= K <= 100000)
let N, K;

// 건물을 짓는대 걸리는 시간 Dn (0 <= Di <= 100000) 최대 시간 100000000(1억) Integer
let D;

// 건설 순서 X Y(K개)
let graph;
let indeg;

// 건설해야할 번호 W
// W 까지 완성하는대 걸리는 최소 시간
let W;

const input = function (){
  [N, K] = scanner.nextLine().split(" ").map(Number);
  D = [0, ...scanner.nextLine().split(" ").map(Number)];
  graph = Array.from({length:N + 1}, () => []);
  indeg = Array.from({length:N + 1}, () => 0);
  for(let i = 0; i < K; i ++){
    let [In, Out] = scanner.nextLine().split(" ").map(Number);
    graph[In].push(Out);
    indeg[Out] ++;
  }
  W = scanner.nextNumber();
  // console.log('D:', D);
  // console.log(graph);
  // console.log(indeg);
  // console.log(W);
}

const pro = function (){
  let Q = [];
  let Time = 0;
  let max = 0;
  indeg.forEach((v, i) => {
    if(i === 0) return;
    if(v === 0) {
      Q.push(i);
      max = Math.max(D[i]);
    };
  })
  if(Q.indexOf(W) !== -1){
    console.log(D[W]);
    return;
  }
  Time += max;
  let next = [];
  while(Q.length !== 0){
    let pop = Q.shift();
    graph[pop].forEach(v => {
      indeg[v] --;
      if(indeg[v] === 0){
        next.push(v);
      }
    })
    if(Q.length === 0 && next.length > 0){
      let max = 0;
      if(next.indexOf(W) !== -1){
        Time += D[W];
        break;
      } else {
        next.forEach(v => {
          max = Math.max(max, D[v]);
        })
      }
      Time += max;
      Q = [...next];
      next = [];
    }
  }
  //10 20 8
  console.log(Time);
}

const solve = function(){
  T = scanner.nextNumber();
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
  
}

solve();