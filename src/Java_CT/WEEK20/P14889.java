package WEEK20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

class P14889 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] ia;
    static int[] A;
    static int[] B;
    static Vector<Integer> v;
    static int[] visited;
    static Vector<Integer> rv;

    static void dfs(int in) {
        if (v.size() == N / 2) {
            int result = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    result += ia[v.get(i)][v.get(j)];
                    result += ia[v.get(j)][v.get(i)];
                }
            }
            rv.add(result / 2);
            return;
        }
        for (int i = in; i < N; i++) {
            if (visited[i] == 0) {
                v.add(i);
                visited[i] = 1;
                dfs(i);
                v.remove(v.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        ia = new int[N][N];
        v = new Vector<Integer>();
        visited = new int[N];
        rv = new Vector<Integer>();
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ia[i][j] = Integer.parseInt(in[j]);
            }
        }
        dfs(0);
        int min = 101;
        for (int i = 0; i < rv.size() / 2; i++) {
            if (min > Math.abs(rv.get(i) - rv.get(rv.size() - 1 - i)))
                min = Math.abs(rv.get(i) - rv.get(rv.size() - 1 - i));
        }
        System.out.println(min);
    }
}