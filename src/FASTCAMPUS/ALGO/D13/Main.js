//간선
class Path {
  nodeV;
  nodeU;
  weight;
  constructor(nodeV, nodeU, weight){
    this.nodeV = nodeV;
    this.nodeU = nodeU;
    this.weight = weight
  }
}
//특정 노드로 이어지는 간선
class Edge  {
  //가중치
  weight;
  //도착노드
  node;
  constructor(node, weight){
    this.node = node;
    this.weight = weight;
  }
}

const mygraph = new Map();
const startNode = "A";
let edges = new Map();
edges.set("B", 7);
edges.set("D", 5);
mygraph.set("A", edges);

edges = new Map();
edges.set("A", 7);
edges.set("D", 9);
edges.set("C", 8);
edges.set("E", 7);
mygraph.set("B", edges);

edges = new Map();
edges.set("B", 8);
edges.set("E", 5);
mygraph.set("C", edges);

edges = new Map();
edges.set("A", 5);
edges.set("B", 9);
edges.set("E", 7);
edges.set("F", 6);
mygraph.set("D", edges);

edges = new Map();
edges.set("B", 7);
edges.set("C", 5);
edges.set("D", 7);
edges.set("F", 8);
edges.set("G", 9);
mygraph.set("E", edges);


edges = new Map();
edges.set("D", 6);
edges.set("E", 8);
edges.set("G", 11);
mygraph.set("F", edges);

edges = new Map();
edges.set("E", 9);
edges.set("F", 11);
mygraph.set("G", edges);
console.log(mygraph);
let distance = new Map();
let mstPath = new Map();
let novisitNodes = new Map();
let priorityQueue = [];
let linkedEdges = null;

let mst = [];
[...mygraph.keys()].forEach( key => {
  let edge = null;
  if(key === startNode){
    edge = new Edge(key, 0);    
    mstPath.set(key, key);
  } else {
    edge = new Edge(key, Number.MAX_SAFE_INTEGER);
    mstPath.set(key, null);
  }
  distance.set(key, edge);
  novisitNodes.set(key,edge);
})
priorityQueue.push(distance.get(startNode));

while(priorityQueue.length > 0){
  console.log(priorityQueue);
  const poll = priorityQueue.shift();
  novisitNodes.delete(poll.node)
  console.log(poll.node);
  console.log(novisitNodes)
  mst.push(new Path(mstPath.get(poll.node), poll.node, poll.weight));
  linkedEdges = mygraph.get(poll.node);
  [...linkedEdges.keys()].forEach(key =>{
    console.log(`key : ${key}`)
      if(novisitNodes.has(key)){
        if(linkedEdges.get(key) < distance.get(key).weight){
          distance.get(key).weight = linkedEdges.get(key);
          mstPath.set(key, poll.node);
          priorityQueue.push(distance.get(key));
          priorityQueue.sort((a,b) => a.weight - b.weight);
        }
      }
  })
}

console.log(mst);



let test = new Map();