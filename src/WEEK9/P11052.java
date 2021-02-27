package WEEK9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int compare(int a, int b){
        return a >= b ? a : b;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] packs = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            packs[i] = Integer.parseInt(stk.nextToken());
        }

        dp[1] = packs[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = packs[i];
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = compare(dp[i], dp[j] + dp[i - j]);
            }
        }

            System.out.println(dp[N]);
    }
}
