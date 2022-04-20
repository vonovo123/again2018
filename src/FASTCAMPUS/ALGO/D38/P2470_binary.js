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
let N, Array;
const input = function (){
  N = scanner.nextNumber();
  Array = scanner.nextLine().split(" ").map(Number);
}
//value 이상의 수중 가장 왼쪽 좌표
const lower_bound = function(a, start){
  let left = start;
  let right = Array.length;
  let bound = N;
  while(left < right){
    let mid = Math.floor((left + right) / 2);
    //가운데 값이 a 이상이면 가운데 왼편에 더 큰값이 있을 수 있기 때문에 왼쪽 탐색
    if(Array[mid] >= a){
        bound = mid;
        right = mid - 1;
    // 가운데 값이 a 보다 작으면     
    } else {
        left = mid + 1;
    }
  }
  return bound;
}

const pro = function (){
  let min = Number.MAX_VALUE;
  let A = 0;
  let B = 0;
  Array.sort((a,b) => a - b);
  //console.log(Array);
  Array.forEach((a, left) => {
    if(left === Array.length - 1) return;
    //console.log("left: ", left);
    let candidate = lower_bound(-a, left + 1);
    //console.log(candidate - 1);
    //console.log(candidate);
    if(left < candidate - 1 && Math.abs(a + Array[candidate - 1]) < min){
      min = Math.abs(a + Array[candidate - 1])
      A = left;
      B = candidate - 1;
    }
    if( candidate < N && Math.abs(a + Array[candidate]) < min){
      min = Math.abs(a + Array[candidate])
      A = left;
      B = candidate;
    }
  })
  console.log(Array[A] + " " + Array[B]);
}

const solve = function(){
  input();
  pro();
}

solve();