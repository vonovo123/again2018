package FASTCAMPUS.ALGO.D17;
import java.io.*;
import java.util.*;

public class P7795 {
    //A는 B를 먹는다.
    //A는 B중 자기보다 작은 것만 먹는다
    //A가 B를 먹을 수 있는 쌍을 구하시오.
    //A의수 N B의 수 M
    // 1 ≤ N, M ≤ 20,000
    // A와 B의 크기는 양의 정수
    //정렬해서 일일이 비교할때
    //20000 * log 20000 + 20000 * 20000
    //정렬 후 이진탐색으로 찾는경우  20000 * log 20000;
    static int N, M;
    static int [] A, B;
    static FastReader scan;
    static void input() {
            N = scan.nextInt();
            M = scan.nextInt();
            A = new int [N + 1];
            B = new int [M + 1];
            for(int i = 1; i <= N; i ++){
                A[i] = scan.nextInt();
            }
            for(int i = 1; i <= M; i ++){
                B[i] = scan.nextInt();
            }
    }
    public static void main(String[] args) {
        scan = new FastReader();
        int T = scan.nextInt();
        for(int t = 0; t < T; t ++){
            input();
            solve();
        }
    }
    //X 찾고자 하는 값
    //X보다 작은 수 중 가장 오른쪽 인덱스 리턴하는 함수 
    public static int binarySearch(int L, int R, int X){
        //1 3 6
        // 1 3
        int result = L - 1;
        while(L <= R){
            // 2
            int mid = (L + R) / 2;
            
            if(B[mid] < X){
                //2
                result = mid;
                //3
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }
    public static void solve(){
        Arrays.sort(B);
        int sum = 0;
        //1 3 6
        for(int i = 1; i <= N; i ++){
            sum += binarySearch(1, M, A[i]);
        }
        System.out.println("sum: " + sum);
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