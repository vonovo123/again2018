package FASTCAMPUS.ALGO.D32;
import java.io.*;
import java.util.*;

public class P2667 {
    static int N;//정사각형 지도의 한변의 길이
    static int [][] A; //지도 1은집이있는곳 0은 집이없는곳 
    static int [][] visited;
    //상하좌우
    static int [][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    //연결된 집에 같은 번호를 붙인다. 
    // 단지에 속하는 집의 수를 오름 차순으로 정렬
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1][N + 1];
        visited = new int [N + 1][N + 1];
        for(int i = 1; i <= N; i ++){
            String [] tmp = scan.next().split("");
            for(int j = 1; j <= N; j ++){
                A[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }
    }
    static int dfs(int y, int x, int num, int count){
        visited[y][x] = num;
        count ++;
        for(int i = 0; i < 4; i ++){
            int dY = y +dir[i][0];
            int dX = x + dir[i][1];
            if(dY < 1)continue;
            if(dY > N)continue;
            if(dX < 1) continue;
            if(dX > N) continue;
            if(visited[dY][dX] != 0) continue;
            if(A[dY][dX] != 1) continue;
            //System.out.printf("dY : %d dX : %d\n", dY, dX);
            count = dfs(dY, dX, num, count);
        }
        return count;
    }
    public static void pro(){
        int num = 1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i <= N; i ++){
            for(int j = 1; j <= N; j ++){
                if(A[i][j] == 0) continue;
                if(visited[i][j] != 0) continue;
                int count = dfs(i, j, num ++, 0);
                arr.add(count);
            }
        }
        System.out.println(arr.size());
        Collections.sort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
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