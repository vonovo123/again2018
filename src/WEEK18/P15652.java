package WEEK18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class P15652 {
    private static final String Vector = null;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static Vector<Integer> v;

    static void dfs() throws IOException {

        if (v.size() == M) {
            for (int i = 0; i < v.size(); i++) {
                if (i == v.size() - 1) {
                    bw.write(v.get(i) + "\n");
                } else {
                    bw.write(v.get(i) + " ");
                }

            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (v.size() == 0) {
                v.add(i);
                dfs();
                v.remove(v.size() - 1);
            } else {
                if (v.get(v.size() - 1) <= i) {
                    v.add(i);
                    dfs();
                    v.remove(v.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        v = new Vector<Integer>();
        dfs();
        bw.flush();
    }
}
