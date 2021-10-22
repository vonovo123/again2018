package WEEK41;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P42626 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String [] input = br.readLine().split(",");
    int K = Integer.parseInt(br.readLine());
    int [] scoville = new int [input.length];
    for(int i =0 ; i < input.length; i ++){
      scoville[i] = Integer.parseInt(input[i]);
    }
    //1,2,3,9,10,12
    //7

    //12,10,9,3,2,1
    //7
    System.out.println(solution(scoville, K));
    
  }
  static int solution(int [] scoville, int K){
    // 우선순위가 낮은 숫자 순
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return o1 - o2;
      }
    });
    for(int i = 0; i < scoville.length; i ++){
      pq.add(scoville[i]);
    }
    //Iterator<Integer> itr = pq.iterator();
    int result = 0;
    while(pq.peek() < K){
      result ++;
      int a = pq.poll();
      int b = pq.poll();
      pq.add(a + 2 * b);
    }
    return result;
  }
}