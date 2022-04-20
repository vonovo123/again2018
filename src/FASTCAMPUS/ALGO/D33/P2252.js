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
// N명의 학생( 1 <= N <= 32,000)
// M 키를 비교한 횟수 (1 <= M <= 100000)
// indeg [] 각 학생 별 앞에 서야하는 학생
// dag [] 각 학생 별 뒤에서야하는 학생
let N, M, indeg;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  indeg = Array.from({length:N + 1}, () => 0);
  dag = Array.from({length:N + 1}, () => []);
  scanner.read.forEach(line => {
    line = line.split(" ").map(Number);
    indeg[line[1]] ++;
    dag[line[0]].push(line[1]);
  })
  //console.log(indeg);
  //console.log(dag);
}

const pro = function (){
  let Q = [];
  let ans = '';
  indeg.forEach((c,i) => {
    if(i === 0) return;
    if(c === 0){
      Q.push(i);
    }
  })
  while(Q.length !== 0){
    let pop = Q.shift();
    ans += pop + " ";
    dag[pop].forEach(v => {
      indeg[v] --;
      if(indeg[v] === 0){
        Q.push(v);
      }
    })
  }
  console.log(ans);
}

const solve = function(){
  input();
  pro();
}

solve();