package WEEK22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class P15654 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[] ia;
    static int[] v;
    static Vector<Integer> vec;

    static void dfs() throws IOException {
        if (vec.size() == M) {
            for (int i = 0; i < vec.size(); i++) {
                bw.write(ia[vec.get(i)] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i] == 0) {
                vec.add(i);
                v[i] = 1;
                dfs();
                vec.remove(vec.size() - 1);
                v[i] = 0;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        String[] tmp = br.readLine().split(" ");
        v = new int[N];
        vec = new Vector<Integer>();
        ia = new int[N];
        for (int i = 0; i < tmp.length; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(ia);
        dfs();
        bw.flush();
    }
}
