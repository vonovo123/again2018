package FASTCAMPUS.ALGO.D09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    String startNode = "A";
    HashMap <String,ArrayList<String>> graph = new HashMap<String,ArrayList<String>>();
    graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
    graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
    graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
    graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
    graph.put("E", new ArrayList<String>(Arrays.asList("D")));
    graph.put("F", new ArrayList<String>(Arrays.asList("D")));
    graph.put("G", new ArrayList<String>(Arrays.asList("C")));
    graph.put("H", new ArrayList<String>(Arrays.asList("C")));
    graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
    graph.put("J", new ArrayList<String>(Arrays.asList("I")));
    BFS bfs = new BFS();
    DFS dfs = new DFS();
    System.out.println(graph);
    dfs.search(graph, "A");
  }
}

class BFS {
  public void search(HashMap<String, ArrayList<String>> graph, String start){
    ArrayList<String> visited = new ArrayList<String>();
    ArrayList<String> needVisited = new ArrayList<String>();
  
    needVisited.add(start);
    while(needVisited.size() != 0){
      String next = needVisited.remove(0);
      if(!visited.contains(next)){ 
        visited.add(next);
        needVisited.addAll(graph.get(next));
      } 
    }
    System.out.println(visited);
  }
}

class DFS {
  public void search(HashMap<String, ArrayList<String>> graph,String start){
    ArrayList<String> visited = new ArrayList<String>();
    ArrayList<String> needVisited = new ArrayList<String>();

    needVisited.add(start);
    while(needVisited.size() != 0){
      String next = needVisited.remove(needVisited.size() - 1);
      if(!visited.contains(next)){
        visited.add(next);
        needVisited.addAll(graph.get(next));
      }
    }
    System.out.println(visited);
  }
}