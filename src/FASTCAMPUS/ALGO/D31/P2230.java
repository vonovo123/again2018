package FASTCAMPUS.ALGO.D31;
import java.io.*;
import java.util.*;

public class P2230 {
    static int N, M;
    static int [] A;
    //N개의 정수로 이루어진 배열 A
    //문제의 조건을 만족하는 배열 내 두 수의 차의 최소값 M
    // 1 <= N <= 10^5
    // 1 <= M <= 2 * 10^9
    // 0 <= A[i] <= 10 ^ 7
    // 정렬 시간복잡도 10^5 * log 10^5
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        Arrays.sort(A, 1, N + 1);
        int R = 1;
        int min = 2000000000;
        for(int L = 1; L <= N; L ++){
            while(R < N && A[R] - A[L] < M){
                R ++;
            }
            if(A[R] - A[L] >= M){
                min = Math.min(min, A[R] - A[L]);
            }
        }
        System.out.println(min);
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