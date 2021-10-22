package WEEK40;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P42584 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
      String [] initialPrices = br.readLine().split(",");
      int [] prices = new int [initialPrices.length];

      for(int i = 0; i < initialPrices.length; i ++){
        prices[i] = Integer.parseInt(initialPrices[i]);
      }
      Stack<Integer> s = new Stack<Integer>();
      int [] answer = Solution(prices);

      for (int i : answer) {
          System.out.println(i);
      }
      //1,2,3,2,3
    }
    static int [] Solution(int[] prices){
      int [] answer = new int [prices.length];
      Stack<int[]> s = new Stack<int[]>();
     for (int i = 0; i < prices.length; i ++) {
      int [] kv = {i, prices[i]};
       if(s.size() == 0){
         s.push(kv);
       } else {
         //새로운 가격보다 낮은 가격들을 스택에서 뺀다.
        while(s.peek()[1] > prices[i]){
            int [] p = s.pop();
            answer[p[0]] = i - p[0]; 
            if(s.size() == 0) break;
        }
        s.push(kv);
       }
     }
     while(s.size()!=0){
      int[] p = s.pop();
      answer[p[0]] = prices.length - 1 - p[0];
    }
    //  for (int a : answer) {
    //    System.out.println("a" + a);
    //  }
      return answer;
    }
}