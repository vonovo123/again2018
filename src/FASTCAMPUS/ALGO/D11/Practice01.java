package FASTCAMPUS.ALGO.D11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Practice01 {
    public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //vertex
      int N = Integer.parseInt(br.readLine());
      //edge
      int M = Integer.parseInt(br.readLine());
      ArrayList<String> vertices = new ArrayList<String>();
      for(int i = 1; i <= N; i ++){
        vertices.add(i+"");
      }
      ArrayList<Edge> edges = new ArrayList<Edge>();
      for(int i = 0; i < M; i ++){
        String [] parsed = br.readLine().split(" ");
        edges.add(new Edge(Integer.parseInt(parsed[2]), parsed[0], parsed[1]));
      }
      Collections.sort(edges);
      Kruscal kruscal = new Kruscal();
      int result =kruscal.search(vertices, edges);
      
    }
}

class Kruscal {
  HashMap<String, String> parent = new HashMap<String,String>();
  HashMap<String ,Integer> rank = new HashMap<String, Integer>();
  
  //루트노드 찾기
  //path-compression 방식
  public String find(String node) {
    if(parent.get(node) != node){
      parent.put(node, this.find(parent.get(node)));
    }
    return parent.get(node);
  }
  //노드합치기
  //union-by-rank 방식
  //루트노드의 랭크가 높은쪽을 기준으로 합친다.
  //랭크가 같으면 한쪽 루트노드에 합치고 합친 루트노드의 랭크를 올린다.
  public void union(String nodeU, String nodeV ){
    String rootU = this.find(nodeU);
    String rootV = this.find(nodeV);
    int rankU = rank.get(rootU);
    int rankV = rank.get(rootV);
    if(rankU > rankV){
      parent.put(rootV, rootU);
    } else {
      parent.put(rootU, rootV);
      if(rankU == rankV){
        this.rank.put(rootV, this.rank.get(rootV) + 1);
      }
    }
  }
//노드별 parent/rank 초기화
//각 노드의 부모노드는 각 노드
//각 노드의 랭크는 모두 0으로 시작
  public void init(String node){
    parent.put(node, node);
    rank.put(node, 0);
  }

  public int search(ArrayList<String> vertices, ArrayList<Edge> edges){
    ArrayList<Edge> mst = new ArrayList<Edge>();
    int result = 0;
    for (String vertex : vertices) {
      this.init(vertex);
    }
    for (Edge edge : edges) {
      String nodeV = edge.nodeV;
      String nodeU = edge.nodeU;
      String rootV = this.find(nodeV);
      String rootU = this.find(nodeU);
      //싸이클이 아니면 
      if(rootV != rootU){
        this.union(nodeV, nodeU);
        mst.add(edge);
      }
    }
    for (Edge edge : mst) {
      result += edge.weight;
    }
    return result;
  }
  
}

class Edge implements Comparable<Edge> {
  int weight;
  String nodeV;
  String nodeU;
  Edge(int weight, String nodeV, String nodeU){
    this.weight = weight;
    this.nodeV = nodeV;
    this.nodeU = nodeU;
  }

  @Override
  public String toString() {
    return "weight : " + this.weight + " nodeV : " + this.nodeV + " nodeU: "  + nodeU;
  }
  @Override
  public int compareTo(Edge e) {
    return this.weight - e.weight;
  }

}
