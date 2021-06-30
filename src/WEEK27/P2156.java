package WEEK27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P2156 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            ia[i] = Integer.parseInt(br.readLine());
        }
        int[][] iaa = new int[N + 1][3];
        // 0: 안마심 1: 첫잔째 2: 두잔째
        iaa[1][1] = ia[1];

        for (int i = 1; i <= N; i++) {
            //
            iaa[i][0] = Math.max(Math.max(iaa[i - 1][0], iaa[i - 1][1]), iaa[i - 1][2]);
            iaa[i][1] = ia[i] + iaa[i - 1][0];
            iaa[i][2] = ia[i] + iaa[i - 1][1];
        }

        System.out.println(Math.max(Math.max(iaa[N][0], iaa[N][1]), iaa[N][2]));

    }
}