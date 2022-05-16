package FASTCAMPUS.ALGO.D24;
import java.io.*;
import java.util.*;

public class P2579 {
    static int N;
    static int [] weightA;
    static int[][] stairs;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        weightA = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            weightA[i] = scan.nextInt();
        }
        stairs = new int[N + 1][2];
    }
    public static void pro(){
        // 0 : i - 1 번째를 밟지않고 오는경우
        // 1 : i -1 번째를 밟고오는경우
        stairs[0][0] = 0;
        stairs[0][1] = 0;
        stairs[1][0] = weightA[1];
        stairs[1][1] = weightA[1];
        for(int i = 2; i <= N; i ++){
            // 0 :  i - 1를 밟지않은경우 i - 2의 최대값 과 현재값
            // 1 : i -1을 밟은 경우 i-1의 0과 현재값 
            stairs[i][0] = Math.max(stairs[i - 2][0], stairs[i - 2][1]) + weightA[i];
            stairs[i][1] = stairs[i - 1][0] + weightA[i];
        }
        System.out.println(Math.max(stairs[N][0], stairs[N][1]));
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