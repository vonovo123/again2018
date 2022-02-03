package WEEK13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P15990 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[100001][3];
        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[1][2] = 0;

        arr[2][1] = 1;
        arr[2][0] = 0;
        arr[2][2] = 0;

        arr[3][0] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;

        for (int i = 4; i <= 100000; i++) {
            arr[i][0] = (arr[i - 1][1] + arr[i - 1][2]) % 1000000009;
            arr[i][1] = (arr[i - 2][0] + arr[i - 2][2]) % 1000000009;
            arr[i][2] = (arr[i - 3][0] + arr[i - 3][1]) % 1000000009;
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            sum += arr[n][0];
            sum %= 1000000009;
            sum += arr[n][1];
            sum %= 1000000009;
            sum += arr[n][2];
            sum %= 1000000009;
            System.out.println(sum % 1000000009);
        }

    }
}
