package FASTCAMPUS.ALGO.D24;
import java.io.*;
import java.util.*;

public class P11057 {
    static int N;
    static int A[][];
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1][10];
    }
    public static void pro(){
        for(int i = 0; i < 10; i ++){
            A[1][i] = 1;
        }
        for(int i = 2; i <= N; i ++){
            //끝자리가 j
            for(int j = 0; j < 10; j ++){
                for(int k = 0; k <= j; k ++){
                    A[i][j] += A[i - 1][k]; 
                    A[i][j] %= 10007;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 10; i ++){
            sum += A[N][i];
            sum %= 10007;
        }
          System.out.println(sum);
    }
    public static void main(String[] args) {
        input();
        pro();
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