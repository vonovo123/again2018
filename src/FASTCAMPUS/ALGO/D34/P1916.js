const fs = require('fs');
const { collapseTextChangeRangesAcrossMultipleVersions } = require('typescript');
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
let N,M; // N 개의 도시 M개의 버스 (1<= N <= 1000) (1 <= M <= 100000)
// A번 도시에서 B번 도시까지가는데 드는 최소비용
let info; // 출발도시 번호 / 도착도시 번호 / 버스 비용( 0 <= 비용 <= 100000 // 번호는 1번부터 N번까지
//출발지 도착지
let start, end;
//간석 객체
function Edge(des, price){
  this.to = des;
  this.weight = price;
}
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  info = Array.from({length : N + 1}, () => new Array());
  scanner.read.forEach((line, idx) => {
    if(idx === scanner.read.length - 1){
      [start, end] = line.split(" ").map(Number);
    } else {
     [A, B ,P] = line.split(" ").map(Number);
     info[A].push(new Edge(B, P));
    }
  })
  //console.log(JSON.stringify(info));
  //console.log(start);
  //console.log(end);
}

const pro = function (){
 let dist = Array.from({length: N + 1}, () => Infinity);
 let Q = [];
 Q.push([start, 0]);
 dist[start] = 0;
 while(Q.length !== 0){
   Q.sort((a,b) => a[1] - b[1]);
   console.log(Q);
   let [idx, d] = Q.shift();
   if(dist[idx] != d) continue;
   info[idx].forEach(edge => {
     let {to, weight} = edge;
      if(dist[to] <=  dist[idx] + weight) return;
      dist[to] = dist[idx] + weight;
      Q.push([to, dist[to]]);
   })
 } 
 console.log(dist[end]);
}

const solve = function(){
  input();
  pro();
}

solve();
