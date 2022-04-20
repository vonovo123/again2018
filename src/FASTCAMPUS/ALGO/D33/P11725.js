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
let N; //노드의 수
let graph // 그래프
let parent
//트리상의 연결된 두 정점 N-1개가 주어질때 루트노드를 제외한 각노드의 부모노드를 출력
const input = function (){
  N = scanner.nextNumber();
  graph = [[]];
  parent = [0];
  scanner.read.map(line => {
    let [vertexA, vertexB] = line.split(" ").map(Number);
    if(!graph[vertexA]){
      graph[vertexA] = [];
    }
    graph[vertexA].push(vertexB);
    if(!graph[vertexB]){
      graph[vertexB] = [];
    }
    graph[vertexB].push(vertexA);
  })
}

const pro = function (){
  let Q = [1];
  graph[1].forEach(v => {
      parent[v] = 1;
      Q.push(v);
  })
  while(Q.length != 0){
    let pop = Q.shift();
    let verticies = graph[pop];
    verticies.forEach(v => {
      if(!parent[v]){
        parent[v] = pop;
        Q.push(v);
      }
    })
  }
  parent = parent.slice(2);
  let result = "";
  parent.map((v) => (result += `${v}\n`)); // 체크 배열의 2번 인덱스(2번 노드)부터 출력한다.
  console.log(result);
}

const solve = function(){
  input();
  pro();
}

solve();