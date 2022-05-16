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
let N, M, info, tree, ans;
const input = function (){
  [N, M] = scanner.nextLine().split(" ").map(Number);
   info = scanner.read.splice(0, N - 1);
  tree = Array.from({length: N + 1}, () => new Array());
  info.forEach(e => {
    let [a, b, val] = e.split(" ").map(Number);
    tree[a].push({to : b, val});
    tree[b].push({to : a, val});
  })
  ans = [];
  scanner.read.forEach(e => {
    ans.push(e.split(" ").map(Number));
    
  })
  //console.log(tree);
}

const dfs = function(start, parent, sum, find){
  //console.log(`parent ${parent} start ${start}`);
  if(start === find){
    console.log(sum);
    return;
  }
  
  tree[start].forEach( v => {
    if(parent  !== v.to){
      dfs(v.to, start, sum + v.val, find);
    }
  })
}
const pro = function (){
  let [a,b] = ans[0];
  //dfs(a, 0, 0, b);
  ans.forEach(e => {
    let [a,b] = e;
    dfs(a, 0, 0, b);
  })
}

const solve = function(){
  input();
  pro();
}

solve();