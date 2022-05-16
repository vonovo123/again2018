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

let N, binaryTree, answer;

const input = function (){
  binaryTree = {}
  N = scanner.nextNumber();
  scanner.read.forEach( l => {
    l = l.split(" ");
    if(!binaryTree[l[0]]){
      binaryTree[l[0]] = [];
    }
    binaryTree[l[0]][0] = l[1];
    binaryTree[l[0]][1] = l[2];
  })
  console.log(binaryTree);
}

const preorder = function(root){
  let [left, right] = binaryTree[root];
  answer += root;
  if(left !== '.') preorder(left)
  if(right != '.') preorder(right);
}
const inorder = function(root){
  let [left, right] = binaryTree[root];
  if(left !== '.') inorder(left)
  answer += root;
  if(right != '.') inorder(right);
}
const postorder = function(root){
  let [left, right] = binaryTree[root];
  if(left !== '.') postorder(left)
  if(right != '.') postorder(right);
  answer += root;
}
const pro = function (){
  answer = '';
  preorder('A');
  console.log(answer);
  answer = '';
  inorder('A');
  console.log(answer);
  answer = '';
  postorder('A');
  console.log(answer);
}

const solve = function(){
  input();
  pro();
}

solve();