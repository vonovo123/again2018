package FASTCAMPUS.ALGO.D27;
import java.io.*;
import java.util.*;

public class P1920 {
    static int N, M;
    static ArrayList<Long> A, B;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new ArrayList<Long>();
        for(int i = 1; i <= N; i ++){
            A.add(scan.nextLong());
        }
        B = new ArrayList<Long>();
        M = scan.nextInt();
        for(int i = 1; i <= M; i ++){
            B.add(scan.nextLong());
        }
        sb = new StringBuilder();
    }
    public static void pro(){
        Collections.sort(A);
        for(int i = 0; i < B.size(); i ++){
            int L = 0;
            int R = A.size() - 1;
            Long D = B.get(i);
            int result = 0;
            while(L <= R){
                int mid = (L + R) / 2;
                if(A.get(mid) > D){
                    R = mid - 1;
                } else if(A.get(mid) < D) {
                    L = mid + 1;
                } else {
                    result = 1;
                    break;
                }
            }
            sb.append(result).append("\n");
            //System.out.println(result);
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        //input();
        //pro();
        System.out.println(Integer.MAX_VALUE == Math.pow(2, 31) - 1);
        System.out.println();
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