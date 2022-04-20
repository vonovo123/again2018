package FASTCAMPUS.ALGO.D28;
import java.io.*;
import java.util.*;

public class P6236 {
    static int N, M;
    static int[] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static boolean determination(int D){
        int cnt = 1;
        int amount = D;
        for(int i = 1; i <= N; i ++){
            if(amount >= A[i]){
                amount -= A[i];
            } else {
                cnt ++;
                amount = D - A[i];
            }
        }
        return cnt <= M;
    }
    public static void pro(){
        int L = A[1];
        for (int i : A) {
            L = Math.max(L, i);
        }
        int R = 1000000000;
        int result = 0;
        while(L <= R){
            int mid = (L + R) / 2;
            if(determination(mid)){
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
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