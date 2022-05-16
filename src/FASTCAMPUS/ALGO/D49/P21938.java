package FASTCAMPUS.ALGO.D49;
import java.io.*;
import java.util.*;

public class P21938 {
    public static int n, m;
    public static int [][] arr;
    static void input() {
        FastReader scan = new FastReader();
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int [n][m];
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j < m; j ++){
                int sum = 0;
                for(int k = 0; k < 3; k ++ ){
                    sum +=  scan.nextInt();
                }
                arr[i][j] = sum;
            }
        }
        int threshold = scan.nextInt();
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j < m; j ++){
                if(arr[i][j] / 3 > threshold) arr[i][j] = 255;
                else arr[i][j] = 0;
            }
        }        
    }
    public static void dfs(int y, int x){
        if(y <= -1 || y >= n || x <= -1  || x >= m )return;
        if(arr[y][x] == 255){
            arr[y][x] = 0;
            dfs(y - 1, x);
            dfs(y + 1, x);
            dfs(y, x - 1);
            dfs(y, x + 1);
        }
    }
    public static void pro(){
        int result = 0;
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j < m; j ++){
                if(arr[i][j] == 255){
                    result += 1;
                    dfs(i,j);
                }
                
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