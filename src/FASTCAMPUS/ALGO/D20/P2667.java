package FASTCAMPUS.ALGO.D20;
import java.io.*;
import java.util.*;

public class P2667 {
    static int N;
    static int [][] A;
    static int [][] visited;
    static int num;
    static int count;
    static StringBuilder sb;
    static int group_cnt;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1][N + 1];
        visited = new int[N + 1][N + 1];
        num = 0;
        for(int i = 1; i <= N; i ++){
            String[] input = scan.nextLine().split("");
            for(int j = 1; j <= N; j ++){
                A[i][j] = Integer.parseInt(input[j - 1]);
            }
        }
        sb = new StringBuilder();
    }
    public static void main(String[] args) {
        input();
        pro();
    }

    
    public static void pro(){
        ArrayList<Integer> group = new ArrayList<Integer>();
        for(int i = 1; i <= N; i ++){
            for(int j = 1; j <= N; j ++){
                if(A[i][j] == 0) continue;
                if(visited[i][j] != 0) continue;
                group_cnt = 0;
                dfs(i, j);
                group.add(group_cnt);
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for (Integer num : group) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
    static int [][] loc = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    static void dfs(int y, int x){
            group_cnt ++;
            visited[y][x] = 1;
            for(int i = 0; i < 4; i ++){
                int ny = y + loc[i][0];
                int nx = x + loc[i][1];
                if( ny >= 1 && ny <= N && nx >= 1 && nx <= N){
                    if(A[ny][nx] != 0){
                        if(visited[ny][nx] == 0){
                            dfs(ny, nx);
                        }
                    }
                    
                }
            }
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