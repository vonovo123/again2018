package WEEK25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        // 가격
        int[][] pay = new int[N + 1][3];
        // 최소
        int[][] arr = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                pay[i][j] = Integer.parseInt(tmp[j]);
                // System.out.printf("%d ", pay[i][j]);
            }
            // System.out.println();
        }

        arr[1][0] = pay[1][0];
        arr[1][1] = pay[1][1];
        arr[1][2] = pay[1][2];

        for (int i = 2; i <= N; i++) {
            arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + pay[i][0];
            arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + pay[i][1];
            arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + pay[i][2];
        }
        System.out.println(Math.min(Math.min(arr[N][0], arr[N][1]), arr[N][2]));
    }
}
