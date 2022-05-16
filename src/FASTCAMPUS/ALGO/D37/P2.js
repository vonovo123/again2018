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
let matches, me, opp, graph;
const input = function (){
  //matches = [-1, 0, 0, 1, 2, 2, 3, 3, 4, 5, 5];
  matches =[-1, 0, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 9, 10, 10, 11, 11]
  me = 16;
  opp = 13;
  graph = Array.from({length:matches.length}, () => { return {next : 0, match : []}});
}

const pro = function (){
  matches.forEach((p, i) => {
    if(p === -1) return;
    graph[i].next = p;
    graph[p].match.push(i);
  })
  //me 경기수
  let count = 0;
  //각라운드별 상대
  let match = me;
  while(me != 0){
    let next_me = graph[me].next;
    //부전승인지 판단
    if(graph[next_me].match.length === 2) {
      //부전승이 아니면 경기수 증가
      count += 1;
      //라운드 상대탐색
      graph[next_me].match.forEach(v => {
        if(v === me ) return;
        match = v;
      })
    }
    //라운드의 상대가 opp면 중지
    if(match === opp) break;
    //다음경기 정보 초기화
    me = next_me;
    opp = graph[opp].next; /// 5
  }
  console.log(count);
  //console.log(graph);
}

const solve = function(){
  input();
  pro();
}

solve();