package WEEK41;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class P42627 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
    int [][] jobs = {{0, 3},{1,9},{2,6}};
    System.out.println(solution(jobs));
  }

  static int solution(int[][] jobs){
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });
    int i = 0;
    int answer = 0;
    int start = -1;
    int now = 0;
    while(i < jobs.length){
      for(int j = 0; j < jobs.length; j ++){
        int s = jobs[j][0];
        if(s > start && s <= now ){
          pq.add(jobs[j]);
        }
      }
      if(pq.size() == 0){
        now ++;
      } else {
        int [] task = pq.poll();
        // 시작시간
        start = now;
        // task 끝난시간
        now += task[1];
        answer += now - task[0];
        i ++;
      }
    }
    return answer / jobs.length;
  }
}