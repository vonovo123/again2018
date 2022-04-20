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
let money, table, cost, count;
const input = function (){
  money = 1999
        //1원 5원 10원 50원 100원 500원
  table = [500, 100, 50, 10, 5, 1];
  //동전별 제작비용  
  cost = [2, 11, 20, 100, 200, 600].reverse()
  count = new Array(6);
}

const pro = function (){
 // 최소개수 구하기
 
  for(let i = 0; i < table.length; i ++){
    count[i] = Math.floor(money / table[i]);
    money %= table[i];
  }
  console.log('count: ', count);
  console.log('cost: ' , cost);
  console.log('table: ' , table);
  //1원제외
  let change = [];
  for(let i = 0; i < table.length - 1; i ++){
    let minPrice = cost[i];
    let minIdx = i;
    for(let j = i + 1; j < table.length; j ++){
      //작은단위 동전보다 비용이 많이들면
      if(minPrice > cost[j] * (table[i] / table[j])){
        minPrice = cost[j] * (table[i] / table[j]);
        minIdx = j;
      }
    }
    if(minIdx !== i) change[i] = minIdx;
  }
  console.log(change);

  change.forEach((c, i) => {
    if(c){
      let tmp = count[i];
      count[i] = 0;
      count[c] += (table[i] / table[c]) * tmp; 
    }
  })
  console.log(calc(count));
}

function calc(count){
  let sum = 0;
  count.forEach((c, i) => {
    sum += c * cost[i];
  })
  return sum;
}

const solve = function(){
  input();
  pro();
}

solve();