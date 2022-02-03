package FASTCAMPUS.ALGO.D19;
import java.io.*;
import java.util.*;

public class P16472 {
    static int N;
    static char [] A;
    static int kind;
    static int [] count;
    static int max;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        String [] tmp = scan.next().split("");
        A = new char[tmp.length + 1];
        for(int i = 0; i < tmp.length; i ++){
            A[i + 1] = tmp[i].charAt(0);
        }
        kind = 0;
        count = new int [27];
        max = 0;
    }
    static void pro(){
        int L = 1;
        for(int R = 1 ; R < A.length; R ++){
            count[(int)A[R] - 96] ++;
            if(count[(int)A[R] - 96] == 1){
                kind ++;
            }
            if(kind > N){
                while(kind > N){
                    count[(int)A[L] - 96] --; 
                    if(count[(int)A[L] - 96] == 0){
                        kind --;
                    }
                    L ++;
                }
            }
            //System.out.println("L : " + L);
            //System.out.println("R : " + R);
            if(R - L + 1 > max){
                max = R - L + 1;
            }
        }
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