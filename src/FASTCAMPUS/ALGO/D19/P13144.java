package FASTCAMPUS.ALGO.D19;
import java.io.*;
import java.util.*;

public class P13144 {
    //길이가 N인 수열 A
    // 1 <= N <= 100000
    // 1 <= A[i] <= 100000
    // 1개 이상의 수를 뽑을때 같은 수가 등장하지않는 경우의 수 : answer
    // answer의 최대값 N + (N -1) + ... + 1 => N의 최대값은 100000 => 50억 (long)
    static int N;
    static int [] A;
    static boolean[] check;
    static long answer;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1];
        check = new boolean [100000 + 1];
        answer = 0L;
        for(int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }
    static void pro(){
        int R = 1;
        for(int L = 1; L <= N; L ++){
            while(R <= N && check[A[R]] == false){
                    check[A[R]] = true;
                    R ++;
            }
            check[A[L]] = false;
            answer += (R - 1) - L  + 1;
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