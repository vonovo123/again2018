package WEEK31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11060DP {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[N];
        String[] tmpA = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            ia[i] = Integer.parseInt(tmpA[i]);
        }

        int[] ai = new int[N];// 횟수
        for (int i = 1; i < N; i++) {
            int min = N;
            for (int j = i - 1; j >= 0; j--) {
                if (i - j <= ia[j]) { // 거리
                    if (min > ai[j] + 1) {
                        min = ai[j] + 1;
                    }
                }
            }
            ai[i] = min;
        }

        // for (int i = 0; i < N; i++) {
        // System.out.printf("%d ", ai[i]);
        // }

        // System.out.println();

        if (ai[N - 1] == N) {
            System.out.println(-1);
        } else {
            System.out.println(ai[N - 1]);
        }
    }
}
