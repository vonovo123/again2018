package FASTCAMPUS.ALGO.D20;
import java.io.*;
import java.util.*;

public class P1260 {
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> A;
    static int [] visited;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        A = new ArrayList<ArrayList<Integer>>();
        A.add(0, null);
        sb = new StringBuilder();
        for(int i = 1; i <= N; i ++){
            A.add(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < M; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            A.get(a).add(b);
            A.get(b).add(a);
        }
        for(int i = 1; i <= N; i ++){
            Collections.sort(A.get(i));
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(A);
        sb = new StringBuilder();
        visited = new int [N + 1];
        dfs(V);
        sb.append("\n");
        visited = new int [N + 1];
        bfs(V);
        System.out.println(sb.substring(0, sb.length() - 1));
    }
    static void dfs(int idx){
        visited[idx] = 1;
        sb.append(idx).append(" ");
        ArrayList<Integer> degresses = A.get(idx);
        for(int i = 0; i < degresses.size(); i ++){
            int degress = degresses.get(i);
            if(visited[degress] == 0){
                dfs(degress); 
            }
        }
    }
    static void bfs(int idx){
        visited[idx] = 1;
        ArrayList<Integer> que = new ArrayList<Integer>();
        que.add(idx);
        while(que.size() != 0){
            int poll = que.remove(0);
            sb.append(poll).append(" ");
            ArrayList<Integer> degresses = A.get(poll);
            for(int i = 0; i < degresses.size(); i ++){
                int degress = degresses.get(i);
                if(visited[degress] == 0){
                    que.add(degress);
                    visited[degress] = 1;
                }
            }
        }
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