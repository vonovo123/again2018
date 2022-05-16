package FASTCAMPUS.ALGO.D26;
import java.io.*;
import java.util.*;

public class P20291 {
    static int N;
    static ArrayList<String> aList;
    static ArrayList<String> name;
    static Hashtable<String, Integer> count;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        aList = new ArrayList<String>();
        name = new ArrayList<String>();
        count = new Hashtable<String, Integer>();
        for(int i = 0; i < N; i ++){
            aList.add(scan.nextLine());
        }
        sb = new StringBuilder();
    }
    public static void pro(){
   
     for (String value : aList) {
        String extention = value.split("\\.")[1];
        name.add(extention);
     }
     Collections.sort(name);
     for(int i = 0; i < N; ){
         int count = 1;
         int j = i + 1;
         for(; j < N; j ++){
            if(name.get(i).compareTo(name.get(j)) == 0){
                count ++;
            } else {
                break;
            }
         }
         sb.append(name.get(i)).append(' ').append(count).append('\n');
         i = j;
     }
     System.out.println(sb);
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