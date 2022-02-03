## 최소 신장 트리의 이해

### 1. 프림 알고리즘 (Prim's algorithm)
- 대표적인 최소 신장 트리 알고리즘
  - Kruskal’s algorithm (크루스칼 알고리즘), Prim's algorithm (프림 알고리즘)
- 프림 알고리즘 
  - 시작 정점을 선택한 후, 정점에 인접한 간선중 최소 간선으로 연결된 정점을 선택하고, 해당 정점에서 다시 최소 간선으로 연결된 정점을 선택하는 방식으로 최소 신장 트리를 확장해가는 방식
- Kruskal's algorithm 과 Prim's algorithm 비교
  - 둘다, 탐욕 알고리즘을 기초로 하고 있음 (당장 눈 앞의 최소 비용을 선택해서, 결과적으로 최적의 솔루션을 찾음)
  - Kruskal's algorithm은 가장 가중치가 작은 간선부터 선택하면서 MST를 구함
  - Prim's algorithm은 특정 정점에서 시작, 해당 정점에 연결된 가장 가중치가 작은 간선을 선택, 간선으로 연결된 정점들에 연결된 간선 중에서 가장 가중치가 작은 간선을 택하는 방식으로 MST를 구함


### 2. 프림 알고리즘 (Prim's algorithm) 코드 작성

```java
package FASTCAMPUS.ALGO.D12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

class Main {
  public static void main(String[] args) {
    ArrayList<Edge> edges = new ArrayList<Edge>();
    edges.add(new Edge(7, "A", "B"));
    edges.add(new Edge(5, "A", "D"));
    edges.add(new Edge(9, "B", "D"));
    edges.add(new Edge(8, "B", "C"));
    edges.add(new Edge(6, "D", "F"));
    edges.add(new Edge(7, "D", "E"));
    edges.add(new Edge(5, "C", "E"));
    edges.add(new Edge(7, "B", "E"));
    edges.add(new Edge(8, "F", "E"));
    edges.add(new Edge(11, "F", "G"));
    edges.add(new Edge(9, "E", "G"));
    PrimPath primPath = new PrimPath();
    System.out.println(primPath.search("A", edges));
  }
}
class PrimPath {
  
  public ArrayList<Edge> search(String start, ArrayList<Edge> edges){
    //모든 노드를 순회하는 최소비용루트가 담긴 배열
    ArrayList<Edge> mst = new ArrayList<Edge>();
    //노드 key와 연결된 간선정보 리스트를 담은 해쉬 테이블
    Hashtable<String, ArrayList<Edge>> adjacentEdge = new Hashtable<String, ArrayList<Edge>>();
    for (Edge curEdge : edges) {
      String nodeV = curEdge.nodeV;
      String nodeU = curEdge.nodeU;
      if(!adjacentEdge.containsKey(nodeV)){
        adjacentEdge.put(curEdge.nodeV, new ArrayList<Edge>());
      }
      if(!adjacentEdge.containsKey(nodeU)){
        adjacentEdge.put(curEdge.nodeU, new ArrayList<Edge>());
      }
      ArrayList<Edge> vEdges = adjacentEdge.get(nodeV);
      ArrayList<Edge> uEdges = adjacentEdge.get(nodeU);
      //노드 v와 연결된 간선리스트 간선 추가
      vEdges.add(new Edge(curEdge.weight, nodeV, nodeU));
      //노드 u와 연결된 노드리스트에 간선정보 추가
      uEdges.add(new Edge(curEdge.weight, nodeU, nodeV));
    }
    //연결된 정점을 담은 리스트
    ArrayList<String> connectedNodeList = new ArrayList<String>();
    //시작점
    connectedNodeList.add(start);
    //다음 최소비용 간선이 될수 있는 후보 간선리스트 
    ArrayList<Edge> candidateList = adjacentEdge.getOrDefault(start, new ArrayList<Edge>());
    PriorityQueue<Edge>  priorityQueue = new PriorityQueue<Edge>();
    for (Edge edge : candidateList) {
      priorityQueue.add(edge); 
    }

    while(priorityQueue.size() != 0){
      Edge poll = priorityQueue.poll();
      if(!connectedNodeList.contains(poll.nodeU)){
        connectedNodeList.add(poll.nodeU);
        mst.add(poll);
        candidateList = adjacentEdge.getOrDefault(poll.nodeU, new ArrayList<Edge>());
        for (Edge edge : candidateList) {
          if(!connectedNodeList.contains(edge.nodeU)){
            priorityQueue.add(edge);
          }
        }
      }
    }

    return mst;
  }
}
class Edge implements Comparable<Edge>{
  int weight;
  String nodeV, nodeU;
  Edge(int weight, String nodeV, String nodeU){
    this.weight = weight;
    this.nodeV = nodeV;
    this.nodeU = nodeU;
  }
  @Override
  public int compareTo(Edge e) {
    return this.weight - e.weight;
  }
  @Override
  public String toString() {
    return "weight : " + this.weight +" nodeV : " + this.nodeV + " nodeU : " + this.nodeU + "\n";  
  }
}
```

```javascript
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
const mst = [];
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

```