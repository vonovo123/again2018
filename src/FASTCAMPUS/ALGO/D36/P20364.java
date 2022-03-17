package FASTCAMPUS.ALGO.D36;
import java.io.*;
import java.util.*;

public class P20364 {
    static int N, Q;
    static int [] duck;
    static boolean[] tree;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        Q = scan.nextInt();
        tree = new boolean [N + 1];
        duck = new int [Q];
        for(int i = 0; i < Q; i ++){
            duck[i] = scan.nextInt();
        }
        sb = new StringBuilder();
    }
    public static void pro(){
        for (int i : duck) { 
            int res = 0;
            int c = i;
            while(i > 0){
             if(tree[i]) res = i;
                i /= 2;
            }
            tree[c] = true;
            sb.append(res);
            sb.append("\n");
        }
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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