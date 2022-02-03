package FASTCAMPUS.ALGO.D16;
import java.io.*;
import java.util.*;

public class P1015 {
    static int N;
    static Elem[] B;
    static int [] P;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        sb = new StringBuilder();
        N = scan.nextInt();
        B = new Elem[N];
        P = new int[N];
        for(int i = 0; i < N ; i ++){
            B[i] = new Elem(i, scan.nextInt());
        }
        Arrays.sort(B);
        for (Elem elem : B) {
            System.out.println("idx : " + elem.idx + " num : " + elem.num);
        }
    }
    // P[] : 0 부터 n-1까지의 수를 한번씩 포함하고 있는 배열 길이 N
    // A[] : 길이가 N인 배열
    // B[] : 길이가 N인 배열
    // P에 A를 적용하면 B 가 된다.
    // B[p[i]] = A[i];
    // P에는 바뀔 인덱스가 들어있다.
    // A가 주어질때 A에 P를 적용한 결과인 B가 비내림차순인 수열 P를 찾는 프로그램
    // A[i]가 B[]의 몇번째 위치에 가야하는지 P[i]에 담고있어야함.
    // N < 50
    // 정렬시 시간 복잡도 50log50 350
    // 1 -> 0
    // 3 => 1
    // 6 => 2
    // 4 => 3
    // 0 => 4
    // 7 => 5
    // 2 => 6
    // 5 => 7
    static void solve(){
        for(int i = 0; i < N; i ++){
            P[B[i].idx] = i;
        }
    }

    static class Elem implements Comparable<Elem> {
        int idx, num;
        Elem(int idx, int num){
            this.idx =idx;
            this.num = num;
        }
        @Override
        public int compareTo(Elem o) {
          return this.num - o.num;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        for(int i = 0; i < N; i ++){
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb);
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