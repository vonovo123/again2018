package FASTCAMPUS.ALGO.D15;

import java.io.*;
import java.util.*;
//O(N!/M!(N-M)!)
public class P15650 {
  static int N,M;
  static int[] selected;
  static StringBuilder sb;
  static void input() {
      FastReader scan = new FastReader();
       N = scan.nextInt();
       M = scan.nextInt();
       selected = new int[M + 1];
       sb = new StringBuilder();
  }
    public static void main(String[] args) {
      input();
      rec_func(1);
      System.out.println(sb);
    }

    static void rec_func(int k){
      if(k == M + 1){
        for(int i = 1; i <= M; i ++){
          sb.append(selected[i]).append(" ");
        }
        sb.append("\n");
        return;
      }
      int start = selected[k - 1];
      for(int cand = start + 1; cand <= N; cand ++) {
            selected[k] = cand;
            rec_func(k + 1);
            selected[k] = 0;
      }
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