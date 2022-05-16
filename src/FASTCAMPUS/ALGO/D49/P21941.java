package FASTCAMPUS.ALGO.D49;
import java.io.*;
import java.util.*;

public class P21941 {
    public static class Pair {
        public int first;
        public int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

    }
    static String s;
    static int N;
    static int[] dp;
    static ArrayList<ArrayList<Pair>> strings;
    static FastReader scan;
    static void input() {
        scan = new FastReader();
        s = scan.next();
        N = scan.nextInt();
        for(int i = 0; i < N; i ++){
            strings.add(new ArrayList<Pair>());
        }
        dp = new int [s.length() + 1];

    }
    public static void pro(){
        for(int i = 0; i < N; i ++){
            String [] input = scan.next().split(" ");
            int length = input[0].length();
            int score = Integer.parseInt(input[1]);
            if(length >= score) continue;
            int idx = 0;
            while(idx < s.length()){
                int pos = s.indexOf(input[0], idx);
                if(pos == -1) break;
                strings.get(pos).add(new Pair(length, score));
                idx = pos + 1;
            }
        }
        for(int i = 0; i < s.length(); i ++){
            dp[i + 1] = Math.max(dp[i], dp[i] + 1);
            for(int j = 0; j < strings.get(i).size(); j ++){
                Pair pair = strings.get(i).get(j);
                int length = pair.first;
                int score = pair.second;
                dp[i + length] = Math.max(dp[i + length], dp[i] + score);
            }
        }
        System.out.println(dp[s.length() - 1]);
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