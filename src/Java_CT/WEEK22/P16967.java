package WEEK22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P16967 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());
        int Y = Integer.parseInt(stk.nextToken());
        int[][] A = new int[H][W];
        int[][] B = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int t = 0;
        for (int i = X; i < H; i++) {

            for (int j = Y; j < W; j++) {
                // System.out.printf("%d %d %d\n", i, j, t);
                B[i][j] = B[i][j] - B[t][j - Y];
            }
            t++;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (j == W - 1) {
                    System.out.printf("%d", B[i][j]);
                } else {
                    System.out.printf("%d ", B[i][j]);
                }
            }
            System.out.println();
        }
    }

}
