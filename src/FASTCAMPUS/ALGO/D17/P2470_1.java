package FASTCAMPUS.ALGO.D17;
import java.io.*;
import java.util.*;

public class P2470_1 {
    static int N;
    static int [] A;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N];
        for(int i = 0; i < N; i ++){
            A[i] = scan.nextInt();
        }
    }
    public static int lower_bound(int[] A, int L, int R, int T){
        int result = L - 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] <= T){
                result = mid;
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        return result;
    }
    public static void pro (){
        Arrays.sort(A);
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for(int i = 0; i < N; i ++){
            int result = lower_bound(A, 0, N - 1, -A[i]);
            if(result != i){
                if(result >= 0){
                    if(min > Math.abs(A[i] + A[result])){
                        min = Math.abs(A[i] + A[result]);
                        if(i < result){
                            a = i;
                            b = result;
                        } else {
                            a = result;
                            b = i; 
                        }
                    }
                }
            }

            if(result + 1 != i){
                if(result + 1 < N){
                    if(min > Math.abs(A[i] + A[result + 1])){
                        min = Math.abs(A[i] + A[result + 1]);
                        if(i < result + 1){
                            a = i;
                            b = result + 1;
                        } else {
                            a = result + 1;
                            b = i; 
                        }
                    }
                }
            }
        }
        System.out.println(A[a] + " " + A[b]);
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