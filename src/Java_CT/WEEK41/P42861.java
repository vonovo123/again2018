package WEEK41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P42861 {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = 5;
    int [][] costs = {{0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {0, 4, 4}, {1, 3, 1}};
    solution(n, costs);
  } 
  static HashMap <Integer, Integer> parents;
  static int getParent(int node){
      if(parents.get(node) == node){
        return node;
      }
      return getParent(parents.get(node));
  }

  static void unionFind (int start, int end){
    int sParent = getParent(start);
    int eParent = getParent(end);
    Iterator<Integer> itr = parents.keySet().iterator();
    if(sParent < eParent) {
      while(itr.hasNext()){
        int parent = itr.next();
        if(parents.get(parent) == end){
          parents.put(parent, start);
        }
      }
    } else {
      while(itr.hasNext()){
        int parent = itr.next();
        if(parents.get(parent) == start){
          parents.put(parent, end);
        }
      }
    }
  }
  
  static int solution(int n, int [][] costs){
      parents = new HashMap<Integer, Integer> ();
      Arrays.sort(costs, new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2) {
          return o1[2] - o2[2];
        }
      });
      //각 노드의 시작점은 자신
      for (int[] cost : costs) {
        parents.put(cost[0], cost[0]);
        parents.put(cost[1], cost[1]);
      }
      int answer = 0;
      for (int[] cost : costs) {
        int start = cost[0];
        int end = cost[1];
        //시작노드 비교
        start = parents.get(start);
        end =  parents.get(end);
        //시작노드가 다르면
        if(start != end){
          answer += cost[2];
          unionFind(start, end);
        }
        int flag = 1;
        Iterator<Integer> itr = parents.keySet().iterator();
        int compare = -1;
        while(itr.hasNext()){
          int parent = parents.get(itr.next());
          if(compare == -1) compare = parent;
          else {
            if(compare != parent){
              flag = 0;
              break;
            }
          }
        }
        System.out.println(flag);
        if(flag == 1){
          System.out.println(parents);
          System.out.println(answer);
          break;
        }
        
      }
      
      
      return answer;
    }
}
