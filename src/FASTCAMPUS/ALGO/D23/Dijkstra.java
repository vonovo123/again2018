package FASTCAMPUS.ALGO.D23;
import java.io.*;
import java.util.*;

public class Dijkstra {
    static class Edge implements Comparable<Edge>{
        int dest, value;
        Edge(int dest, int value){
            this.dest = dest;
            this.value = value;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.value - o.value;
        }
    }
    static ArrayList<Hashtable<Integer, Integer>> arr;
    static void input() {
        FastReader scan = new FastReader();
    }
    static void dijkstra(int start){
        int N = 6;
        int [] dist = new int [N];
        for(int i = 1; i < N; i ++){
            if(i == start) dist[i] = 0;
            else dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        queue.add(new Edge(start, 0));
        while(!queue.isEmpty()) {
            Edge poll = queue.poll();
            int dest = poll.dest;
            int value = poll.value;
            if(value <= dist[dest]){
                Hashtable<Integer, Integer> edges = arr.get(dest);
                for (int key : edges.keySet()) {
                    int nValue = edges.get(key);
                    if(value + nValue < dist[key]){
                        dist[key] = value+ nValue;
                        queue.add(new Edge(key, dist[key]));
                    }
                }
            }
        }
        for (int t : dist) {
            System.out.println(t);
        }
    }
    public static void pro(){
        arr = new ArrayList<Hashtable<Integer, Integer>>();
        arr.add(null);
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        //1
        ht.put(2, 10);
        ht.put(3, 23);
        arr.add(ht);
        ht = new Hashtable<Integer, Integer>();
        //2
        ht.put(3, 7);
        ht.put(5, 36);
        arr.add(ht);
        ht = new Hashtable<Integer, Integer>();
        //3
        ht.put(4, 1);
        ht.put(5, 15);
        arr.add(ht);
        ht = new Hashtable<Integer, Integer>();
        //4
        ht.put(2, 3);
        ht.put(5, 4);
        arr.add(ht);
        //5
        ht = new Hashtable<Integer, Integer>();
        arr.add(ht);
        // for (Hashtable<Integer,Integer> hashtable : arr) {
        //     System.out.println(hashtable.keySet());            
        // }
        dijkstra(1);

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