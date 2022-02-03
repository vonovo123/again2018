package FASTCAMPUS.ALGO.D21;
import java.io.*;
import java.util.*;

public class P3055 {
    static int N, M, hY, hX, dY, dX;
    static ArrayList<Integer> water;
    static String [] A;
    static int [][] waterDist, hogDist;
    static int [][] dir = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String [N];
        water = new ArrayList<Integer>();
        waterDist = new int [N][M];
        hogDist = new int [N][M];
        for(int i = 0; i < N; i ++){
            A[i]= scan.nextLine();
        }
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < M; j ++){
                waterDist[i][j] = -1;
                hogDist[i][j] = -1;
                if(A[i].charAt(j) == '*'){
                    water.add(i);
                    water.add(j);
                } else if(A[i].charAt(j) == 'S'){
                    hY = i;
                    hX = j;
                } else if(A[i].charAt(j) == 'D'){
                    dY = i;
                    dX = j;
                }
            }
        }
        // System.out.println(water);
        // System.out.printf("hY : %d hX : %d\n", hY, hX);
    }
    public static void bfsHog(int Y, int X){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Y);
        queue.add(X);
        hogDist[Y][X] = 0;
        int pollY = 0;
        int pollX = 0;
        while(!queue.isEmpty()){
            pollY = queue.poll();
            pollX = queue.poll();
            int nY = 0;
            int nX = 0;
            for(int i = 0; i < 4; i ++){
                nY = pollY + dir[i][0];
                nX = pollX + dir[i][1];
                if(nY < 0 || nX < 0 || nY >= N || nX >= M) continue;
                if(A[nY].charAt(nX) != 'D' && A[nY].charAt(nX) != '.') continue;
                if( waterDist[nY][nX] != - 1 && waterDist[nY][nX] <= hogDist[pollY][pollX] + 1) continue;
                if(hogDist[nY][nX] != -1) continue;
                hogDist[nY][nX] = hogDist[pollY][pollX] + 1;
                queue.add(nY);
                queue.add(nX);
            }
        }
    }
    public static void bfsWater(ArrayList<Integer>water){
        Queue<Integer> queue = new LinkedList<Integer>();

        while( water.size() > 0 ){
            int Y = water.remove(0);
            int X = water.remove(0);
            queue.add(Y);
            queue.add(X);
            waterDist[Y][X] = 0;
        }
        int pollY = 0;
        int pollX = 0;
        while(!queue.isEmpty()){
            pollY = queue.poll();
            pollX = queue.poll();
            int nY = 0;
            int nX = 0;
            for(int i = 0; i < 4; i ++){
                nY = pollY + dir[i][0];
                nX = pollX + dir[i][1];
                if(nY < 0 || nX < 0 || nY >= N || nX >= M) continue;
                if(A[nY].charAt(nX) != '.') continue;
                if(waterDist[nY][nX] != - 1) continue;
                waterDist[nY][nX] = waterDist[pollY][pollX] + 1;
                queue.add(nY);
                queue.add(nX);
            }
        }
    }
    public static void pro(){
        bfsWater(water);
        // for(int i = 0; i < N; i ++){
        //     for(int j = 0; j < M; j ++){
        //         System.out.printf("%d ", waterDist[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        bfsHog(hY, hX);
        // for(int i = 0; i < N; i ++){
        //     for(int j = 0; j < M; j ++){
        //         System.out.printf("%d ", hogDist[i][j]);
        //     }
        //     System.out.println();
        // }
        if(hogDist[dY][dX] == -1){
            System.out.println("KAKTUS");
        } else {
            System.out.println(hogDist[dY][dX]);
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