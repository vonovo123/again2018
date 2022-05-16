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
let N, M, K;
let adj, idg, logs, built;
const input = function (){
  [N,M,K] = scanner.nextLine().split(" ").map(Number);
  adj = Array.from({length : N + 1}, () => new Array());
  idg = Array.from({length : N + 1}, () => 0);
  built = Array.from({length : N + 1}, () => 0);
  let conditions = scanner.read.splice(0, M);
  conditions.forEach(condition => {
    let [a, b] = condition.split(" ").map(Number);
    adj[a].push(b);
    idg[b] += 1;
  })
  logs = scanner.read.splice(0, K).map(log => {
    return log.split(" ").map(Number);
  });
  // console.log(adj);
  // console.log(idg);
  // console.log(logs);
  let answer = "King-God-Emperor";
  for(let i = 0; i < logs.length; i ++){
    let [command, target] = logs[i];
    if(command === 1){
      //영향받는요소가없고
      if(idg[target] === 0){
        //이미 설치된 요소가 아니면
        if(built[target] === 0){
          //영향주는 건물의 영향받는 수 삭제
          adj[target].forEach(next => {
              idg[next] -= 1;
          })
        }
        built[target] ++;
      } else {
        answer = "Lier!"
        break;
      }
    } else {
      //건설된게 있고
      if(built[target] > 0){
        //삭제됐을때 영향을 주는경우
        if(built[target] === 1){
          adj[target].forEach(next => {
            idg[next] += 1;
          })
        }
        built[target] -= 1;
      } else {
        answer = "Lier!"
        break;
      }
    }
  }
  console.log(answer);
}

const pro = function (){

}

const solve = function(){
  input();
  pro();
}

solve();