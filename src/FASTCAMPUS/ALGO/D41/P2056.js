const fs = require('fs');
const { collapseTextChangeRangesAcrossMultipleVersions } = require('typescript');
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
let N, time, doneTime, adjustment, indeg;
const input = function (){
  N = scanner.nextNumber();
  time = Array.from({length : N + 1}, () => 0);
  doneTime = Array.from({length : N + 1}, () => 0);
  indeg = Array.from({length : N + 1}, () => 0);
  adjustment = Array.from({length : N + 1}, () => []);
  let infos = scanner.read.splice(0);
  infos.forEach((info, idx) => {
    idx += 1;
    info = info.split(" ");
    [t, count] = info.splice(0, 2).map(Number);
    time[idx] = t;
    indeg[idx] = count;
    info.forEach(v => {
      adjustment[v].push(idx);
    })
  })
}

const pro = function (){
  // console.log(time);
  // console.log(indeg);
  // console.log(adjustment);
  let answer = 0;
  let q = [];
  indeg.forEach((v,idx) => {
    if(idx === 0) return;
    if(v === 0) {
      q.push(idx)
      doneTime[idx] = time[idx];
      answer = Math.max(answer, doneTime[idx]);
    };
  })
  while(q.length !== 0){
    let pop = q.shift();
    adjustment[pop].forEach(v => {
      indeg[v] --;
      doneTime[v] = Math.max(doneTime[v], doneTime[pop] + time[v]);
      if(indeg[v] === 0){
        q.push(v);
        answer = Math.max(answer, doneTime[v]);
      }
    })
  }
  console.log(answer)
}

const solve = function(){
  input();
  pro();
}

solve();