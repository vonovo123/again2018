package WEEK23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P14501 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] ia = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                ia[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int[][] dp = new int[N + 1][2];
        // dp[1][0] = 1 + ia[1][0]; // 끝나는 날
        // dp[1][1] = ia[1][1]; // 최대 금액

        for (int i = 1; i <= N; i++) {
            if (i + ia[i][0] <= N + 1) {
                // 끝나는 날
                dp[i][0] = i + ia[i][0];
                // 최대 금액
                dp[i][1] = ia[i][1];
            }
            int max = dp[i][1];
            if (i + ia[i][0] <= N + 1) {
                for (int j = 1; j < i; j++) {
                    // i 시작일이 j가 끝나는 날보다 크면

                    if (dp[j][0] <= i) {
                        if (max < dp[j][1] + ia[i][1]) {
                            max = dp[j][1] + ia[i][1];
                        }
                    }
                }
                dp[i][1] = max;
            }
        }
        int mmax = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i][1] > mmax) {
                mmax = dp[i][1];
            }
        }
        System.out.println(mmax);
    }
}