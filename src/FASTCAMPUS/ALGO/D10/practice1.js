const fs = require('fs');
let input = fs.readFileSync('./dev/stdin.txt').toString().split('\n');
const N = input[0].split(" ")[0];
const M = input[0].split(" ")[1];
const arr = [];
for(let i = 1; i <= M; i ++){
arr.push(input[i].split(''))
}
class Edge {
  weight;
  vertex;
  constructor(weight, vertex){
    this.weight = weight;
    this.vertex = vertex;
  }
}
let map = new Map();
let distance = new Map();
let queue = [];
for(let i = 0; i < M; i ++){
  for(let j = 0; j < N; j ++){
    let edges = [];
    //상
      if(i > 0){
        edges.push(new Edge( Number(arr[i - 1][j]), (i - 1) + '' + j))
      }
    //하
      if(i < M - 1){
        edges.push(new Edge( Number(arr[i + 1][j]), (i + 1) + '' + j))
      }
    //좌
    if( j > 0){
      edges.push(new Edge( Number(arr[i][j - 1]), i + '' + (j - 1)))
    }
    if( j < N - 1){
      edges.push(new Edge( Number(arr[i][j + 1]), i + '' + (j + 1)))
    }
    //우
    map.set(i + '' + j , edges);
    distance.set(i + '' + j , Number.MAX_SAFE_INTEGER);
  }
}
distance.set('00', 0);
queue.push(new Edge(0, '00'));
while(queue.length !== 0){
  queue.sort((edgeV, edgeU) => {
    return edgeV.weight - edgeU.weight;
  })
  let poll = queue.shift();
  
  const curWeight = poll.weight;
  const curVertex = poll.vertex; 
  if(curWeight > distance.get(curVertex)){
    continue;
  }
  const adjacent = map.get(curVertex);
  for(let i = 0; i < adjacent.length; i ++){
    const node = adjacent[i];
    if(node.weight + curWeight < distance.get(node.vertex)){
      distance.set(node.vertex, node.weight + curWeight);
      queue.push(new Edge(node.weight + curWeight, node.vertex));
    }
  }
}
console.log(distance)
console.log(distance.get((M -1) + '' + (N -1)));
