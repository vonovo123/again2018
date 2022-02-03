package FASTCAMPUS.ALGO.D18;
import java.io.*;
import java.util.*;

public class P2110 {
    // N개의 집
    // 좌표 X[]
    // 집끼리 같은 좌표는 없다
    // C개의 공유기를 설치한다.
    // 인접한 두 공유기 사이의 거리를 가능한 크게하여 설치한다.
    // 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
    //  2<= N <= 200000
    //  2<= C <= N
    //  0 <= X[i] <= 1000000000
    // 최대 거리 result 는 1000000000 Intger 범위
    static int N, C;
    static int X[]; 
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        C = scan.nextInt();
        X = new int [N + 1];
        for(int i = 1; i <= N; i ++){
            X[i] = scan.nextInt();
        }
    }
    //width : 두 공유기 사이에 보장되야하는 최소거리
    static boolean determination(int width){
        int start = 1;
        int count = 1;
        for(int i = 2; i <= N; i ++){
            if(X[start] + width <= X[i]){
                start = i;
                count ++;
            } 
        }
        if(count >= C){
            return true;
        }
        return false;
    }

    static void pro(){
        int L = 1, R = 1000000000;
        Arrays.sort(X, 1, N + 1);
        int answer = 0;
        while(L <= R){
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