package WEEK9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1476 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int E, S, M, R;
        E = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = 0;

        while (E != 0 || S != 0 || M != 0) {
            if (E == 0)
                E = 15;
            if (S == 0)
                S = 28;
            if (M == 0)
                M = 19;

            E -= 1;
            S -= 1;
            M -= 1;
            R += 1;
        }
        System.out.println(R);
    }
}
// 12 --- 5 + 7 (mod 35)
//5A1 + 2
//7a2 + 5