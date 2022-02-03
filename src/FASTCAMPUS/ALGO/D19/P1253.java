package FASTCAMPUS.ALGO.D19;
import java.io.*;
import java.util.*;

public class P1253 {

    static int N;
    static int [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    static boolean determenation(int idx){
        int obj = A[idx];
        int L = 1;
        int R = N;
        while(L < R){
            if(L == idx){
                L ++;
            }
            if(R == idx){
                R--;
            }
            if(A[L] + A[R] < obj){
                L ++;
            } else if(A[L] + A[R] > obj){
                R --;
            } else {
                return true;
            }
        }
        return false;
    }
    static void pro (){
        Arrays.sort(A);
        int count = 0;
        for(int i = 1; i <= N; i ++){
            if(determenation(i) == true){
                count ++;
            };
        }
        System.out.println(count);
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