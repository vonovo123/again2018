package WEEK41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P43164 {
  
  static Vector<String> v;
  static Vector<String> answerV;
  static Hashtable<String, LinkedList<String>> hs;
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //String [][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    //String [][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    String [][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
    
    solution(tickets);
  } 
  
  static String[] solution(String[][] tickets){
   hs = new Hashtable<String, LinkedList<String>>();
   v = new Vector<String>();
   answerV = new Vector<String>();
    for(int i = 0; i < tickets.length; i ++){
      String [] ticket = tickets[i];
      if(!hs.containsKey(ticket[0])){
        LinkedList<String> pq = new LinkedList<String>();
        hs.put(ticket[0], pq);
      }
      hs.get(ticket[0]).add(ticket[1]);
    }
    v.add("ICN");
    dfs("ICN");
    answerV.sort(new Comparator<String>(){
      @Override
      public int compare(String o1, String o2) {
        if(o2.length() - o1.length() == 0 ){
          //양수면 내림차순
          for(int i = 0; i < o2.length(); i ++){
            if(o2.charAt(i) != o1.charAt(i)){
              return o1.charAt(i) - o2.charAt(i);
            }
          }
        }
        return o2.length() - o1.length();
      }
    });
 
    String [] answer = answerV.get(0).split(",");
    for(int i = 0; i < answer.length; i ++){
      System.out.println(answer[i]);
    }
    return answer;
  }
  static void dfs(String depart){
    if(hs.get(depart) == null || hs.get(depart).size() == 0){
      String answer = "";
      for(int i = 0; i < v.size(); i ++){
        if(i != v.size() - 1){
          answer += v.get(i);
          answer += ",";
        } else {
          answer += v.get(i);
        }
        
      }
      answerV.add(answer);
      return;
    }
    LinkedList<String> ll = hs.get(depart);
    for(int i = 0; i < ll.size(); i ++){
      String arrive = ll.poll();
      v.add(arrive);
      dfs(arrive);
      ll.add(arrive);
      v.remove(v.size() - 1);
    }
  }
}

