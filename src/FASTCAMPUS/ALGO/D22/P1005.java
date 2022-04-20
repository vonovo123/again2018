package FASTCAMPUS.ALGO.D22;
import java.io.*;
import java.util.*;

public class P1005 {
    // 8 8
    // 10 20 1 5 8 7 1 43
    // 1 2
    // 1 3
    // 2 4
    // 2 5
    // 3 6
    // 5 7
    // 6 7
    // 7 8
    // 7

    // 건물수, 명령수
    static int N, K, W, answer;
    // 건물별  필요시간
    static int [] D;
    // 들어오는 노드 나가는 노드
    static int [] in;
    static ArrayList<Integer>[] out;
    static FastReader scan;
    static StringBuilder sb;
    static int [] Done;
    //승리건물
    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        D = new int [N + 1];
        in = new int[N + 1];
        out = new ArrayList[N + 1];
        Done = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            D[i] = scan.nextInt();
            out[i] = new ArrayList<Integer>();
        }        
        for(int i = 0; i < K; i ++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            in[to] ++;
            out[from].add(to);
        }
        W = scan.nextInt();
        answer = 0;
    }
    public static void topologicalSort(){
        Deque<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i <= N; i ++){
            if(in[i] == 0){
                queue.add(i);
                Done[i] = D[i];
            }
        }
        while(!queue.isEmpty()){
            int poll = queue.poll();
            ArrayList<Integer> outDeg = out[poll];
            for (Integer y : outDeg) {
                in[y] --;
                if(in[y] == 0){
                    queue.add(y);
                }
                Done[y] = Math.max(Done[y], Done[poll] + D[y]);
            } 
        }

    }
    public static void pro(){
        topologicalSort();
    }
    public static void main(String[] args) {
        scan = new FastReader();
        sb = new StringBuilder();
        int T = scan.nextInt();
        for(int i = 0; i < T; i  ++){
            input();
            pro();
            sb.append(Done[W]).append("\n");
        }
        System.out.println(sb);
        // for (int count : in) {
        //     System.out.println( count);
        // }
        //System.out.println();
        // for (ArrayList arr : out){
        //     System.out.println(arr);
        // }
        // for (int count : in) {
        //     System.out.println( count);
        // }
        // System.out.println();
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