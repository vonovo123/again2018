package FASTCAMPUS.ALGO.D21;
import java.io.*;
import java.util.*;

public class P1697 {
    static int N, K, answer;
    static int [] dist;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int [100000 + 1];
    }
    public static void bfs(int N){
        for(int i = 0; i < dist.length; i ++){
            dist[i] = -1;
        }
        dist[N] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(N);
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            int nN = 0;
            for(int i = 0; i < 3; i ++){
                if(i == 0){
                    nN = poll -1;
                } else if( i == 1){
                    nN = poll  + 1;
                } else {
                    nN = 2 * poll;
                }
                if(nN >= 0 && nN <= 100000){
                    if(dist[nN] == -1){
                        dist[nN] = dist[poll] + 1;
                        queue.add(nN);
                    }
                }
            }
        }
        System.out.println(dist[K]);

    }
    public static void pro(){
        bfs(N);
        //System.out.println(answer);
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