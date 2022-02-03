package WEEK22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

class P1699 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        // for (int i = 1; i <= 1000; i++) {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) { // dp 2부터 채우기 시작
            dp[i] = i; // 우선 자기자신으로 초기화 해둔다.
            for (int j = 1; j * j <= i; j++) { // j는 1부터 제곱 수가 i보다 작을 경우 반복한다.
                dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]); // 최소항의 개수를 찾기 위해서 저장 된 값과 점화식값을 비교하여 최솟값을 취한다.
            }
        }

        // int N = i;
        for (int j = 0; j < 100; j++) {
            int N = j;
            int t = (int) Math.sqrt(N);
            int[] p = new int[t + 1];
            int min = 100000;
            for (int i = 0; i < t; i++) {
                int count = 0;
                int sum = 0;
                int tt = t - i;
                Vector<Integer> v = new Vector<>();
                while (sum != N) {
                    if (p[tt] == 0) {
                        p[tt] = tt * tt;
                    }
                    sum += p[tt];
                    count++;
                    // System.out.println(tt);
                    v.add(tt);
                    tt = (int) Math.sqrt(N - sum);

                }
                // System.out.println();
                if (count < min) {
                    min = count;
                }

            }
            if (dp[j] != min) {
                System.out.printf("j : %d, dp : %d , my: %d\n", j, dp[j], min);
            }
        }

        // 48 36 // }

    }
}