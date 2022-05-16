package FASTCAMPUS.ALGO.D49;
import java.io.*;
import java.util.*;

public class P21940 {
    public static FastReader scan;
    public static final int INF = (int)1e9;
    public static int n,m;
    public static int [][] graph;
    static void input() {
        scan = new FastReader();
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new int [201][201];
    }
    public static void pro(){
        for(int i = 0; i < 201; i ++){
            Arrays.fill(graph[i], INF);
        }
        for(int a = 1; a <= n; a ++){
            for(int b = 1; b <= n; b ++){
                if(a == b) graph[a][b] = 0;
            }
        }
        for(int i = 0; i < m; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int cost = scan.nextInt();
            graph[a][b] = cost;
        }
        for(int k = 1; k <= n; k ++){
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= n; j ++){
                    graph[i][j] = Math.min(graph[i][j], (graph[i][k] + graph[k][j]));
                }
            }
        }
        int k = scan.nextInt();
        ArrayList<Integer> friends = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i ++){
            int c = scan.nextInt();
            friends.add(c);
        }
        int max = INF;
        for(int i = 1; i <= n; i ++){
            int now = 0;
            for(int j = 0; j < friends.size(); j ++){
                int friend = friends.get(j);
                now = Math.max(now, graph[friend][i] + graph[i][friend]);
            }
            if(max > now){
                result.clear();
                result.add(i);
                max = now;
            } else if(max  == now){
                result.add(i);
            }
        }

        for(int i = 0; i < result.size(); i ++){
            System.out.print(result.get(i)  + " ");
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