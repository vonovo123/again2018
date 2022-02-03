package FASTCAMPUS.ALGO.D15;
import java.io.*;
import java.util.*;
//o(N!/(N-M)!)
public class P15649 {
    static int N, M;
    static ArrayList<Integer> selected;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new ArrayList<Integer>(M);
        sb = new StringBuilder();
    }
    public static void main(String[] args) {
        input();
        rec_func(1);
        
    }
    public static void rec_func(int k){
      if( k == M + 1){
        System.out.println(selected);
        return;
      } else {
        for(int cand = 1; cand <= N; cand ++){
          if(selected.indexOf(cand) == -1){
            selected.add(cand);
            rec_func(k + 1);
            selected.remove(selected.size() - 1);
          }
            
        }
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