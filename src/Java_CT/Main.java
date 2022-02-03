package Java_CT;
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
        priorityQueue.add(distances.get(start));
        while(priorityQueue.size() != 0){
            Edge poll = priorityQueue.poll();
            distances.remove(poll.node);
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
        System.out.println(mst);
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
