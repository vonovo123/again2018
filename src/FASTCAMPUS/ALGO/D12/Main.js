class Edge {
  nodeV;
  nodeU;
  weight;
  constructor(nodeV, nodeU, weight){
    this.nodeV = nodeV;
    this.nodeU = nodeU;
    this.weight = weight;
  }
}
//간선정보
const edges = [];
edges.push(new Edge("A","B",7));
edges.push(new Edge("A","D",5));
edges.push(new Edge("B","C",8));
edges.push(new Edge("B","D",9));
edges.push(new Edge("D","E",7));
edges.push(new Edge("C","E",5));
edges.push(new Edge("B","E",7));
edges.push(new Edge("D","F",6));
edges.push(new Edge("E","F",8));
edges.push(new Edge("E","G",9));
edges.push(new Edge("F","G",11));

//0. 정점별 인접간선 정보 저장 (**adjacentEdges**)
const adjacentEdges = new Map();

edges.forEach(edge => {
  const nodeV = edge.nodeV;
  const nodeU = edge.nodeU;
  const weight = edge.weight;
  if(!adjacentEdges.has(nodeV)){
    adjacentEdges.set(nodeV, []);
  }
  if(!adjacentEdges.has(nodeU)){
    adjacentEdges.set(nodeU, []);
  }
  adjacentEdges.get(nodeV).push(new Edge(nodeV, nodeU, weight));
  adjacentEdges.get(nodeU).push(new Edge(nodeU, nodeV, weight));
})

//1. 임의의 정점을 선택, '연결된 노드 집합(**connectedNodes**)'에 삽입
//5. 간선 리스트에 더 이상의 간선이 없을 때까지 3-4번을 반복
let selNode = "A";
const connectedNodes = [];
let candidateEdgeList = [];
let mst = [];
connectedNodes.push(selNode);
//2. 선택된 정점에 연결된 간선들을 간선 리스트(**candidateEdgeList**)에 삽입
candidateEdgeList = [...adjacentEdges.get(selNode)];
//4. 선택된 간선은 간선 리스트에서 제거
candidateEdgeList.sort((a, b) => {
 return a.weight- b.weight;
})
while(candidateEdgeList.length != 0){
  //3. 간선 리스트(**candidateEdgeList**)에서 최소 가중치를 가지는 간선부터 추출해서,
  let poll = candidateEdgeList.shift();
 // 3- 1. 해당 간선에 연결된 인접 정점이 '연결된 노드 집합'에 들어 있지 않으면, 해당 간선을 선택하고, 해당 간선 정보를 '최소 신장 트리(**mst**)'에 삽입
  if(connectedNodes.indexOf(poll.nodeU) === -1){
    mst.push(poll)
    selNode = poll.nodeU;
    connectedNodes.push(selNode);
   // 3-2 해당 간선에 연결된 인접 정점의 간선들 중, '연결된 노드 집합(**connectedNodes**)' 에 없는 노드와 연결된 간선들만 간선 리스트(**candidateEdgeList**) 에 삽입 
   adjacentEdges.get(selNode).forEach(adjacentEdge => {
     if(connectedNodes.indexOf(adjacentEdge.nodeU) === -1){
      candidateEdgeList.push(adjacentEdge);
     }
   })
    candidateEdgeList.sort((a, b) => {
      return a.weight- b.weight;
     })
  }
}

console.log(mst);



