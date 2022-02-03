package WEEK25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class P6603 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static int[] visited;
    static int[] arr;
    static Vector<Integer> v;

    static void dfs(int idx) {
        if (v.size() == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.printf("%d ", v.get(i));
            }
            System.out.println();
            return;
        }
        for (int i = idx; i < k; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                v.add(arr[i]);
                dfs(i + 1);
                v.remove(v.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String in = null;
        int idx = 0;
        while (!(in = br.readLine()).equals("0")) {
            if (idx != 0) {
                System.out.println();
            }
            StringTokenizer stk = new StringTokenizer(in);
            k = Integer.parseInt(stk.nextToken());
            arr = new int[k];
            visited = new int[k];
            v = new Vector<Integer>();
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            dfs(0);
            idx++;
        }

    }
}
