package FASTCAMPUS.ALGO.D30;
import java.io.*;
import java.util.*;

public class P15565 {
    static int N; // 일렬로 놓인 인형 N개 라이언 1, 어피치 2
    static int K; // 연속 라이언 인형의 최소 수 
    //1 <= K <= N <= 10^6
    static int [] A; //인형 배열
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        int R = 1;
        int Ryon = 0;
        int min = 1000000;
        for(int L = 1; L <= N; L ++){
            if(A[L - 1] == 1){
                Ryon --;
            }
            while(R <= N && Ryon < K){
                if(A[R] == 1) Ryon ++;
                R ++;
            }
            if(Ryon >= K){
                min = Math.min(min, R - L);
                //System.out.printf("L : %d R : %d length: %d Ryon: %d\n", L, R , R - L, Ryon);
            }
        }
        System.out.println((min == 1000000)? -1 : min);
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