package FASTCAMPUS.ALGO.D31;
import java.io.*;
import java.util.*;

public class P3273 {
    static int n,x;
    static int [] a;
    //1 <= n <= 10^5
    //1 <= x <= 2*10^6
    //a[i] + a[j] == x를 만족하는 쌍을 구하라
    //(1 <= i < j <= n)
    static void input() {
        FastReader scan = new FastReader();
        n = scan.nextInt();
        a = new int [n + 1];
        for(int i = 1; i <= n; i ++){
            a[i] = scan.nextInt();
        }
        x = scan.nextInt();
    }
    public static void pro(){
        Arrays.sort(a, 1, n + 1);
        int R = n;
        int count = 0;
        for(int L = 1; L <= n; L ++){
            while(R > L && a[L] + a[R] > x){
                R --;
            }
            if( L != R  && a[L] + a[R] == x){
                count ++;
            }
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