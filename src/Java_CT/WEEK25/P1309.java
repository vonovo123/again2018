package WEEK25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1309 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][3];
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] % 9901;
            arr[i][1] = arr[i - 1][0] + arr[i - 1][2] % 9901;
            arr[i][2] = arr[i - 1][0] + arr[i - 1][1] % 9901;
        }
        int result = arr[N][0] + arr[N][1] + arr[N][2] % 9901;
        System.out.println(result);

    }
}
