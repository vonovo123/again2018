package WEEK26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class P15655 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] arr;
    static Vector<Integer> v;
    static int[] visited;

    static void dfs(int idx) {
        if (v.size() == M) {
            for (int i = 0; i < M; i++) {
                System.out.printf("%d ", v.get(i));
            }
            System.out.println();
            return;
        }
        for (int i = idx; i < N; i++) {
            // if (visited[i] == 0) {
            // visited[i] = 1;
            v.add(arr[i]);
            int next = i + 1;
            dfs(next);
            // visited[i] = 0;
            v.remove(v.size() - 1);
            // }

        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        String[] tmp = br.readLine().split(" ");
        arr = new int[tmp.length];
        visited = new int[arr.length];
        v = new Vector<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(arr);
        dfs(0);
    }
}
