package WEEK15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P10974 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[] visited;
    static Vector<Integer> v;

    static void dfs(int n) throws IOException {
        // System.out.println(n);
        if (v.size() == N) {
            for (int i = 0; i < v.size(); i++) {
                bw.write(v.get(i) + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                v.add(i);
                visited[i] = true;
                dfs(i + 1);
                visited[i] = false;
                v.remove(v.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        v = new Vector<Integer>();
        visited = new boolean[N + 1];
        dfs(1);
        bw.flush();
    }
}
