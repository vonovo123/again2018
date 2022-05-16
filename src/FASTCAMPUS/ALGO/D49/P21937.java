package FASTCAMPUS.ALGO.D49;
import java.io.*;
import java.util.*;

public class P21937 {
    public static int N, M, x;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited; 
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean [N + 1];
        for(int i = 0; i <= N; i ++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i <= M; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(b).add(a);
        }
        x = scan.nextInt();
    }
    public static void pro(){
        Queue <Integer> q = new LinkedList<Integer>();
        q.add(x);
        visited[x] = true;
        int result  = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            result += 1;
            for(int i = 0; i < graph.get(now).size(); i ++){
                int next = graph.get(now).get(i);
                if(visited[next]) continue;
                visited[now] = true;
                q.add(next);
            }
        }
        System.out.println(result - 1);
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