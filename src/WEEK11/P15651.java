package WEEK11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class P15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static Vector<Integer> v;
    static void dfs() throws IOException {
        
        if (v.size() == M) {
            String output = "";
            for (int i = 0; i < M; i++) {
                output += v.get(i) + " ";
            }
            bw.write(output.trim() + "\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            v.add(i);
            dfs();
            v.remove(v.size() - 1);

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