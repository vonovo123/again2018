### 참고: 개선된 프림 알고리즘
- 간선이 아닌 노드를 중심으로 우선순위 큐를 적용하는 방식
  - 초기화 - 정점:key 구조를 만들어놓고, 특정 정점의 key값은 0, 이외의 정점들의 key값은 무한대로 놓음.  모든 정점:key 값은 우선순위 큐에 넣음
  - 가장 key값이 적은 정점:key를 추출한 후(pop 하므로 해당 정점:key 정보는 우선순위 큐에서 삭제됨), (extract min 로직이라고 부름)
  - 해당 정점의 인접한 정점들에 대해 key 값과 연결된 가중치 값을 비교하여 key값이 작으면 해당 정점:key 값을 갱신
    - 정점:key 값 갱신시, 우선순위 큐는 최소 key값을 가지는 정점:key 를 루트노드로 올려놓도록 재구성함 (decrease key 로직이라고 부름)

- 개선된 프림 알고리즘 구현시 고려 사항
  - 우선순위 큐(최소힙) 구조에서, 이미 들어가 있는 데이터의 값 변경시, 최소값을 가지는 데이터를 루트노드로 올려놓도록 재구성하는 기능이 필요함

  
> 이외에도 다양한 개선된 프림 알고리즘이 있지만, 기존 알고리즘이 우선순위큐를 사용하므로, 일관된 맥락에서 우선순위큐를 사용하여, 개선하는 알고리즘을 소개합니다.

### 최종 코드
- 실제 경로를 출력해보기 위해, ArrayList<Path> 자료구조 사용
- 총 weight (총 거리)를 totalWeight 에 저장
- 우선순위 큐를 통해 PriorityQueue<Edge> 힙구조를 사용하되,
   - 우선순위 큐에 들어 있는 각 Edge 의 weight 조회와, 특정 Edge 삭제를 가능토록 각 Edge 객체를 별도 HashMap 으로 관리
      -HashMap<String, Edge> keysObjects = new HashMap<String, Edge>()

```java
package FASTCAMPUS.ALGO.D13;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) {
    HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<String, HashMap<String, Integer>>();
    HashMap<String, Integer> edges;
    edges = new HashMap<String, Integer>();
    edges.put("B", 7);
    edges.put("D", 5);
    mygraph.put("A", edges);

    edges = new HashMap<String, Integer>();
    edges.put("A", 7);
    edges.put("D", 9);
    edges.put("C", 8);
    edges.put("E", 7);
    mygraph.put("B", edges);

    edges = new HashMap<String, Integer>();
    edges.put("B", 8);
    edges.put("E", 5);
    mygraph.put("C", edges);

    edges = new HashMap<String, Integer>();
    edges.put("A", 5);
    edges.put("B", 9);
    edges.put("E", 7);
    edges.put("F", 6);
    mygraph.put("D", edges);

    edges = new HashMap<String, Integer>();
    edges.put("B", 7);
    edges.put("C", 5);
    edges.put("D", 7);
    edges.put("F", 8);
    edges.put("G", 9);
    mygraph.put("E", edges);

    edges = new HashMap<String, Integer>();
    edges.put("D", 6);
    edges.put("E", 8);
    edges.put("G", 11);
    mygraph.put("F", edges);

    edges = new HashMap<String, Integer>();
    edges.put("E", 9);
    edges.put("F", 11);
    mygraph.put("G", edges);
    PrimPath primPath = new PrimPath();
    primPath.improvedPrimFunc(mygraph, "A");
    }
}
 class PrimPath {
    public void improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String start){
        //특정 노드에서 특정노드까지의 최소 거리 집합
        HashMap<String, Edge> distances = new HashMap<String, Edge>();
        //방문할 정점
        // HashMap <String, Edge> visitNodes = new HashMap<String, Edge>();
        //최소 가중치인 노드
        HashMap<String, String> path = new HashMap<String, String>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        ArrayList<Path> mst = new ArrayList<Path>();
        //특정 노드 사이의 최소거리
        Edge distance  = null;
        for(String key : graph.keySet()) {
            if(key.equals(start)){
                distance = new Edge(key, 0);
                path.put(key,key);
            } else {
                distance = new Edge(key, Integer.MAX_VALUE);
                path.put(key,key);
            }
            //visitNodes.put(key, distance);
            distances.put(key, distance);
        }
        System.out.println(distances);
        priorityQueue.add(distances.get(start));
        while(priorityQueue.size() != 0){
            Edge poll = priorityQueue.poll();
            distances.remove(poll.node);
            System.out.println(distances);
            mst.add(new Path(path.get(poll.node), poll.node, poll.weight));

            HashMap<String, Integer> link = graph.get(poll.node);
            for(String key : link.keySet()) {
                if(distances.containsKey(key)){
                    if(link.get(key) < distances.get(key).weight){
                        distances.get(key).weight = link.get(key);
                        path.put(key, poll.node);
                        priorityQueue.remove(distances.get(key));
                        priorityQueue.add(distances.get(key));
                    }
                }
            }

        }
    }
}

class Path {
    public String node1;
    public String node2;
    public int weight;
    
    public Path(){

    }
    
    public Path(String node1, String node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
    
    public String toString() {
        return "(" + this.node1 + ", " + this.node2 + ", " + this.weight + ")";
   
      }
  }
  
  class Edge implements Comparable<Edge> {
    public String node;
    public int weight;
    
    public Edge(String node, int weight) {
        this.weight = weight;
        this.node = node;
    }
    
    public String toString() {
        return "(" + this.weight + ", " + this.node + ")";
    }
    
    @Override 
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
  }

```