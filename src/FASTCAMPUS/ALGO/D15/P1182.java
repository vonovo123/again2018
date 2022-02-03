package FASTCAMPUS.ALGO.D15;
import java.io.*;
import java.util.*;

public class P1182 {
  static int N, S, count;
  static int [] arr, selected;
  static void input() {
      FastReader scan = new FastReader();
      N = scan.nextInt();
      S = scan.nextInt();
      count = 0;
      arr = new int [N + 1];
      selected = new int [N + 1];
      for(int i = 1; i <= N; i ++){
        arr[i] = scan.nextInt();
      }
  }
  public static void rec_func(int k, int value, int[] test) {
    if(k == N + 1) {
      if(value == S){
        count ++;
      }
    } else {
      //포함
      test[k] = k;
      rec_func(k + 1, value + arr[k], test);
      //미포함
      test[k] = -1;
      rec_func(k + 1, value, test);
    }
  }
  public static void main(String[] args) {
      input();
      rec_func(1, 0, new int [N + 1]);
      if(S == 0){
        count --;
      }
      System.out.println(count);
  }
  static class FastReader {
      BufferedReader br;
      StringTokenizer st;

      public FastReader() {
          br = new BufferedReader(new InputStreamReader(System.in));
      }

      public FastReader(String s) throws FileNotFoundException {
          br = new BufferedReader(new FileReader(new File(s)));
      }

      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }

      int nextInt() {
          return Integer.parseInt(next());
      }

      long nextLong() {
          return Long.parseLong(next());
      }

      double nextDouble() {
          return Double.parseDouble(next());
      }

      String nextLine() {
          String str = "";
          try {
              str = br.readLine();
          } catch (IOException e) {
              e.printStackTrace();
          }
          return str;
      }
  }
}