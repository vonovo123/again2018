package WEEK20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

class P10819 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Vector<Integer> v;
    static int[] visited;
    static int[] ia;
    static int Result;

    static int cal(int[] arr) {
        int result = 0;
        for (int i = 0; i <= N - 2; i++) {
            result += Math.abs(ia[arr[i]] - ia[arr[i + 1]]);
        }
        return result;
    }

    static void dfs() {
        if (v.size() == N) {
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = v.get(i);
                // System.out.printf("%d ", arr[i]);
            }
            // System.out.println();
            int result = cal(arr);
            if (Result < result) {
                Result = result;
            }
            ;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                v.add(i);
                dfs();
                visited[i] = 0;
                v.remove(v.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        ia = new int[tmp.length];
        visited = new int[N];
        v = new Vector<Integer>();
        for (int i = 0; i < tmp.length; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        Result = 0;
        dfs();
        System.out.println(Result);
    }
}