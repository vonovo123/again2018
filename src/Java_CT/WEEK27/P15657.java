package WEEK27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

class P15657 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] ia;
    static Vector<Integer> v;

    static void dfs(int idx) throws IOException {
        if (v.size() == M) {
            for (int i = 0; i < M; i++) {
                bw.write(ia[v.get(i)] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = idx; i < N; i++) {
            v.add(i);
            dfs(i);
            v.remove(v.size() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        ia = new int[N];
        v = new Vector<Integer>();
        String[] tmp = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(ia);
        dfs(0);
        bw.flush();
    }
}