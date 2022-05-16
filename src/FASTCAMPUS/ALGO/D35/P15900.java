package FASTCAMPUS.ALGO.D35;
import java.io.*;
import java.util.*;

public class P15900 {
    static int N, count;
    static ArrayList<Integer> [] graph;
    static void input() {
        FastReader scan = new FastReader();
        count = 0;
        N = scan.nextInt();
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i ++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < N; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        
    }
    static void dfs(int s, int depth, int prev){
        if(s != 1 && graph[s].size() == 1){
          count += depth;
          return;
        }
        for (Integer e : graph[s]) {
            if(prev == e) continue;  
            dfs(e, depth + 1, s);
        }
      }
    public static void pro(){
        dfs(1, 0, 0);
        if(count % 2 == 0){
            System.out.println("No");
        } else {
            System.out.println("Yes");
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