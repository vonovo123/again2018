package FASTCAMPUS.ALGO.D30;
import java.io.*;
import java.util.*;

public class P2559 {
    // 연속된 온도의 합 중 가장 큰값
    // N : 전체날짜의 수 ( 2 <= N <= 10^5)
    // K : 연속적인 날짜의 수 ( 1 <= K <= N)
    // A : 온도 수열 ( -100 <= A[i] <= 100 )
    static int N, K;
    static int [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int [N];
        for(int i = 0 ; i < N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        int L = 0;        
        int sum = 0;
        int max = 0;
        for(int R = 0; R < N; R ++){
            if(R < K){
                sum += A[R];
                if(R == K - 1){
                    //System.out.println(sum);
                    max = Math.max(max, sum);
                }
            } else {
                sum -= A[L];
                sum += A[R];
                L ++;
                max = Math.max(max, sum);
            }       
        }
        System.out.println(max);
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