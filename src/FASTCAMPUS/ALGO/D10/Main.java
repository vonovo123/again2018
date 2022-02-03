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

