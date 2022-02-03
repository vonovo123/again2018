package FASTCAMPUS.ALGO.D18;

import java.io.*;
import java.util.*;

public class P2805 {
    //나무가 M 미터만큼 필요하다.
    // 나무 한줄에 대한 벌목
    // 절단기 높이 H를 지정한다.
    // 한줄을 모두 절단한다.
    // 높이가 H보다 큰 나무는 H 윗부분이 잘린다.
    // 잘린부분을 가지는데 M만큼이 필요하다.
    // 적어도 M만큼을 가져가기 위해 설정해야하는 H 높이의 최댓값

    // H는 0 또는 양의 정수이다.
    // 나무의 수 1 <= N <= 1000000 
    // 가져가야하는 나무의 길이 M 1 <= M <= 2000000000 Integer 범위
    // 각 나무의 높이 0 < A[i]< 1000000000 각각의 높이는 Integer 범위지만
    // 합의 최댓값은 10만개의 나무의 높이가 10억인경우 10만 * 10억 => 10^15
    // 가져가는 나무의 총합의 타입은 long이 되야함
    // 10 15 17 20

    static int N, M;
    static int[] A;
    static long sum;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i ++){
            A[i] = scan.nextInt();
        }
    }
    static boolean determination(int H){
        sum = 0L;
        for(int i = 1; i <= N; i ++){
            if(A[i] - H > 0){
                sum += A[i] - H;
            }
        }
        return sum >= M;
    }

    static void pro(){
        int L = 0, R = 1000000000;
        int answer = 0;
        while(L <= R) {
            int mid = (L + R) / 2;    
            if(determination(mid)){
                L = mid + 1;
                answer = mid;
            } else {
                R = mid - 1;
            }
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