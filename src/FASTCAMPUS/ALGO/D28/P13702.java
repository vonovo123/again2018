package FASTCAMPUS.ALGO.D28;
import java.io.*;
import java.util.*;

public class P13702 {
    // 주문한 막걸리 주전자의 수 N
    // 나눠줄 친구 K명
    // 한명에게 나눠줄수 없는 남은막걸리는 버린다.
    // K 명에게 나눠줄 수 있는 최대한 많은 양의 막걸리를 분배할 수 있는 용량
    //  1 <= N <= 10^4
    //  1 <= K <= 10^6
    // A[i] <= Integer
    static int N, M;
    static int [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static boolean determination(long D){
        if(D == 0) return false;
        long count = 0;
        for(int i = 1; i <= N; i ++){
            int left = A[i];
            count += left / D;
        }
        //System.out.printf("D: %d count : %d\n", D, count);
        return count >= M;
    }
    public static void pro(){
        long L = 0;
        long R = Integer.MAX_VALUE;
        long result = 0;
        while(L <= R) {
            long mid = (L + R) / 2;
            if(determination(mid)){
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(result);
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