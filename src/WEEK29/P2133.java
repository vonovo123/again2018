package WEEK29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2133 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        // int[][] arr = new int[16][2];
        int[] arr = new int[16];
        arr[1] = 3;
        arr[2] = 3 * 3 + 2;

        for (int i = 3; i <= 15; i++) {
            arr[i] = arr[i - 1] * 3 + arr[i - 2] * 2;
            arr[i] += 2;
        }
        // 짝수
        if (N % 2 == 0) {
            System.out.println(arr[N / 2]);
        } else { // 홀수
            System.out.println(0);
        }

    }
}
