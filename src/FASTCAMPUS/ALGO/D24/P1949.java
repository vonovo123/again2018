package FASTCAMPUS.ALGO.D24;
import java.io.*;
import java.util.*;

public class P1949 {
    static int N;
    //인구수
    static int [] A;
    static ArrayList<Integer>[] con;
    static int[][] Dy;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1];
        con = new ArrayList[N + 1];
        Dy = new int [N + 1][2];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
            con[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < N; i ++){
            int to = scan.nextInt();
            int from = scan.nextInt();
            con[to].add(from);
            con[from].add(to);
        }
    }
    public static void dfs(int x, int prev){
        //자기자신 포함 됨
        Dy[x][0] = A[x];
        //자기자신 포함 안됨
        Dy[x][1] = 0;
        for(int y : con[x]){
            if(y == prev) continue;
            dfs(y, x);
            Dy[x][0] += Dy[y][1];
            Dy[x][1] += Math.max(Dy[y][0],Dy[y][1]);
        }
    }
    public static void pro(){
        dfs(1, 0);
        int max = Math.max(Dy[1][0], Dy[1][1]);
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