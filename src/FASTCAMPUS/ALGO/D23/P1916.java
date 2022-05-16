package FASTCAMPUS.ALGO.D23;
import java.io.*;
import java.util.*;

public class P1916 {
    static class Edge{
        int to;
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }   
    static class Info {
        public int idx, dist;
        Info(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    // 도시 수, 버스 수, 시작도시, 도착도시
    static int N, M, S,E;
    // 도시 간 버스 운행 정보
    static ArrayList<Edge> [] edges;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        edges = new ArrayList[N + 1];
        for(int i = 1; i <= N; i ++){
            edges[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < M; i ++){
            //출발도시
            int from = scan.nextInt();
            //도착도시
            int to = scan.nextInt();
            //비용
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        S = scan.nextInt();
        E = scan.nextInt();
    }

    static void dijkstra(int start){
        //S 도시에서 각 도시간 비용
        int [] dist = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Info> pq = new PriorityQueue<Info>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(dist[info.idx] < info.dist ) continue;
            for(Edge e : edges[info.idx]){
                if(dist[info.idx] + e.weight >= dist[e.to] ) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }   
        }
        System.out.println(dist[E]);
    }
    public static void pro(){
        dijkstra(S);
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