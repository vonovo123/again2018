package FASTCAMPUS.ALGO.D37;
import java.io.*;
import java.util.*;

public class P15681 {
    static int N, R, Q;
    static ArrayList<ArrayList<Integer>> tree;
    static int [] parent;
    static int [] Dy;
    static int [] U;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        sb = new StringBuilder();
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        tree = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i ++){
            tree.add(new ArrayList<Integer>());
        }
        parent = new int [N + 1];
        Dy = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            Dy[i] = 1;
        }
        U = new int [Q];
        for(int i = 0; i < N - 1; i ++){
            int U = scan.nextInt();
            int V = scan.nextInt();
            tree.get(U).add(V);
            tree.get(V).add(U);
        }
        //System.out.println(tree);
        for(int i = 0; i < Q; i ++){
            U[i] = scan.nextInt();
        }
    }
    public static int findParent(int vertex){
        for (int child : tree.get(vertex)) {
            if(child == parent[vertex]) continue;
            parent[child] = vertex;
            Dy[vertex] += findParent(child);
        }
        return Dy[vertex];
    }
    public static void pro(){
        findParent(R);
        
        System.out.println();
        for (int i : U) {
            sb.append(Dy[i]);
            sb.append("\n");
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