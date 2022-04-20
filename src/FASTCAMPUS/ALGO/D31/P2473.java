import java.io.*;
import java.util.*;

public class Main {
    //전체 용액의 수 N(3 <= N <= 5000)
    //길이가 N인 배열 A ( -10^9 <= A[i] <= 10^9 )
    static int N;
    static int [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N];
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        Arrays.sort(A);
        int v1 = 0, v2 = 0, v3 = 0;
        long total = Long.MAX_VALUE;
        for(int i = 0; i < N -2; i ++){
            //합치면 0이 되는 값
            int target = -A[i];
            int L = i + 1;
            int R = N - 1;
            while(L < R){
                if(Math.abs(A[i] + A[L] + A[R]) < total){
                    total = Math.abs(-(long)target + A[L] + A[R]);
                    v1 = -target;
                    v2 = A[L];
                    v3 = A[R];  
                }
                if(A[L] + A[R] > target) R --;
                else L ++; 
            }
        }
        System.out.printf("%d %d %d\n", v1,v2,v3);
 
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