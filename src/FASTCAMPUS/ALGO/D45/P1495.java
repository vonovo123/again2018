package FASTCAMPUS.ALGO.D45;
import java.io.*;
import java.util.*;

public class P1495 {
    static int N, S, M;
    static int [] A;
    static int [][] Dy;
    static int answer = -1;
    static void input() {
        FastReader scan = new FastReader();
        N  = scan.nextInt();
        S  = scan.nextInt();
        M  = scan.nextInt();
        A = new int [N + 1];
        Dy = new int [N + 1][M + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        if(S + A[1] <= M){
            Dy[1][S + A[1]] = 1;
        }
        if(S - A[1] >= 0){
            Dy[1][S - A[1]] = 1;
        }
        for(int i = 2; i <= N; i ++){
            boolean flag = false;
            int V = A[i];
            for(int prev = 0; prev <= M; prev ++){
                if(Dy[i - 1][prev] == 0) continue;
              if(prev + V <= M){
                 flag = true;
                 Dy[i][prev + V] = Dy[i - 1][prev];
                 answer = Math.max(answer, prev + V);
              }
              if(prev - V >= 0){
                flag = true;
                Dy[i][prev - V] = Dy[i - 1][prev];
                answer = Math.max(answer, prev - V);
              }
            }
            if(!flag) {
                System.out.println(-1);  
                return;
            }
        }
        for(int i = 1; i <= M; i ++){
            if(Dy[N][i] == 1){
                answer = i;
            }
        }
        System.out.println(answer);
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