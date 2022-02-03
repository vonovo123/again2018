package WEEK11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P16194 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int compare(int a, int b) {
        return a >= b ? b : a;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        String[] tmp = br.readLine().split(" ");
        int[] ia = new int[N + 1];
        int c = 1;
        for (String t : tmp) {
            ia[c] = Integer.parseInt(t);
            c++;
        }

        dp[1] = ia[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = ia[i];
            for (int j = 1; j <= i; j++) {
                
                dp[i] = compare(dp[i], dp[j] + dp[i - j]); 
                
            }
        }
        System.out.println(dp[N]);

    }
}