package WEEK20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P16931 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] ia = new int[N][M];
        int max = 0;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ia[i][j] = Integer.parseInt(stk.nextToken());
                if (ia[i][j] > max)
                    max = ia[i][j];
            }
        }
        int result = N * M * 2; // 위 아래
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 뒤
                if ((j == M - 1) || (j < M - 1 && (ia[i][j] > ia[i][j + 1]))) {
                    if (j == M - 1) {
                        result += ia[i][j];
                    } else {
                        result += ia[i][j] - ia[i][j + 1];
                    }
                }
                // 앞

                if (j == 0 || (j > 0 && (ia[i][j] > ia[i][j - 1]))) {
                    if (j == 0) {
                        result += ia[i][j];
                    } else {
                        result += ia[i][j] - ia[i][j - 1];
                    }
                }

                // 앞
                if (i == N - 1 || (i < N - 1 && ia[i][j] > ia[i + 1][j])) {
                    if (i == N - 1) {
                        result += ia[i][j];
                    } else {
                        result += ia[i][j] - ia[i + 1][j];
                    }
                }

                // 뒤
                if (i == 0 || (i > 0 && (ia[i][j] > ia[i - 1][j]))) {
                    if (i == 0) {
                        result += ia[i][j];
                    } else {
                        result += ia[i][j] - ia[i - 1][j];
                    }
                }
            }
        }
        System.out.println(result);

    }
}
