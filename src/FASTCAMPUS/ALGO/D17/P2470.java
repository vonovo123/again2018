package FASTCAMPUS.ALGO.D17;
import java.io.*;
import java.util.*;

public class P2470 {
    //시간제한 1초
    //메모리 128MB
    //산성용액의 특성값 A 1 <= A <= 1000000000 Integer 범위
    //산성용액의 특성값 B -1000000000 <= A <= -1 Integer 범위
    //혼합용액의 특성값은 혼합한 두 용액 특성값의 합
    //주어진 용액들의 특성값 A[N]
    
    //A중 두 용액을 골라 혼합용액을 만들때 0에 가장 가깝게 만들 수 있는 두 용액을 구하는 프로그램
    // 전체용액의 수는 2 <= N < 100,000
    static int N;
    //혼합용액 특성값의 최대값 20억 최소값 -20억 Integer 범위
    static int A[];
    //완전탐색할때 계산 수 100000 ^ 2
    //이진탐색할때  100000 * log 100000 
    //현재용액 + 1 위치부터 끝번째 용액중
    //반대용액(현재 용액 * -1)보다 큰 용액 중 가장 왼쪽에 있는 용액
    //가장 왼쪽에 있는 용액 -1 번째 용액
    // 
    /**
     * 
     * 5
     *  비정렬 -2 4 -99 -1 98
     *  정렬 -99 -2 -1 4 98
     *  -99의 반대용액 99
     *  -2 -1 4 98 에서 99 보다 큰 용액중 가장 왼쪽에 있는 용액(없으면 6번)
     *  가장 왼쪽에 있는 용액 -1 번째 용액 5번째
     * 
     */
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
        sb= new StringBuilder();
    }
   
    //x보다 큰 값중 가장 왼쪽에 있는 값
    static int binarySearch(int L, int R, int X){
        //System.out.println("left : " + L +" right : " + R + " X: " + X);
        int result = R + 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if( X <= A[mid] ) {
                R = mid - 1;
                result = mid;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }
    static void solve (){
        Arrays.sort(A, 1, N + 1);
        int A1 = 0;
        int A2 = 0;
        int min = Integer.MAX_VALUE;
        for(int left = 1; left < N; left ++){
            int result = binarySearch(left + 1, N, -A[left]);
            if(left < result -1){
                if(Math.abs(A[left] + A[result - 1]) < min){
                    A1 = A[left];
                    A2 = A[result - 1];
                    min = Math.abs(A[left] + A[result - 1]);
                }
            }
            if(result <= N){
                if(Math.abs(A[left] + A[result]) < min){
                    A1 = A[left];
                    A2 = A[result];
                    min = Math.abs(A[left] + A[result]);
                }
            }

        }
        sb.append(A1).append(" ").append(A2);
        System.out.println(sb);
       
    }
    public static void main(String[] args) {
        input();
        solve();
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