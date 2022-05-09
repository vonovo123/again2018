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
class Heap {
  constructor(head) {
    this.array = [];
    this.array.push(NaN);
    this.array.push(head);  
  }
  swap(aIdx, bIdx){
    let tmp = this.array[aIdx];
    this.array[aIdx] = this.array[bIdx];
    this.array[bIdx] = tmp;
  }
  insert(data){
    this.array.push(data);
    let idx = this.array.length - 1;
    let parentIdx = this.moveUp(idx);
    while(parentIdx !== -1){
      this.swap(parentIdx, idx);
      idx = parentIdx;
      parentIdx = this.moveUp(idx);
    }
  }
  moveUp(idx){
    if(idx === 1) return -1;
    let parentIdx = Math.floor(idx / 2);
    let [pP, pL] = this.array[parentIdx]
    let [cP, cL] = this.array[idx];
    if(pL < cL){
      //난이도가 높으면 위로
      return parentIdx
    } else if (pL === cL){
      //난이도가 같으면
      if(pP < cP){
        //문제번호가 높으면 위로
        return parentIdx;
      }
    }
    return -1;
  }
}
const scanner = new Scanner('stdin.txt');
let N,M;
let infos;
let levels;
let problems;
let commands;
const input = function (){
  N = scanner.nextNumber();
  infos = scanner.read.splice(0, N).map(line => line.split(" ").map(Number));
  sort();
  levels = Array.from({length : 101}, () => []);
  problems = {};
  infos.forEach(([P,L]) => {
    levels[L].push(P);
    problems[P] = L;
  })
  M = scanner.nextNumber();
  commands = scanner.read.splice(0, M).map(line => line.split(" "));
}
const sort = function(){
  infos.sort(([aP, aL],[bP, bL]) => {
    if(aL === bL){
      return aP - bP
    } else {
      return aL - bL;
    }
  })
}
findMinOver = function(arr,P){
  let left = 0, right = arr.length - 1; 
  let find = arr.length;
  while(left <= right){
    let mid = Math.floor((left + right) / 2);
    if( arr[mid] < P){
      left = mid + 1;
    } else {
      right = mid - 1;
      find = mid;
    }
  }
  return find;
}
//위치찾기
const findIdx = function(arr, P){
  let left = 0, right = arr.length - 1; 
  while(left <= right){
    let mid = Math.floor((left + right) / 2);
    if( arr[mid] < P){
      left = mid + 1;
    } else if(arr[mid] > P) {
      right = mid - 1;
    } else {
      return mid;
    }
  }
}

const pro = function (){
  let P, L, X, answer = "";
  commands.forEach(command => {
    switch(command[0]){
      case 'add': {
        P = Number(command[1]);
        L = Number(command[2]);
        if(levels[L].length === 0){
          levels[L].splice(0,0,P);
        } else if(levels[L].length === 1){
          if(levels[L][0] < P){
            levels[L].splice(1,0,P);
          } else {
            levels[L].splice(0,0,P);
          }
        } else {
          let minOver = findMinOver(levels[L], P);
          levels[L].splice(minOver,0,P);
        }
        problems[P] = L;
        break;
      }
      case 'recommend': {
        X = Number(command[1]);
        if(X > 0) {
          let end = 100
          while(levels[end].length === 0){
            end --;
          }
          answer += levels[end][levels[end].length - 1] + "\n";
        } else {
          let start = 1
          while(levels[start].length === 0){
            start ++;
          }
          answer += levels[start][0] + "\n";
        }
        break;
      }
      case 'solved': {
        P = command[1];
        let L = problems[P];
        let find = findIdx(levels[L], P);
        levels[L].splice(find,1);
        problems[P] = null;
        break;
      }
      
    }
  })
  console.log(answer.trim());
}

const solve = function(){
  input();
  pro();
}

solve();