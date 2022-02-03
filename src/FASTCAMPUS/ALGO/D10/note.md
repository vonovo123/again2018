## 최단 경로 알고리즘의 이해

### 1. 최단 경로 문제란?
- 최단 경로 문제란 두 노드를 잇는 가장 짧은 경로를 찾는 문제임
- 가중치 그래프 (Weighted Graph) 에서 간선 (Edge)의 가중치 합이 최소가 되도록 하는 경로를 찾는 것이 목적

### 최단 경로 문제 종류
1. 단일 출발 (single-source) 최단 경로 문제
  - 그래프 내의 특정 노드 u 에서 출발하여, 그래프 내의 모든 다른 노드에 도착하는 가장 짧은 경로를 찾는 문제
2. 단일 도착 (single-destination) 최단 경로 문제
  - 모든 노드들로부터 출발해서, 그래프 내의 특정 노드 u 로 도착하는 가장 짧은 경로를 찾는 문제
3. 단일 쌍(single-pair) 최단 경로 문제
  - 주어진 노드 u 와 v 간의 최단 경로를 찾는 문제
4. 전체 쌍(all-pair) 최단 경로: 그래프 내의 모든 노드 쌍 (u, v) 사이에 대한 최단 경로를 찾는 문제

### 2. 최단 경로 알고리즘 - 다익스트라 알고리즘
- 다익스트라 알고리즘은 위의 최단 경로 문제 종류 중, 1번에 해당
  - 하나의 정점에서 다른 모든 정점에 도착하는 **가장 짧은 거리**를 구하는 문제
  - 방향이 있는 가중치 그래프

### 3. 디익스트라 알고리즘의 구현 
```java
package FASTCAMPUS.ALGO.D10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) {
      HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
      graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
      graph.put("B", new ArrayList<Edge>());
      graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
      graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
      graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
      graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
      DijkstraPath dijkstraPath = new DijkstraPath(graph);
      HashMap<String, Integer> distance = dijkstraPath.search("A");
      System.out.println(distance);
  }
}

class DijkstraPath {
  HashMap<String, Integer> distance;
  HashMap<String, ArrayList<Edge>> graph;
  PriorityQueue <Edge> priorityQueue = new PriorityQueue<Edge>();
  DijkstraPath(  HashMap<String, ArrayList<Edge>> graph){
    this.graph = graph;
    this.distance = new HashMap<String, Integer>();
    this.priorityQueue = new PriorityQueue<Edge>();
  }
  public HashMap<String,Integer> search(String start){
    //distance 초기화
      for (String key : this.graph.keySet()) {
        distance.put(key, Integer.MAX_VALUE);
      }
      distance.put(start, 0);
      //우선순위 큐 초기화
     priorityQueue.add(new Edge(distance.get(start), start));
      //우선순위큐에 노드가 없을때까지 (최단거리가 더이상 없을때 까지) 반복
      while(priorityQueue.size() != 0){
        //최단거리 탐색할 노드
        Edge minEdge = priorityQueue.poll();
        if(minEdge.distance > distance.get(minEdge.vertex)){
          continue;
        }
        //최단거리 탐색할 노드와 연결된 노드 
        ArrayList<Edge> edges = graph.get(minEdge.vertex);
        for (Edge edge : edges) {
          //start 부터 연결노드의 거리가 배열에 기록된 거리보다 짧으면
          if( edge.distance  + minEdge.distance< distance.get(edge.vertex)){
            //배열상거리 업데이트
            distance.put(edge.vertex, edge.distance + minEdge.distance);
            //우선순위 큐에 추가
            priorityQueue.add(new Edge(edge.distance + minEdge.distance, edge.vertex));
          }
        }
      }
      //최단거리 기록된 배열 리턴 
    return distance;
  }
}

class Edge implements Comparable<Edge>{
  int distance;
  String vertex; 
  Edge(int distance, String vertex){
    this.distance = distance;
    this.vertex = vertex;
  }
  @Override
  public String toString() {
    return "vertex: " + this.vertex + ", distance: " + this.distance;  
  }
  @Override
  public int compareTo(Edge edge) {
    return this.distance - edge.distance;
  }
}


```
```javascript

```
### 4. 시간 복잡도
- 위 다익스트라 알고리즘은 크게 다음 두 가지 과정을 거침
  - 과정1: 각 노드마다 인접한 간선들을 모두 검사하는 과정
  - 과정2: 우선순위 큐에 노드/거리 정보를 넣고 삭제(pop)하는 과정
  
- 각 과정별 시간 복잡도
  - 과정1: 각 노드는 최대 한 번씩 방문하므로 (첫 노드와 해당 노드간의 갈 수 있는 루트가 있는 경우만 해당), 그래프의 모든 간선은 최대 한 번씩 검사
    - 즉, 각 노드마다 인접한 간선들을 모두 검사하는 과정은 O(E) 시간이 걸림, E 는 간선(edge)의 약자

  - 과정2: 우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 경우, 우선순위 큐에 노드/거리 정보를 넣고, 삭제하는 과정이 최악의 시간이 걸림
    - 우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 시나리오는 그래프의 모든 간선이 검사될 때마다, 배열의 최단 거리가 갱신되고, 우선순위 큐에 노드/거리가 추가되는 것임
    - 이 때 추가는 각 간선마다 최대 한 번 일어날 수 있으므로, 최대 O(E)의 시간이 걸리고, O(E) 개의 노드/거리 정보에 대해 우선순위 큐를 유지하는 작업은 $ O(log{E}) $ 가 걸림
      - 따라서 해당 과정의 시간 복잡도는 $ O(Elog{E}) $ 
    
### 총 시간 복잡도
  - 과정1 + 과정2 = O(E) + $ O(Elog{E}) $  = $ O(E + Elog{E}) = O(Elog{E}) $
  
### 참고: 힙의 시간 복잡도
- depth (트리의 높이) 를 h라고 표기한다면,
- n개의 노드를 가지는 heap 에 데이터 삽입 또는 삭제시, 최악의 경우 root 노드에서 leaf 노드까지 비교해야 하므로  h=log2n  에 가까우므로, 시간 복잡도는  O(logn)