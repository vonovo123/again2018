package FASTCAMPUS.ALGO.D30;
import java.io.*;
import java.util.*;

public class P2003 {
    // N개의 수로된 수열 A
    // 이 수열의 i ~ j번째 까지의 수의 합이 M이 되는 경우의 수
    // 1<= N <= 10^4
    // 1<= M <= 3 * 10^8
    // 1 <= A[i] <= 3 * 10^4
    static int N, M;
    static int [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int [N];
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        int L = 0;
        int sum = 0;
        int count = 0;
        for(int R = 0; R < N; R ++ ){
            sum += A[R];
            if(sum > M){
                while(sum > M){
                    sum -= A[L];
                    L ++;
                }
                if(sum == M){
                    count ++;
                }
            } else if( sum == M){
                count ++;
            }
        }
        System.out.println(count);
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