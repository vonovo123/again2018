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