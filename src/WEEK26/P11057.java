package WEEK26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11057 {
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws NumberFormatException, IOException {
                int N = Integer.parseInt(br.readLine());
                int[][] arr = new int[1001][10];
                arr[1][0] = 1;
                arr[1][1] = 1;
                arr[1][2] = 1;
                arr[1][3] = 1;
                arr[1][4] = 1;
                arr[1][5] = 1;
                arr[1][6] = 1;
                arr[1][7] = 1;
                arr[1][8] = 1;
                arr[1][9] = 1;
                for (int i = 2; i <= N; i++) {
                        arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] + arr[i - 1][3] + arr[i - 1][4]
                                        + arr[i - 1][5] + arr[i - 1][6] + arr[i - 1][7] + arr[i - 1][8] + arr[i - 1][9])
                                        % 10007;
                        arr[i][1] = (arr[i - 1][1] + arr[i - 1][2] + arr[i - 1][3] + arr[i - 1][4] + arr[i - 1][5]
                                        + arr[i - 1][6] + arr[i - 1][7] + arr[i - 1][8] + arr[i - 1][9]) % 10007;
                        arr[i][2] = (arr[i - 1][2] + arr[i - 1][3] + arr[i - 1][4] + arr[i - 1][5] + arr[i - 1][6]
                                        + arr[i - 1][7] + arr[i - 1][8] + arr[i - 1][9]) % 10007;
                        arr[i][3] = (arr[i - 1][3] + arr[i - 1][4] + arr[i - 1][5] + arr[i - 1][6] + arr[i - 1][7]
                                        + arr[i - 1][8] + arr[i - 1][9]) % 10007;
                        arr[i][4] = (arr[i - 1][4] + arr[i - 1][5] + arr[i - 1][6] + arr[i - 1][7] + arr[i - 1][8]
                                        + arr[i - 1][9]) % 10007;
                        arr[i][5] = (arr[i - 1][5] + arr[i - 1][6] + arr[i - 1][7] + arr[i - 1][8] + arr[i - 1][9])
                                        % 10007;
                        arr[i][6] = (arr[i - 1][6] + arr[i - 1][7] + arr[i - 1][8] + arr[i - 1][9]) % 10007;
                        arr[i][7] = (arr[i - 1][7] + arr[i - 1][8] + arr[i - 1][9]) % 10007;
                        arr[i][8] = (arr[i - 1][8] + arr[i - 1][9]) % 10007;
                        arr[i][9] = (arr[i - 1][9]) % 10007;
                }
                int result = 0;
                for (int i = 0; i <= 9; i++) {
                        result += arr[N][i];
                }
                System.out.println(result);
        }
}
