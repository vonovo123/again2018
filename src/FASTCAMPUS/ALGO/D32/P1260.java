package FASTCAMPUS.ALGO.D32;
import java.io.*;
import java.util.*;

public class P1260 {
    static int N, M, V;
    static StringBuilder sb;
    static ArrayList<Integer>[] graph;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i ++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            int va = scan.nextInt();
            int vb = scan.nextInt();
            graph[va].add(vb);
            graph[vb].add(va);
        }
        for(int i = 1; i <= N; i ++){
            Collections.sort(graph[i]);
        }
    }
    public static void BFS(ArrayList<Integer>[] vertices, int startNode, ArrayList<Integer> visited){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startNode);
        while(!queue.isEmpty()){
            int next = queue.poll();
            if(visited.indexOf(next) == -1){
                visited.add(next);
                ArrayList<Integer> needVisited = vertices[next];
                for (int i : needVisited) {
                    queue.add(i);
                }
            }
        }
    }

    public static void DFS(ArrayList<Integer>[] graph, int start, ArrayList<Integer> visited){
        ArrayList<Integer> needVisit = graph[start];
        visited.add(start);
        for ( Integer node : needVisit) {
            if(visited.indexOf(node) == -1){
                DFS(graph, node, visited);
            }
        }
    }
    public static void pro(){
        ArrayList<Integer> visited = new ArrayList<Integer>();
        DFS(graph, V,visited);
        sb = new StringBuilder();
        for (Integer integer : visited) {
            sb.append(integer);
            sb.append(" ");
        }
        System.out.println(sb);
        visited = new ArrayList<Integer>();
        BFS(graph, V, visited);
        sb = new StringBuilder();
        for (Integer integer : visited) {
            sb.append(integer);
            sb.append(" ");
        }
        System.out.println(sb);
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