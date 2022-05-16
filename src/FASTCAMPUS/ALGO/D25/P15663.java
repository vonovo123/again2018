package FASTCAMPUS.ALGO.D25;
import java.io.*;
import java.util.*;

public class P15663 {
    static int N;
    static int M;
    static int A[];
    static ArrayList<String> arr;
    static ArrayList<Integer> in;
    static boolean [] visited;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N];
        arr = new ArrayList<String>();
        in = new ArrayList<Integer>();
        visited = new boolean [N];
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextInt();
        }
    }

    public static void dfs(){
        if(in.size() == M){
            StringBuilder sb = new StringBuilder();
            for (int i : in) {
                sb.append(i + " ");
            }

            System.out.println(
                sb
            );
            return;
        }
        int last_cand = 0;
        for(int i = 0; i < N ; i ++){
            if (A[i] == last_cand) continue;
            if(visited[i] == true) continue;
            visited[i] = true;
            in.add(A[i]);
            last_cand = A[i];
            dfs();
            in.remove(in.size() - 1);
            visited[i] = false;
        }
    }
    public static void pro(){
        ArrayList<Integer> in = new ArrayList<Integer>();
        Arrays.sort(A);
        dfs();
        // for (String answer : arr) {
        //     System.out.println(answer.trim());
        // }
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