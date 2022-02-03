package WEEK4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P15650 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static boolean[] visited;
    static Vector<Integer> v;

    static void dfs(int index) throws IOException {
        if (v.size() == M) {
            for (int j = 0; j < v.size(); j++) {
                if (j != v.size() - 1) {
                    bw.write(v.get(j) + " ");
                } else {
                    bw.write(v.get(j) + "\n");
                }
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                if (v.size() == 0 || v.get(v.size() - 1) < i) {
                    visited[i - 1] = true;
                    v.add(i);
                    dfs(i);
                    visited[i - 1] = false;
                    v.remove(v.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        v = new Vector<Integer>();
        visited = new boolean[N];
        dfs(1);
        bw.flush();

    }
}
