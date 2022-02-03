package FASTCAMPUS.ALGO.D22;
import java.io.*;
import java.util.*;

public class P2252 {
    static int N;
    static int M;
    //
    static int [] indeg;
    //outdegree
    static ArrayList<Integer>[] outdeg;
    static StringBuilder  sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        sb = new StringBuilder();
        indeg = new int [N + 1];
        outdeg = new ArrayList[N + 1];
        for(int i = 1; i <= N; i ++){
            outdeg[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i ++){
            int vertexA = scan.nextInt();
            int vertexB = scan.nextInt();
            outdeg[vertexA].add(vertexB);
            indeg[vertexB] ++;
        }
    }
    public static void topologicalSort(){
        Queue <Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i <= N; i ++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }
        //System.out.println(queue);
        while(!queue.isEmpty()){
            int poll = queue.poll();
            sb.append(poll).append(" ");
            ArrayList<Integer> out = outdeg[poll];
            for (Integer y : out) {
                indeg[y] --;
                if(indeg[y] == 0){
                    queue.add(y);
                }
            }

        }
    }
    public static void pro(){
        for (ArrayList<Integer> arrayList : outdeg) {
            System.out.println(arrayList);
        }
        for (Integer v : indeg) {
            System.out.println(v);
        }

        topologicalSort();
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