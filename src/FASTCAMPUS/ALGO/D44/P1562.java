package FASTCAMPUS.ALGO.D44;
import java.io.*;
import java.util.*;

public class P1562 {
    static int N;
    static int [] arr;
    static int[][] min_dy;
    static int[][] max_dy;
    static FastReader scan = new FastReader();
    static void input() {
        N = scan.nextInt();
        arr = new int [4];
        min_dy = new int [2][4];
        max_dy = new int [2][4];
    }
    
    public static void pro(){
        for(int i = 1; i < 4; i ++){
         arr[i] = scan.nextInt();
         min_dy[1][i] = arr[i];
         max_dy[1][i] = arr[i];
        }
        for(int i = 2; i <= N; i ++){
            for(int j = 1; j < 4; j ++){
                arr[j] = scan.nextInt();
            }
            for(int cur = 1; cur < 4; cur ++){
                min_dy[i % 2][cur] = Integer.MAX_VALUE;
                max_dy[i % 2][cur] = 0;
                for(int prev = 1; prev < 4; prev ++){
                    if(Math.abs(cur - prev) > 1) continue;
                    min_dy[i % 2][cur] = Math.min(min_dy[i % 2][cur], min_dy[(i + 1) % 2][prev] + arr[cur]); 
                    max_dy[i % 2][cur] = Math.max(max_dy[i % 2][cur], max_dy[(i + 1) % 2][prev] + arr[cur]); 
                }
            }
        }
        int min = Math.min(Math.min(min_dy[N % 2][1], min_dy[N % 2][2]), min_dy[N % 2][3]);
        int max  = Math.max(Math.max(max_dy[N % 2][1], max_dy[N % 2][2]), max_dy[N % 2][3]);
        System.out.println(max + " " + min);
        
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