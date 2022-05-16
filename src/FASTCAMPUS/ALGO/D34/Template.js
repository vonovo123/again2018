const { resolveObjectURL } = require('buffer');
const fs = require('fs');
const { totalmem } = require('os');
const { isIfStatement } = require('typescript');
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
let n;
let edges;
let graph;
let total;
const input = function (){
  n = 5;
  edge = [[0,1],[0,2],[1,3],[1,4]];
  total = 0
}
function Node (){
  this.rel = [];
}

const pro = function (){
  
  graph = Array.from({length: n}, (_,i) => new Node());
  edges.forEach(e => {
    let [from, to] = e;
    graph[from].rel.push(to);
    graph[to].rel.push(from);
  })
  graph.forEach((v, i) =>{
    let visited = [];
    dfs(i, 1, visited);
  })
}
function dfs(v, count, visited){
  if(count >= 3){
    if(isLeaf(v, visited)){
      visited.push(v);
      console.log(visited);
      if(visited.length === 3){
        total += 1;
      } else {
        total += ((visited.length - 1) * (visited.length - 2) / 2);
      }
      return;
    } 
  }
  visited.push(v);
  graph[v].rel.forEach(r => {
    if(visited.indexOf(r) !== -1) return;
    dfs(r, count + 1, visited);
    visited.pop();
  })
}
function isLeaf(v, visited){
  let rel = graph[v].rel;
  let flag = true;
  for(let i = 0; i < rel.length; i ++){
    if(visited.indexOf(rel[i]) === -1){
      flag = false;
      break;
    }
  }
  return flag;
}

const solve = function(){
  input();
  pro();
}

solve();