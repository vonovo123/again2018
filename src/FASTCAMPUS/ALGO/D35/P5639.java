package FASTCAMPUS.ALGO.D35;
import java.io.*;
import java.util.*;

public class P5639 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> a;
    static Hashtable<Integer, ArrayList<Integer>> graph;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        a = new ArrayList<>();
        graph =  new Hashtable<Integer, ArrayList<Integer>>();
        while (!(input = br.readLine()).equals("")){
            a.add(Integer.parseInt(input));
            graph.put(Integer.parseInt(input), new ArrayList<Integer>());
        }
    }

    static void postOrder(int root){
         ArrayList<Integer> arr = graph.get(root);
        for (Integer child : arr) {
            postOrder(child);
        }
        sb.append(root).append("\n");
    }
    // 현재 Subtree가 a[l...r] 일 때, 후위 순회를 하는 함수.
    static void traverse(int l, int r) {
        int m = l;
        // subtree 기준점
        for(int i = l + 1; i <= r; i ++){
          if(a.get(i) < a.get(l)){
            m = i;
          }
        }
        
        if(l + 1 <= m){
          traverse(l + 1, m);
          graph.get(a.get(l)).add(a.get(l + 1));
        }
        if(m + 1 <= r){
          traverse(m + 1, r);
          graph.get(a.get(l)).add(a.get(m + 1));
        }
    }

    static void pro() {
        traverse(0, a.size() - 1);
        postOrder(a.get(0));
        System.out.println(sb);
        //System.out.println(graph);
        //System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
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