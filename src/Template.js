//시간복잡도 N^M (worst 7^7)
const fs = require('fs');
class Scanner {
  read
  stringToken
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

const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  M = scanner.nextNumber();
}


