package FASTCAMPUS.ALGO.D16;
import java.io.*;
import java.util.*;

public class P11652 {
    static int N;
    static long [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new long[N];
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextLong();
        }
    }
    //-2^62 에서 2^62사이의 수가 쓰여있는 숫자카드 N 장이 있다.
    //int의 범위는 -2^62 에서 2^62
    //카드의 개수 N의 범위는 1~ 100000사이이다
    //정렬시 100000 * log 100000
    //Math.log10(100000)/Math.log10(2) : 16.xxx;
    //시간복잡도 1초에 160만
    //currentCount
    //modeCount
    //mode
    /// BOJ 20291 비슷
    public static void main(String[] args) {
        input();
        solve();
    }
    public static void solve(){
        Arrays.sort(A);
        int currentCount = 1, modeCount = 1;
        long mode = A[0];
        for(int i = 1; i < N; i ++){
            if(A[i - 1] != A[i]) {
                currentCount = 1;
            } else {
                currentCount ++;
                if(modeCount < currentCount){
                    modeCount = currentCount;
                    mode = A[i];
                }
            }
        }
        System.out.println(mode);
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