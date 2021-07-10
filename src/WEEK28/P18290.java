package WEEK28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class P18290 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[][] arr;
    static Vector<node> v;
    static int[][] visited;
    static int min;

    static void dfs(int y, int x) {
        if (v.size() == K) {
            int result = 0;
            for (int i = 0; i < K; i++) {
                node n = v.get(i);
                result += arr[n.y][n.x];
                // System.out.printf("y: %d x: %d ", n.y, n.x);
            }
            // System.out.println();
            if (min < result) {
                min = result;
            }
            return;
        }
        for (int i = y; i < N; i++) {
            for (int j = x; j < M; j++) {
                // for (int a = 0; a < N; a++) {
                // for (int b = 0; b < M; b++) {
                // System.out.printf("%d ", visited[a][b]);
                // }
                // System.out.println();
                // }
                // System.out.println();
                if (visited[i][j] == 0) {
                    if (i - 1 >= 0) {
                        visited[i - 1][j] += 1;
                    }
                    if (i + 1 < N) {
                        visited[i + 1][j] += 1;
                    }

                    if (j - 1 >= 0) {
                        visited[i][j - 1] += 1;

                    }
                    if (j + 1 < M) {
                        visited[i][j + 1] += 1;
                    }
                    visited[i][j] = 1;
                    v.add(new node(i, j));
                    if (i < M - 1) {
                        dfs(i, 0);
                    } else {
                        dfs(i + 1, 0);
                    }

                    v.remove(v.size() - 1);
                    visited[i][j] = 0;
                    if (i - 1 >= 0) {
                        visited[i - 1][j] -= 1;
                    }
                    if (i + 1 < N) {
                        visited[i + 1][j] -= 1;
                    }

                    if (j - 1 >= 0) {
                        visited[i][j - 1] -= 1;
                    }
                    if (j + 1 < M) {
                        visited[i][j + 1] -= 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        v = new Vector<node>();
        arr = new int[N][M];
        visited = new int[N][M];
        min = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    static class node {
        int y;
        int x;

        node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
