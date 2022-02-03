import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class P42576 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
      String[] participant = br.readLine().split(",");
      String[] completion = br.readLine().split(",");
      String answer = solution(participant, completion);
      System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion){
      Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
      for (String p : participant) {
        if(ht.containsKey(p)){
          ht.put(p, ht.get(p) + 1);
        } else {
          ht.put(p, 1);
        }
      }
      for (String c : completion) {
        if(ht.containsKey(c)){
          ht.put(c, ht.get(c) - 1);
        }
      }
      Iterator <String> itr = ht.keySet().iterator();
      while(itr.hasNext()){
        String key = itr.next();
        if(ht.get(key) == 1){
          System.out.println(key);    
        }
      }
      
      return "";
    }
}