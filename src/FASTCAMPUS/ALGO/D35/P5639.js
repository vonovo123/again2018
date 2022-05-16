const fs = require('fs');
const { ListFormat } = require('typescript');
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

let table, graph, ans;
const input = function (){
  table = scanner.read.map(Number);
  ans = [];
  graph = {};
}
const postOrder = function(root){
    let[left, right] = graph[root];
    if(left){
      postOrder(left);
    }
    if(right){
      postOrder(right);
    }
    console.log(root);
}
const traverse = function(l, r) {
  let m = l;
  // subtree 기준점
  for(let i = l + 1; i <= r; i ++){
    if(table[i] < table[l]){
      m = i;
    }
  }
  graph[table[l]] = [];
  if(l + 1 <= m){
    traverse(l + 1, m);
    graph[table[l]].push(table[l + 1]);
  }
  if(m + 1 <= r){
    traverse(m + 1, r);
    graph[table[l]].push(table[m + 1]);
  }
}
const pro = function (){
  traverse(0, table.length - 1);
  postOrder(table[0]);
}

const solve = function(){
  input();
  pro();
}

solve();