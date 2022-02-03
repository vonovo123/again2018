package FASTCAMPUS.ALGO.D21;
import java.io.*;
import java.util.*;

public class P2178 {
    static int N, M;
    static String A[];
    static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    static int [][] dist;
    static boolean [][] visited;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String [N];
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextLine();;
        }
        dist = new int [N][M]; 
        visited = new boolean [N][M]; 
        
    }
    static void bfs(int y, int x){
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(y);
        queue.add(x);
        int ny = 0;
        int nx = 0;
        dist[0][0] = 1;
        visited[y][x] = true;
        while(!queue.isEmpty()){
            y = queue.poll();
            x = queue.poll();
            for(int i = 0; i < 4; i ++){
                ny = y + dir[i][0];
                nx = x + dir[i][1];
                if(ny >= 0 && nx >= 0 && ny < N && nx < M){
                    if(A[ny].charAt(nx) == '1' && !visited[ny][nx]){
                        queue.add(ny);
                        queue.add(nx);
                        dist[ny][nx] = dist[y][x] + 1;
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        System.out.printf("%d", dist[N-1][M-1]);
    }
    static void pro(){
        bfs(0,0);
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