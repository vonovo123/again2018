package FASTCAMPUS.ALGO.D20;
import java.io.*;
import java.util.*;

public class P14502 {
    static int N, M ;
    static int [][] A;
    static ArrayList<int[]> virus;
    static int Max;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i ++){
            for(int j = 1; j <= M; j ++){
                A[i][j] = scan.nextInt();
            }
        }
    }

    
    //상, 하, 좌, 우
    static int[][] dir = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
    public static void bfs(){
        ArrayList<int[]> queue = new ArrayList<int[]>();
        //System.out.println( Arrays.asList(virus));
        queue.addAll(virus);
        boolean [][] visited = new boolean [N + 1][M + 1];
        while(queue.size() > 0){
            int [] pop = queue.remove(0);
            visited[pop[0]][pop[1]] = true;
            for(int i = 0; i < 4; i ++){
                int nY = pop[0] + dir[i][0];
                int nX = pop[1] + dir[i][1];
                if(nY >= 1 && nY <= N && nX >= 1 && nX <= M){
                    if(visited[nY][nX] == false && A[nY][nX] != 1){
                        int [] next = {nY, nX};
                        queue.add(next);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 1; i <= N; i ++){
            for(int j = 1; j <= M; j ++){
                if(A[i][j] == 0 && visited[i][j] == false){
                    count ++;
                }
            }
        }
        //  if(A[2][1] == 1 && A[1][2] == 1 && A[4][6] == 1){
        //     for(int i = 1; i <= N; i ++){
        //         for(int j = 1; j <= M; j ++){
        //             System.out.printf("%d ", A[i][j]);
        //         }
        //         System.out.println();
        //     }
        //         System.out.println();
    
        //     for(int i = 1; i <= N; i ++){
        //         for(int j = 1; j <= M; j ++){
        //             if(A[i][j] == 0 && visited[i][j] == false){
        //                 count ++;
        //             }
        //             System.out.printf("%b ", visited[i][j]);
        //         }
        //         System.out.println();
        //     }
        // }
        Max = Math.max(Max, count);
    }
    static int c;
    static int [][] visit;
    public static void dfs(int dep){
        if(dep == 4){
            c ++;
            //bfs();
            return;
        }
        for(int i = 1; i <= N; i ++){
            for(int j = 1; j <= M; j ++){
                if( visit[i][j] == 0 ){
                    visit[i][j] = 1;
                    if(A[i][j] == 0){
                        visit[i][j] = 1;
                        A[i][j] = 1;
                        dfs(dep + 1);
                        A[i][j] = 0;
                    }
                    visit[i][j] = 0;
                }
            }
        }
    }
    static void pro(){
        virus = new ArrayList<int[]>();
        c =0;
        visit = new int [N + 1][M + 1];
        for(int i = 1; i <= N; i ++){
            for(int j = 1; j <= M; j ++){
                if(A[i][j] == 2){
                    //virus({i,j});
                    int[] v = {i,j};
                    virus.add(v);
                }
            }
        }
        dfs(1);
        System.out.println(c);
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