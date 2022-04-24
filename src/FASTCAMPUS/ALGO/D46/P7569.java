package FASTCAMPUS.ALGO.D46;
import java.io.*;
import java.util.*;

public class P7569 {
    static int M,N,H;
    static int [][][] table;
    static int [][][] visited;
    static int [][] dirTable = {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
    static void input() {
        FastReader scan = new FastReader();
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        table = new int [H][N][M];
        visited = new int [H][N][M];
        for(int h = 0; h < H; h ++){
            for(int n = 0; n < N ; n ++){
                for(int m = 0; m < M; m ++){
                    table[h][n][m] = scan.nextInt();
                    if(table[h][n][m] == -1){
                        visited[h][n][m] = -2;    
                    } else {
                        visited[h][n][m] = -1;
                    }
                    
                }
            }
        }
    }
    public static void bfs(int h, int n, int m, int d){
        //let Q = [[h,n,m,d]];
        LinkedList <int[]> Q = new LinkedList<int[]>();
        Q.add(new int[]{h,n,m,d});
        while(!Q.isEmpty()){
          int [] pop  = Q.poll();
          for(int i = 0; i < dirTable.length; i ++){
              int[] dir = dirTable[i];
              int nh = pop[0] + dir[0];
              int nn = pop[1] + dir[1];
              int nm = pop[2] + dir[2];
              int nd = pop[3] + 1; 
              if(nh < 0 || nh >= H) continue;
              if(nn < 0 || nn >= N) continue;
              if(nm < 0 || nm >= M) continue;
              //빈칸
              if(visited[nh][nn][nm] == -2) continue;
              if(visited[nh][nn][nm] == -1) {
                visited[nh][nn][nm] = nd;
                Q.add(new int[]{nh, nn, nm, nd});
              } else {
                if(visited[nh][nn][nm] > nd){
                    visited[nh][nn][nm] = nd;
                    Q.add(new int[]{nh, nn, nm, nd});
                }
              }
              
          }
        }        
      }
    public static void pro(){
        for(int h = 0; h < H; h ++){
            for(int n = 0; n < N; n ++){
              for(int m = 0; m < M; m ++){
                if(table[h][n][m] == 1){
                  visited[h][n][m] = 0;
                  bfs(h,n,m,0);
                }
              }
            }
          }
        int max = 0;
        for(int h = 0; h < H; h ++){
            for(int n = 0; n < N; n ++ ){
                for(int m = 0; m < M; m ++){
                    if(visited[h][n][m] == -1){
                    System.out.println(-1);
                    return;
                    }
                    max = Math.max(max , visited[h][n][m]);
                }
            }
        }
        System.out.println(max);
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