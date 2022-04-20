package FASTCAMPUS.ALGO.D29;
import java.io.*;
import java.util.*;

public class P2470 {
    //특성값의 범위 -10^9 <= A[i] <= 10^9
    // 특성값을 가진 주어진 용액중 두개를 섞어 0에 가장 가까운 용액을 만드려고 한다.
    // 특성값이 0에 가장 가까운 용액을 만드는 두용액을 구하라
    // 전체 용액의 수 2 <=  N  <= 10^5
    // 전체 용액 A[]
    // A[i]의 특성값은 모두 다르고 산성용액이나 알카리용액만 주어질수도 있다.
    // 최대 시간복잡도
    // N = 100000
    // 완전탐색의 경우 N * (N(N-1)/2) 대략 5억 x
    // 정렬 후 투포인터?
    // 정렬 100000 * log2 100000 160만
    // +
    // 
    //예시
    //-99 -2 -1 4 98
    //-99       4    -95
    //       -1  4
    static int N;
    static Integer [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new Integer [N];
        
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static void pro(){
        
        Arrays.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              return o1 - o2;
            }
        });
        // for (Integer i : A) {
        //     System.out.printf("%d ", i);
        // }
        // System.out.println();
        int min = Integer.MAX_VALUE;
        int L = 0,  R = N - 1 ,pA = 0, pB = 0;

        while(L < R){
            int sum = Math.abs(A[L] + A[R]);
            if(sum < min){
                min = sum;
                pA = L;
                pB = R;
            };
            if(A[L] + A[R] > 0){
                R --;
            } else {
                L ++;
            }
        }
        System.out.println(A[pA] + " " + A[pB]);
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