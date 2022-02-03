package WEEK16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class P1929 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int M, N;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        Queue<Integer> c = new LinkedList<Integer>();
        Vector<Integer> v = new Vector<Integer>();
        boolean[] check = new boolean[N + 1];
        check[1] = true;
        c.add(2);
        if (M <= 2)
            v.add(2);
        while (c.size() != 0) {
            int t = c.poll();
            for (int i = 2; i <= N / t; i++) {
                if (!check[i * t])
                    check[i * t] = true;
            }

            for (int i = t + 1; i <= N; i++) {
                if (!check[i]) {
                    c.add(i);
                    if (i >= M)
                        v.add(i);
                    break;
                }
            }
        }

        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }

}
