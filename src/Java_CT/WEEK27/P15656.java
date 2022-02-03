package WEEK27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class P15656 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] ia;
    static int[] visited;
    static Vector<Integer> v;

    static void dfs() throws IOException {
        if (v.size() == M) {
            for (int i = 0; i < M; i++) {
                // System.out.printf("%d ", ia[v.get(i)]);
                bw.write(ia[v.get(i)] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            // if (visited[i] == 0) {
            // visited[i] = 1;
            v.add(i);
            dfs();
            v.remove(v.size() - 1);
            // visited[i] = 0;
            // }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        visited = new int[N];
        ia = new int[N];
        v = new Vector<Integer>();
        String[] tmp = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(ia);
        dfs();
        bw.flush();

    }
}
