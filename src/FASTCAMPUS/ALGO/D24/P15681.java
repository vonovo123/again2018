package FASTCAMPUS.ALGO.D24;
import java.io.*;
import java.util.*;

public class P15681 {
    static int N, R, Q; 
    static ArrayList<Integer> [] Edges;
    static int [] parents;
    static int [] Dy;
    static int [] U;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        Edges = new ArrayList[N + 1];
        parents = new int[N + 1];
        Dy = new int [N + 1];
        U = new int [Q];
        for(int i = 1; i <= N; i ++){
            Edges[i] = new ArrayList<Integer>();
            Dy[i] = 1;
        }
        for(int i = 1; i < N; i ++){
            int to = scan.nextInt();
            int from = scan.nextInt();
            Edges[to].add(from);
            Edges[from].add(to);
        }
        for(int i = 0; i < Q; i ++){
            U[i] = scan.nextInt();
        }
 
    }
    static void dfs(int x, int prev){
        ArrayList<Integer> candidate = Edges[x];
        Dy[x] = 1;
        for (Integer y : candidate) {
            if(y == prev) continue;
            dfs(y, x);
            Dy[x] +=  Dy[y];
        }
    }
    public static void pro(){
        dfs(R, 0);
        for(int i = 0; i < U.length ; i ++ ){
            System.out.println(Dy[U[i]]);
        }

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