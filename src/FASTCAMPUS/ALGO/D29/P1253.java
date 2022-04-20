package FASTCAMPUS.ALGO.D29;
import java.io.*;
import java.util.*;

public class P1253 {
    //N개의 수 ( 1 <= N <= 2 * 10)
    //배열 A ( -10 ^ 9 <= A[i] <= 10 ^ 9)
    static int N;
    static ArrayList<Integer> A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new ArrayList<Integer> (N); 
        for(int i = 0; i < N; i ++){
            A.add(scan.nextInt());
        }
    }
    public static void pro(){
        Collections.sort(A);
        int result = 0;
        for(int idx = 0; idx < N; idx ++){
            int L = 0;
            int R = N - 1;
            while(L < R){
                if(L == idx) L ++;
                else if(R ==  idx) R--;
                else {
                    int sum = A.get(L) + A.get(R);
                    //System.out.printf("idx : %d L : %d R: %d sum : %d\n",idx,  L, R, sum);
                    if(A.get(idx) < sum){
                        R --;
                    } else if(A.get(idx) > sum){
                        L ++;
                    } else {
                        result += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
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