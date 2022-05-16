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
let n, k, vertices, tree, answer;
const input = function (){
  [n, k] = scanner.nextLine().split(" ").map(Number);
  if(n === 0 && k === 0) return false;
  vertices = scanner.nextLine().split(" ").map(Number);
  tree = Array.from({length: n + 1}, () => []);
  return true;
}

const pro = function (){
  let siblings = [];
  let sibling = [];
  for(let i = 0; i < n; i ++){
    //구분점
    sibling.push(vertices[i]);
    if(vertices[i] + 1 !== vertices[i + 1]){
      siblings.push(sibling);
      sibling = [];
    }
  }
  
  let start = 0;
  let end = 0;
  let save = [];
  let parent = 0;
  while(end < siblings.length - 1){
    let find = siblings[start];
    find.forEach(v => {
      end += 1;
      tree[v] = siblings[end];
      if(tree[v].indexOf(k) !== -1){
        save = find;
        parent = v;
      }
    })
    start += 1;
  }
  let sum = 0;
  save.forEach(v => {
    if(v === parent) return;
    sum += tree[v].length;
  });
  answer += sum + "\n";
}

const solve = function(){
  answer = ""
  while(input()){
    pro();
  }
  console.log(answer);
}

solve();