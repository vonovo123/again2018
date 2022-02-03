package FASTCAMPUS.ALGO.D22;
import java.io.*;
import java.util.*;

public class P11725 {
    //노드의 개수 N
    // 2 <= N <= 100000
    static int N;
    static ArrayList<ArrayList<Integer>> A;
    static StringBuilder sb;
    public static int [] parent;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new ArrayList<ArrayList<Integer>>();
        A.add(null);
        for(int i = 0 ; i < N; i ++){
            A.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < N - 1; i ++){
            int vertexA = scan.nextInt();
            int vertexB = scan.nextInt();
            A.get(vertexA).add(vertexB);
            A.get(vertexB).add(vertexA);
        }
        System.out.println(A);
        sb = new StringBuilder();
        parent = new int [N + 1];
    }
    
    public static void find(){
        Queue<Integer> queue = new LinkedList<Integer>();
        int root = 1;
        queue.add(root);
        parent[root] = root;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            ArrayList <Integer> candidate = A.get(poll);
            for(int i = 0; i < candidate.size(); i ++){
                if(parent[candidate.get(i)] == 0){
                    parent[candidate.get(i)] = poll;
                    queue.add(candidate.get(i));
                }
                
            }
        }
    }
    public static void pro(){
        find();
        for(int i = 2; i < parent.length; i ++){
            System.out.println(parent[i]);
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