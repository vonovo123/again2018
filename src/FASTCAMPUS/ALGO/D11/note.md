## 최소 신장 트리의 이해

### 최소 신장 트리 알고리즘
- 그래프에서 최소 신장 트리를 찾을 수 있는 알고리즘이 존재함
- 대표적인 최소 신장 트리 알고리즘
  - Kruskal’s algorithm (크루스칼 알고리즘), Prim's algorithm (프림 알고리즘)

### 크루스칼 알고리즘 (Kruskal's algorithm)
1. 모든 정점을 독립적인 집합으로 만든다.
2. 모든 간선을 비용을 기준으로 정렬하고, 비용이 작은 간선부터 양 끝의 두 정점을 비교한다.
3. 두 정점의 최상위 정점을 확인하고, 서로 다를 경우 두 정점을 연결한다. (최소 신장 트리는 사이클이 없으므로, 사이클이 생기지 않도록 하는 것임)

> 탐욕 알고리즘을 기초로 하고 있음 (당장 눈 앞의 최소 비용을 선택해서, 결과적으로 최적의 솔루션을 찾음)

### Union-Find 알고리즘
- Disjoint Set을 표현할 때 사용하는 알고리즘으로 트리 구조를 활용하는 알고리즘
- 간단하게, 노드들 중에 연결된 노드를 찾거나, 노드들을 서로 연결할 때 (합칠 때) 사용
- Disjoint Set이란
  - 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조
  - 공통 원소가 없는 (서로소) 상호 배타적인 부분 집합들로 나눠진 원소들에 대한 자료구조를 의미함
  - Disjoint Set = 서로소 집합 자료구조

### 크루스칼 알고리즘 (Kruskal's algorithm) 코드 작성

```java

public void union(String nodeV, String nodeU){
    String rootV = find(nodeV);
    String rootU = find(nodeU);
    //루트노드가 다르다는것은 보장이 되어있기때문에 rank 가 루트노드가 합쳐진 트리의 루트노드가 된다.
    if(rank.get(rootV) > rank.get(rootU)){
      this.parent.put(rootU, rootV);
    } else {
        this.parent.put(rootV, rootU);
        if(rank.get(rootU) == rank.get(rootV)){
          rank.put(rootU, rank.get(rootU) + 1);
        }
    }
  }
  public void init(String node){
    this.parent.put(node, node);
    this.rank.put(node, 0);
  }

  public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges){
    ArrayList<Edge> mst = new ArrayList<Edge>();
    
    for (String vertic  : vertices) {
      this.init(vertic);
    }

    Collections.sort(edges);
    System.out.println(edges);
    for (Edge edge : edges) {
        //두 노드의 루트노드가 같지않으면
        if(this.find(edge.nodeU) != this.find(edge.nodeV)){
          System.out.println("u : " + this.find(edge.nodeU));
          System.out.println("v : " + this.find(edge.nodeV));
          //하나의 트리로 만든다.(루트노드가 같아진다)
          this.union(edge.nodeU, edge.nodeV);
          mst.add(edge);
        }
        
    }
    return mst;
  }
}

class Edge implements Comparable<Edge>{
  int weight;
  String nodeV;
  String nodeU;
  Edge(int weight, String nodeV, String nodeU){
    this.nodeV = nodeV;
    this.nodeU = nodeU;
    this.weight = weight;
  }
  @Override
  public String toString() {
    return "nodeV : " + this.nodeV + ", nodeU : " + this.nodeU + ", weight : " + this.weight + "\n"; 
  }
  @Override
  public int compareTo(Edge o) {
    return this.weight - o.weight;
  }
}


```

``` javascript
class KruscalEdge {
  weight:number;
  edgeV:string;
  edgeU:string;
  constructor(weight:number, edgeV:string, edgeU:string){
    this.weight = weight;
    this.edgeV = edgeV;
    this.edgeU = edgeU;
  }
}


const vertecies:string[] = ['A','B','C','D','E','F','G'];
const kruscalEdges:KruscalEdge[] = [];

const parents:Map<string, string> = new Map<string,string>();
const ranks:Map<string, number> = new Map<string,number>();

kruscalEdges.push(new KruscalEdge(7, "A", "B"));
kruscalEdges.push(new KruscalEdge(5, "A", "D"));
kruscalEdges.push(new KruscalEdge(9, "B", "D"));
kruscalEdges.push(new KruscalEdge(8, "B", "C"));
kruscalEdges.push(new KruscalEdge(6, "D", "F"));
kruscalEdges.push(new KruscalEdge(7, "D", "E"));
kruscalEdges.push(new KruscalEdge(5, "C", "E"));
kruscalEdges.push(new KruscalEdge(7, "B", "E"));
kruscalEdges.push(new KruscalEdge(8, "F", "E"));
kruscalEdges.push(new KruscalEdge(11, "F", "G"));
kruscalEdges.push(new KruscalEdge(9, "G", "E"));
kruscalEdges.sort((v,u) => v.weight - u.weight)
//초기화
vertecies.forEach(vertex => {
  parents.set(vertex,vertex);
  ranks.set(vertex, 0);
});
//루트노드 찾기
function find(vertex:string):string{
  if(parents.get(vertex) !== vertex){
    parents.set(vertex, find(parents.get(vertex) + ""));
  }
  return  parents.get(vertex) +"";
}

//union-by-rank
function unionByRank(edgeV:string, edgeU:string) {
  const rootV = find(edgeV);
  const rootU = find(edgeU);
  if(rootV > rootU){
    parents.set(rootU, rootV);
  } else {
    parents.set(rootV, rootU);
    if(rootV === rootU){
      const vRank = ranks.get(rootV);
      if(vRank){
        ranks.set(rootV, vRank + 1);
      } 
    }
  }
}
const mst:KruscalEdge[] = [];
kruscalEdges.forEach(edge => {
  const v = parents.get(edge.edgeV);
  const u = parents.get(edge.edgeU);
  if(v && u){
    const rootV = find(v);
    const rootU = find(u);
    console.log(`v : ${v}, u : ${u}, rootV : ${rootV}, rootU : ${rootU}`);
    if(rootV !== rootU){
      unionByRank(v, u);
      mst.push(edge);
    }
  }
})

console.log(mst);
```