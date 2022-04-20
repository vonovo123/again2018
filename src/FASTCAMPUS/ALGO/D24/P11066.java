package FASTCAMPUS.ALGO.D24;
import java.io.*;
import java.util.*;

public class P11066 {
    static int N;
    static int[] A;
    static int Dy[][];
    static int Sum [][];
    static FastReader scan;
    static StringBuilder sb;
    static void input() {
        N = scan.nextInt();
        A = new int [N + 1];
        Dy = new int [N + 1][N + 1];
        Sum = new int [N + 1][N + 1];
        for(int i = 1; i <= N ; i ++ ){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        for(int i = 1; i <= N; i ++){
            for(int j = i; j <= N; j ++){
                if(i == j){
                    Sum[i][j] = A[i];
                } else {
                    Sum[i][j] = Sum[i][j - 1] + A[j];
                }
            }
        }


        for(int i = N; i >= 1; i --){
            for(int j = i; j <= N; j ++){
                if(i == j){
                    Dy[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k < j; k ++){
                       // System.out.printf(" i : %d , j : %d , k : %d\n", i, j, k);
                        if(min > Dy[i][k] + Dy[k + 1][j] + Sum[i][j]){
                            min = Dy[i][k] + Dy[k + 1][j] + Sum[i][j];
                        }
                    }
                    Dy[i][j] = min;
                }
                
            }
        }


        // for(int i = 1; i <= N; i ++){
        //     for(int j = 1; j <= N; j ++){
        //         System.out.printf( "%d ", Dy[i][j]);
        //     }
        //     System.out.println();
        // }
        //System.out.printf( "%d ", Dy[1][N]);
        sb.append(Dy[1][N]).append("\n");
    }
    public static void main(String[] args) {
        scan = new FastReader();
        int T = scan.nextInt();
        sb = new StringBuilder();
        for(int i = 0; i < T; i ++){
            input();
            pro();
        }
        System.out.print(sb);
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