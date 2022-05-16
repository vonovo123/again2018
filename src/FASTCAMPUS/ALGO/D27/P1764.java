package FASTCAMPUS.ALGO.D27;
import java.io.*;
import java.util.*;

public class P1764 {
    static int N,M;
    static String [] A,B;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N + 1];
        B = new String[M + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextLine();
        }
        for(int i = 1; i <= M; i ++){
            B[i] = scan.nextLine();
        }
        sb = new StringBuilder();

    }
    public static void pro(){
        Arrays.sort(A, 1, N + 1);
        Arrays.sort(B, 1, M + 1);
        int count = 0;
        for(int i = 1; i <= N; i ++){
            String D = A[i];
            int L = 1;
            int R = M;
            while(L <= R){
                int mid = (L + R) / 2;
                if(D.compareTo(B[mid]) < 0){
                    R = mid - 1;
                } else if(D.compareTo(B[mid]) > 0){
                    L = mid + 1;
                } else {
                    count ++;
                    sb.append(D).append("\n");
                    break;
                }
            }
        }
        System.out.println(count);
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