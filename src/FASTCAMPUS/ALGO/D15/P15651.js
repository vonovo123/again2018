const fs = require('fs');
const { collapseTextChangeRangesAcrossMultipleVersions } = require('typescript');
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
let N, M, selected;
const input = function (){
  N = scanner.nextNumber();
  M = scanner.nextNumber();
  selected = [];
}

const rec_func = function(k){
  if(selected.length == M){
    console.log(selected);
    return;
  }
  if(k > N) return;
  selected.push(k);
  rec_func(k + 1);
  selected.pop();
  rec_func(k + 1);
}
const pro = function (){
  rec_func(1);
}

const solve = function(){
  input();
  pro();
}

solve();