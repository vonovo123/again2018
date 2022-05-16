package FASTCAMPUS.ALGO.D49;
import java.io.*;
import java.util.*;

public class P21939 {
    static FastReader scan;
    static int N, M;
    static TreeSet<Problem> tree;
    static HashMap<Integer, Integer> Problems;
    static class Problem implements Comparable<Problem> {
        public int id;
        public int level;
        Problem(int id, int level){
            this.id = id;
            this.level = level;
        }
        @Override
        public int compareTo(Problem other) {
        // TODO Auto-generated method stub
        if(this.level != other.level) return this.level - other.level;
        return this.id - other.id;
        }
    }
    static void input() {
        scan = new FastReader();
        tree = new TreeSet<Problem>();
        Problems = new HashMap<Integer, Integer>();
        N = scan.nextInt();
        for(int i = 0; i < N; i ++){
            int id = scan.nextInt();
            int level = scan.nextInt();
            tree.add(new Problem(id, level));
            Problems.put(id, level);
        }
        M = scan.nextInt();
    }
    public static void pro(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i ++ ){
            String command = scan.next();
            if(command.equals("add")){
                int id = scan.nextInt();
                int level = scan.nextInt();
                tree.add(new Problem(id, level));
                Problems.put(id, level);
            } else if(command.equals("recommend")){
                int x = scan.nextInt();
                if(x == -1){
                    sb.append(tree.first().id + "\n");
                } else {
                    sb.append(tree.last().id + "\n");
                }
            } else if(command.equals("solved")){
                int id = scan.nextInt();
                int level = Problems.get(id);
                tree.remove(new Problem(id, level));
                Problems.remove(id);
            }
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