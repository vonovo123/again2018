package FASTCAMPUS.ALGO.D29;
import java.io.*;
import java.util.*;

public class P1806 {
    static int N, S;
    static int [] A; 
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int [N];
        for( int i = 0; i < N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        int pF = 0;
        int pB = 0;
        int sum = A[pF];
        int minLength = 100000;
        while(true){
            if(sum < S){
                pB ++;
                if(N <= pB) break;
                sum += A[pB];
            } else {
                int length = (pB - pF) + 1;
                if( length < minLength){
                    minLength = length;
                    
                }
                sum -= A[pF];
                pF ++;
                if(pF > pB){
                    break;
                }
            }
        }
        System.out.println((minLength < 100000) ? minLength : 0);
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