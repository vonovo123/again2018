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
let N; // 1 <= N <= 500
let A;
let adjustment, indegreeCount, time, sum;
const input = function (){
  N = scanner.nextNumber();
  A = [0, ...scanner.read.splice(0, N).map(line => line.split(' ').map(Number))];
  adjustment = Array.from({length : N + 1}, () => new Array());
  indegreeCount = Array.from({length : N + 1}, () => 0);
  time = Array.from({length : N + 1}, () => 0);
  sum = Array.from({length : N + 1}, () => 0);
}

const pro = function (){
  for(let i = 1; i <= N; i ++){
    let info = A[i];
    let t = info.splice(0,1)[0];
    time[i] = t;
    let idx = 0;
    while(info[idx] !== -1){
      adjustment[info[idx]].push(i);
      indegreeCount[i] ++;
      idx ++;
    }
  }
  // console.log(adjustment);
  // console.log(indegreeCount);
  // console.log(time);
  let q = [];
  let answer = ''
  indegreeCount.forEach( (v,i) =>{
    if(i === 0) return;
    if(v === 0){
      q.push(i)
      sum[i] = time[i];
    };
    
  })
  while(q.length !== 0){
    let pop = q.shift();
    adjustment[pop].forEach(adj => {
      indegreeCount[adj] -= 1;
      sum[adj] = Math.max(sum[adj], sum[pop] + time[adj]);
      if(indegreeCount[adj] === 0){
        q.push(adj);
      }
    })
  }
  for(let i = 1; i <= N; i ++){
    answer += sum[i] + '\n';
  }
  console.log(answer.trim());
}

const solve = function(){
  input();
  pro();
}

solve();