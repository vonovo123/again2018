package FASTCAMPUS.ALGO.D29;
import java.io.*;
import java.util.*;

public class P13144 {
    // 수열의 길이 1<= N <= 10^5
    // 연속한 1개 이상의 수를 뽑았을때 수가 여러번 등장하지 않는 경우의 수
    // 수열  A
    // 1 <= A[i] <= 10^5
    // 시간제한 1 => under N^2
    static int N;
    static int A[];
    static int cnt[];
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N];
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextInt();
        }
        cnt = new int [100001];
    }
    
    public static void pro(){
        long sum = 0;
        int R = -1;
        for(int L = 0; L < N; L ++){
            while(R + 1 < N && cnt[A[R + 1]] == 0){
                R ++;
                cnt[A[R]] ++;
            }
            sum += (R - L + 1);
            //System.out.println(R - L + 1);    
            cnt[A[L]]--;
        }
        System.out.println(sum);
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