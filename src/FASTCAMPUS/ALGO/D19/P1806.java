package FASTCAMPUS.ALGO.D19;
import java.io.*;
import java.util.*;

public class P1806 {
  
    // 제한시간 0.5초
    // 자연수 N개로 이루어진 수열
    // 합이 S 이상 되는 부분합중 길이가 가장 짧은것
    // 10 <= N의 길이 <= 100000
    // 0 <= S <= 100000000
    // 1 <= A[i] <= 10000
    // 수열의 연속된 수들의 부분합의 최대 값 100000 * 10000 10억 Integer
    //정답 answer 최대길이 N Integer
    
    
    //시간 복잡도
    static int N, S, answer;
    static int [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    public static void pro(){
        answer = N + 1;
        int sum = 0;
        int L = 0, R = 0;
        for(int i = 1; i <= N; i ++){
            L = i;
            sum -= A[i - 1];
            while(R < N && sum < S ){
                R ++;
                sum += A[R];
            }
            if(sum >= S){
                answer = Math.min(answer, R - L + 1);
            }
        }
        if(answer == N + 1){
            answer = 0;
        }
        System.out.println(answer);
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