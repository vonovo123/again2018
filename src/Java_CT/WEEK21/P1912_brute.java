package WEEK21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

class P1912_brute {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visited;
    static Vector<Integer> v;
    static int n;
    static int[] ia;
    static int max;

    static void dfs(int idx) {
        if (v.size() != 0) {
            int result = 0;
            for (int i = 0; i < v.size(); i++) {
                // System.out.printf("%d ", v.get(i));
                result += ia[v.get(i)];
            }
            // System.out.println();
            // System.out.println(result);
            if (max < result)
                max = result;
        }
        for (int i = idx; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                v.add(i);
                dfs(i + 1);
                // visited[i] = 0;
                // v.remove(v.size() - 1);

            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        ia = new int[tmp.length];
        for (int i = 0; i < ia.length; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        max = -100000000;
        for (int i = 0; i < n; i++) {
            v = new Vector<Integer>();
            visited = new int[n];
            dfs(i);
        }
        System.out.println(max);

    }
}