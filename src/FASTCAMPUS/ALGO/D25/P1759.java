package FASTCAMPUS.ALGO.D25;
import java.io.*;
import java.util.*;

public class P1759 {
    static int L, C;
    static String [] A;
    static String moTable = "aeiou";
    static int ja, mo;
    static ArrayList<String> arr;
    static void input() {
        FastReader scan = new FastReader();
        L = scan.nextInt();
        C = scan.nextInt();
        A = new String[C];
        for(int i = 0; i < C; i ++){
            A[i] = scan.next();
        }
        Arrays.sort(A);
        arr = new ArrayList<String>();
    }
    static StringBuilder sb;
    public static void dfs(int idx, int ja, int mo){
        if(arr.size() == L){
            if(ja >= 2 && mo >=1){
                sb = new StringBuilder();
                for (String string : arr) {
                    sb.append(string);
                }
                System.out.println(sb);
            }
            return;
        }
        if(idx  >= C){
            return;
        }
        int type = 0;
        String spell  = A[idx];
        //System.out.println(spell);
        //모음
        if(moTable.indexOf(spell) != -1){
            type = 1;
        }
        arr.add(spell);
        //System.out.println("arr:" + arr);
        if(type == 0){
            dfs( idx + 1, ja + 1, mo);
        }  else {
            dfs(idx + 1, ja , mo + 1);
        }
        arr.remove(spell);
        dfs(idx + 1, ja, mo);
 
    }
    public static void pro(){
        dfs(0,0,0);
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