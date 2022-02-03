package WEEK29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P13398 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] ia = new int[n];
        for (int i = 0; i < n; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        int max = ia[0];
        int[][] result = new int[100001][2];

        for (int i = 0; i < n; i++) {
            result[i][0] = result[i][1] = ia[i];
            if (i == 0)
                continue;
            result[i][0] = Integer.max(result[i - 1][0] + ia[i], ia[i]);
            result[i][1] = Integer.max(result[i - 1][0], result[i - 1][1] + ia[i]);
            int bgr = Integer.max(result[i][0], result[i][1]);
            if (max < bgr)
                max = bgr;
        }
        // System.out.println(max);
        // for (int i = 0; i < n; i++) {
        // for (int j = i; j < n; j++) {
        // System.out.printf("%d ", result[i][j]);
        // }
        // System.out.println();
        // }
        System.out.println(max);
    }
}