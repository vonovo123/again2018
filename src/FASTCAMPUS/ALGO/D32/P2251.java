package FASTCAMPUS.ALGO.D32;
import java.io.*;
import java.util.*;

class State {
    int [] X;
    State (int [] _X){
        X = new int [3];
        for(int i = 0; i < _X.length; i ++){
            X[i] = _X[i];
        }
    }
    public State move(int from, int to, int[] limit){
        int [] nX = {X[0], X[1], X[2]};
        if(nX[from] + nX[to] <= limit[to]){
            nX[to] = nX[from] + nX[to];
            nX[from] = 0;
        } else {
            nX[from] -= limit[to] - nX[to];
            nX[to] = limit[to];
        }
        return new State(nX);
    }
}
public class P2251 {
    static int [] limit;
    static int [][][] visited;
    static int [] possible;
    static StringBuilder sb;
    static void input() {
        FastReader scan = new FastReader();
        limit = new int [3];
        visited = new int [201][201][201];
        possible = new int [201];
        for(int i = 0; i < 3; i ++){
            limit[i] = scan.nextInt();
        }
        sb = new StringBuilder();
    }
    public static void bfs(int x1, int x2, int x3){
        LinkedList<State> Q = new LinkedList<State>();
        visited[x1][x2][x3] = 1;
        Q.add(new State(new int[]{x1, x2, x3}));
        while(!Q.isEmpty()){
            State st = Q.poll();
            if(st.X[0] == 0) possible[st.X[2]] = 1;
            for(int from = 0; from < 3; from ++){
                for(int to = 0; to < 3; to ++){
                    if(from == to) continue;
                    State nxt = st.move(from, to, limit);
                    if(visited[nxt.X[0]][nxt.X[1]][nxt.X[2]] == 0){
                        visited[nxt.X[0]][nxt.X[1]][nxt.X[2]] = 1;
                        Q.add(nxt);
                    }
                }
            }
        }
    }
    public static void pro(){
        bfs(0,0,limit[2]);
        for(int i = 0; i < possible.length; i ++){
            if(possible[i] == 1){
                sb.append(i);
                sb.append(" ");
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