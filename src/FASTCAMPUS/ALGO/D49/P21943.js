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
let N;
let X;
let P, Q;
let total = 0;
let signCase = [];
let order = [];
const input = function (){
  N = scanner.nextNumber();
  X = scanner.nextLine().split(" ").map(Number);
  [P, Q] = scanner.nextLine().split(" ").map(Number);
}
const dfs = function(signCase, x, arr){
  if(arr.length === N){
    order.push(arr);
    let cArr = [...x];
    for(let i = 1; i < N; i ++){
      let idx = arr.indexOf(i);
      let tag = signCase[idx];
      let sum = 0;
      if(tag === '+'){
        sum = cArr[idx - 1] + cArr[idx];
      } else {
        sum = cArr[idx - 1] * cArr[idx];
      }
      
      cArr[idx - 1] = sum;
      cArr[idx] = sum;
      if(i === N - 1){
        if(sum > total) {
          total = sum
        };
      }
    }
    return;
  }
  for(let i = 1; i <= N - 1; i ++){
    if(arr.indexOf(i) === -1){
      dfs(signCase, x, [...arr, i]);
    }
  }
}
const findOrder = function (arr){
  if(arr.length === N){
    order.push(arr);
    return;
  }
  for(let i = 1; i < N; i ++){
    if(arr.indexOf(i) === -1){
      findOrder([...arr,i]);
    }
  }
}
const findSignCase = function (pCount , qCount, arr){
  if(pCount === P && qCount === Q){
    signCase.push(arr);
  }
 if(pCount < P){
  findSignCase(pCount + 1, qCount, [...arr, '+'])
 }
 if(qCount < Q){
  findSignCase(pCount, qCount + 1, [...arr, '*'])
 }
}
const arrange = function(arr,visited){
  if(arr.length === N){
    signCase.forEach(sign => {
        let value = [null];
        let idx = -1;
        value[ ++ idx] = arr[0];
        for(let i = 1; i < N; i ++){
          let tag = sign[i];
          if(tag === '+'){
            value[idx] += arr[i];
          } else {
            value[ ++ idx] = arr[i];
          }
        }
        let curValue = 1;
        for(let i = 0; i <= idx; i ++){
          curValue *= value[i];
        }
        total = Math.max(total,curValue);
    })
    return;
  }
  for(let i = 0; i < N; i ++){
    if(visited.indexOf(i) === -1){
      visited.push(i);
      arrange([...arr, X[i]], visited);
      visited.pop();
    }
  }
}
const pro = function (){
  findSignCase(0, 0, [null]);
  findOrder([null]);
  arrange([], []);
  console.log(total);
}

const solve = function(){
  input();
  pro();
}

solve();