package FASTCAMPUS.ALGO.D29;
import java.io.*;
import java.util.*;

public class P16472 {
    // 인식할 수 있는 알파벳 종류의 최대 개수 N ( 1 <=  N <= 26)
    // 문자열 S ( 1 <= S <= 100000)
    // 최대길이 100000 길이로 이분탐색하는 경우 시간복잡도 log2 10 ^ 5 = 17
    // 매 탐색마다 100000 * 17 ^ 2 = 30000000
    static int N;
    static char[] s;
    static int length;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        s = scan.next().toCharArray();
    }
    public static void pro(){ 
        int L = 0;
        int R = 0;
        int max = 0;
        int sum = 0;
        int [] count = new int [26];
        for(R = 0; R < s.length; R ++){
            int c = s[R] - 'a';
            count[c] += 1;
            if(count[c] == 1){
                sum += 1;
            }
            while(sum > N){
                count[s[L] - 'a'] -= 1;
                if(count[s[L] - 'a'] == 0) sum -= 1;
                L ++;
            }
            max = Math.max(max, R - L + 1);
        };
        System.out.println(max);
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