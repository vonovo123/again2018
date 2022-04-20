package FASTCAMPUS.ALGO.D26;
import java.io.*;
import java.util.*;

public class P1181 {
    static int N;
    static ArrayList<String> A;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new ArrayList<String>();
        for(int i = 1; i <= N; i ++){
            A.add(scan.next());
        }
        sb = new StringBuilder();
    }
    public static void pro(){
        Collections.sort(A,  new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                } else {
                    int length = o1.length();
                    int front = 0;
                    int back = 0;
                    for(int i = 0; i < length; i ++){
                        front = (int) o1.charAt(i);
                        back = (int) o2.charAt(i);
                        if(front != back){
                            break;
                        }


                    }
                    return front - back;
                } 
            }
        });
    }
    public static void main(String[] args) {
        input();
        pro();

        String before = null;
        for (String el : A) {
            if(before == null || !el.equals(before)){
                sb.append(el).append('\n');
            }
            before = el;
            
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