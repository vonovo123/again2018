package WEEK30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] ia = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                ia[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int max = 0;
                if (i - 1 >= 0) {
                    if (max < ia[i - 1][j]) {
                        max = ia[i - 1][j];
                    }
                }
                if (j - 1 >= 0) {
                    if (max < ia[i][j - 1]) {
                        max = ia[i][j - 1];
                    }
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (max < ia[i - 1][j - 1]) {
                        max = ia[i - 1][j - 1];
                    }
                }
                ia[i][j] += max;
            }
        }
        System.out.println(ia[N - 1][M - 1]);
    }
}
