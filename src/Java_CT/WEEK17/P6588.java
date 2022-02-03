package WEEK17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class P6588 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] ia;

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(2);
        while (q.size() != 0) {
            int t = q.poll();
            for (int i = 2; i <= 1000000 / t; i++) {
                if (ia[i * t] == 0) {
                    ia[i * t] = 1; // 소수가 아님
                }

            }
            t += 1;
            while (t < 1000000 && ia[t] != 0) {
                t++;
            }

            if (t < 1000000) {
                q.add(t);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ia = new int[1000001];

        bfs();
        int in = 0;

        while ((in = Integer.parseInt(br.readLine())) != 0) {
            int flag = 0;
            for (int i = 2; i <= in / 2; i++) {
                if (ia[i] == 0 && ia[in - i] == 0) {
                    flag = 1;
                    String ans = "";
                    ans += in;
                    ans += " = ";
                    ans += i;
                    ans += " + ";
                    ans += in - i;
                    ans += "\n";
                    // System.out.println(ans);
                    bw.write(ans);
                    break;
                }
            }
            if (flag == 0)
                bw.write("Goldbach's conjecture is wrong\n");
            // System.out.println();
        }
        bw.flush();
    }

}