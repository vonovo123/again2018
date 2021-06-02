package WEEK23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P10971 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Vector<Integer> v;
    static int[] visited;
    static int[][] ia;
    static int N;
    static int Min;

    static void dfs(int idx) {
        if (v.size() == N) {
            int tmp = 0;
            for (int i = 1; i < v.size(); i++) {
                tmp += ia[v.get(i - 1)][v.get(i)];
            }
            if (ia[v.get(v.size() - 1)][v.get(0)] != 0) {
                tmp += ia[v.get(v.size() - 1)][v.get(0)];
                if (tmp < Min) {
                    Min = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (v.size() == 0) {
                    v.add(i);
                    visited[i] = 1;
                    dfs(i);
                    v.remove(v.size() - 1);
                    visited[i] = 0;
                } else {
                    if (ia[v.get(v.size() - 1)][i] != 0) {
                        v.add(i);
                        visited[i] = 1;
                        dfs(i);
                        v.remove(v.size() - 1);
                        visited[i] = 0;
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        ia = new int[N][N];
        visited = new int[N];
        Min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ia[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        v = new Vector<Integer>();

        dfs(0);
        if (Min == Integer.MAX_VALUE) {
            Min = 0;
        }
        System.out.println(Min);
        // for (int i = 0; i < laa.length; i++) {
        // Iterator<Integer> itr = laa[i].iterator();

        // while (itr.hasNext()) {
        // System.out.println(itr.next());
        // }
        // System.out.println();
        // }

    }
}
