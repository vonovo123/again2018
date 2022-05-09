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
let N, M;
let timeTable;
let prices;
let K;
let friend;
const input = function (){
  [N,M] = scanner.nextLine().split(" ").map(Number);
  timeTable = Array.from({length: N + 1}, () => Array.from({length: N + 1}, () => Infinity));
  prices = Array.from({length: N + 1}, () => Array.from({length: N + 1}, () => 0));
  let infos = scanner.read.splice(0,M);
  infos.forEach(info => {
    let [A, B, pay] = info.split(" ").map(Number);
    timeTable[A][B] = pay;
  })
  for(let i = 1; i <=N; i ++){
    timeTable[i][i] = 0;
  }
  K = scanner.nextNumber();
  friend = scanner.nextLine().split(" ").map(Number);
}

const pro = function (){
  //i 도시에서 j 도시까지 가는데 K 도시를 거쳐가는 비용 중 최소비용
  for(let k = 1; k <= N; k ++){
    for(let i = 1; i <= N; i ++){
      for(let j = 1; j <= N; j ++){
        timeTable[i][j] = Math.min(timeTable[i][j], (timeTable[i][k] + timeTable[k][j]))
      }
    }
  }
  //i : 목표도시
  let max = Number.MAX_VALUE;
  let target = [];
  for(let i = 1; i <= N; i ++){
    let price = 0;
    //출발도시
    friend.forEach(f => {
      let j = f;
      if(timeTable[i][j] === Infinity) return;
      if(timeTable[j][i] === Infinity) return;
      price  = Math.max(price, timeTable[j][i] + timeTable[i][j]);
    })
    if(max > price){
      target = [i];
      max = price;
    } else if (max === price ){
      target.push(i);
    }
  }
  let answer = "";
  target.forEach(t => {
    answer += t + " ";
  })
  console.log(answer.trim());
  
}

const solve = function(){
  input();
  pro();
}

solve();