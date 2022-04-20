package FASTCAMPUS.ALGO.D30;
import java.io.*;
import java.util.*;

public class P11728 {
    static int N, M; //배열A와 배열 B의 크기( 1<= N, M <= 10^6);
    static int [] A;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int [N + M];
        for(int i = 0; i < N; i ++) {
            A[i] = scan.nextInt();
        }
        for(int i = 0; i < M; i ++){
            A[N + i] = scan.nextInt();
        }
        sb = new StringBuilder();
    }
    public static void pro(){
        Arrays.sort(A);
        for (int i : A) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);
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