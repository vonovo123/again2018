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
let l, cur, des, table, answer;
let dir = [[-2, -1], [-1, -2], [-2, 1], [-1,2], [1,-2], [2,-1], [2,1], [1,2]];
const input = function (){
  l = scanner.nextNumber();
  cur = scanner.nextLine().split(' ').map(Number);
  des = scanner.nextLine().split(' ').map(Number);
  table = Array.from({length : l}, () => Array.from({length:l}, () => 0));
}

const bfs = function(){
  let Q = [[...cur, 0]];
  while(Q.length !== 0){
    let [popY, popX, turn] = Q.shift();
    dir.forEach(D => {
      let [dY, dX] = D;
      let nextY = dY + popY;
      let nextX = dX + popX; 
      if( nextY < 0 || nextY >= l) return;
      if( nextX < 0 || nextX >= l) return;
      if(table[nextY][nextX] !== 0) return;
      table[nextY][nextX] = turn + 1;
      Q.push([nextY, nextX, turn + 1]);
    })
  }
  answer += table[des[0]][des[1]] + '\n';
}

const pro = function (){
  if(cur[0] === des[0] && cur[1] === des[1]){
    answer += '0' + '\n';
    return;
  }
  bfs();
}

const solve = function(){
  let T = scanner.nextNumber();
  answer = '';
  for(let i = 0; i < T; i ++){
    input();
    pro();
  }
  console.log(answer.trim());
}

solve();