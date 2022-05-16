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
let N, a;
const input = function (){
  N = scanner.nextNumber();
  a = [];
  for(let i = 0; i < N; i ++){
    a[i] = scanner.nextLine().split('.')[1];
  }

}

const pro = function (){
  a.sort( (a, b) => {
    let idx = 0;
    while((idx < a.length && idx < b.length) && (a.charAt(idx) === b.charAt(idx)) ){
      idx ++;
    }
    //두 단어의 길이가 같으면
    if(a.length === b.length){
      if(idx == a.length){//같은단어
        return 0;
      } else {
        return a.charCodeAt(idx) - b.charCodeAt(idx);
      }
    } else {
      //a가 b에 포함
      if(idx == a.length){
        return -1;
      //b가 a에 포함 
      } else if(idx == b.length){
        return 1;
       //한 단어의 끝에 닫기전에 다른 스펠링 
      } else {
        return a.charCodeAt(idx) - b.charCodeAt(idx);
      }
    }
  });
  for(let i = 0; i < N;){
    let j = i + 1;
    let count = 1;
    for(;j < N; j ++){
      if(a[j] === a[i]){
        count ++;
      } else {
        break;
      }
    }
    console.log(`${a[i]} ${count}`);
    i = j;
  }
}

const solve = function(){
  input();
  pro();
}

solve();