package FASTCAMPUS.ALGO.D11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
    ArrayList<Edge> edges = new ArrayList<Edge>();
    edges.add(new Edge(7, "A", "B"));
    edges.add(new Edge(7, "B", "A"));
    edges.add(new Edge(5, "A", "D"));
    edges.add(new Edge(5, "D", "A"));
    edges.add(new Edge(9, "B", "D"));
    edges.add(new Edge(9, "D", "B"));
    edges.add(new Edge(8, "B", "C"));
    edges.add(new Edge(8, "C", "B"));
    edges.add(new Edge(6, "D", "F"));
    edges.add(new Edge(6, "F", "D"));
    edges.add(new Edge(7, "D", "E"));
    edges.add(new Edge(7, "E", "D"));
    edges.add(new Edge(5, "C", "E"));
    edges.add(new Edge(5, "E", "C"));
    edges.add(new Edge(7, "B", "E"));
    edges.add(new Edge(7, "E", "B"));
    edges.add(new Edge(8, "F", "E"));
    edges.add(new Edge(8, "E", "F"));
    edges.add(new Edge(11, "F", "G"));
    edges.add(new Edge(11, "G", "F"));
    edges.add(new Edge(9, "E", "G"));
    edges.add(new Edge(9, "G", "E"));
    KruskalPath kruskalPath = new KruskalPath();
    System.out.println("mst: " + kruskalPath.kruskalFunc(vertices, edges));
  }
  
}

class KruskalPath {
  HashMap<String, String> parent;
  HashMap<String, Integer> rank;
  KruskalPath(){
    parent = new HashMap<String, String>();
    rank = new HashMap<String, Integer>();
  }
  //루트노드 찾기
  public String find(String node){
    //찾고자하는 노드가 부모노드가 아니면
    if(this.parent.get(node) != node){
      //루트노드를 찾을 때 까지 반복해서 부모노드로 루트노드를 셋
      this.parent.put(node, this.find(this.parent.get(node)));
    }
    //루트노드이면 리턴
    return this.parent.get(node);
    
  }

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

