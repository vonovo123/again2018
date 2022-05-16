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
let N, R, Q;
let tree;
let parent;
let Dy;
let U
const input = function (){
  [N, R, Q] = scanner.nextLine().split(" ").map(Number);
  //console.log(N, R, Q);
  let info = scanner.read.splice(0, N -1);
  tree = Array.from({length : N + 1}, () => new Array());
  parent = Array.from({length : N + 1}, () => 0);
  Dy = Array.from({length : N + 1}, () => 1);
  info.forEach(i => {
    let [U, V] = i.split(" ").map(Number);
    tree[U].push(V);
    tree[V].push(U);
  })
  U = scanner.read.splice(0, Q).map(Number);

}
const findParent = function(vertex){
  tree[vertex].forEach(child => {
    if(parent[vertex] === child) return;
    parent[child] = vertex;
    Dy[vertex] += findParent(child);
  })
  return Dy[vertex];
}
const pro = function (){
  findParent(R);
  let answer = ""
  U.forEach(u => {
    answer += Dy[u];
    answer += '\n';
  })
  console.log(answer)
}

const solve = function(){
  input();
  pro();
}

solve();