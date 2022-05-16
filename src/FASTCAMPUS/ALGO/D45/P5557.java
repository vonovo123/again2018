package FASTCAMPUS.ALGO.D45;
import java.io.*;
import java.util.*;

public class P5557 {
    static int N;
    static int [] A;
    static long [][] Dy;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1];
        Dy = new long [N + 1][21];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        Dy[1][A[1]] = 1;
        for(int i = 2; i <= N - 1; i ++){
            for(int j = 0; j <=20; j ++){
                if(j + A[i] <= 20){
                    Dy[i][j + A[i]] += Dy[i - 1][j];
                }
                if(j - A[i] >= 0){
                    Dy[i][j - A[i]] += Dy[i - 1][j];
                }
            }
        }
        System.out.println(Dy[N - 1][A[N]]);
        
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