package FASTCAMPUS.ALGO.D19;
import java.io.*;
import java.util.*;

public class P2470 {
    //용액의 특성값 A[i]
    //-1,000,000,000 <= A[i] <= 1000000000 Integer
    // 용액 두개를 합친값 -2000000000 <= sum <= 2000000000 Integer
    // 전체용액의 수 N
    // 2 <= N <= 100000
    // 용액 두개를 합친값이 0과 가장 가까운 경우를 구하시오
    static int N;
    static int[] A;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();        
        A = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
        sb= new StringBuilder();
    }
    static void pro(){
        int L = 1;
        int R = N;
        int A1 = 0;
        int A2 = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(A, 1, N + 1);

        //-99 -2 -1 4 98
        while(L < R){
            int sum = A[L] + A[R];
            if(min > Math.abs(sum)){
                min = sum;
                A1 = A[L];
                A2 = A[R];
            }
            //최소 + 최대의 값이 < 0
            if(sum < 0){
                L ++;
            } else if(sum > 0){
                R --;
            } else {
                break;
            }
        }
        sb.append(A1).append(" ").append(A2);
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