package FASTCAMPUS.ALGO.D22;
import java.io.*;
import java.util.*;

public class P1068 {
    // 노드의 개수 N
    // 0 < N <= 50
    // 인접리스트일때 dfs 시간복잡도 O(50)
    static int N, D;
    static ArrayList<Integer>[] A;
    static int [] leaf;
    static int root;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new ArrayList[N];
        for(int i = 0; i < N; i ++) A[i] = new ArrayList<Integer>();
        leaf = new int [N];
        for(int i = 0; i < N; i ++){
            int parent = scan.nextInt();
            if(parent != -1){
                A[parent].add(i);
            } else{
                root = i;
            }
        }
        D = scan.nextInt();
    }
    public static void delete(int D){
        for (ArrayList<Integer> child : A) {
            if(child.contains(D)){
                child.remove(child.indexOf(D));
            }
        }
    }
    public static void dfs( int x ) {
        //스스로를 포함한 단말노드의 수
        if(A[x].isEmpty()) {
            leaf[x] ++;
        }
        for (int vertex : A[x]) { 
            dfs(vertex);
            leaf[x] += leaf[vertex];
        }
    }
    public static void pro(){
        if(root != D){
            delete(D);
            dfs(0);
        }
        //for (int val : leaf) {
            System.out.println(leaf[root]);
        //}
        
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