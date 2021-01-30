package WEEK6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] table;
    static int[][] tmpt;
    static int t;
    static void turn(int N, int M) {
        for (int i = 0; i < t; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                table[j + 1][i] = tmpt[j][i];
                table[N - 2 - j][M - 1 - i] = tmpt[N - 1 - j][M - 1 - i];
            }
            for (int j = i; j < M - 1 - i; j++) {
                table[N - 1 - i][j + 1] = tmpt[N - 1 - i][j];
                table[i][M - 2 - j] = tmpt[i][M - 1 - j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int N, M, R;
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        R = Integer.parseInt(tmp[2]);
        R = R % (N * M - ((N - 2) * (M - 2)));
        table = new int[N][M];
        tmpt = new int[N][M];
        t = Math.min(N, M) / 2;
        
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(tmp[j]);
                tmpt[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        for (int i = 0; i < R; i++) {
            turn(N, M);
            for (int a = 0; a < N; a++) {
                System.arraycopy(table[a], 0, tmpt[a], 0, M);
            }
        }

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                if(b != M - 1)
                    System.out.printf("%d ", table[a][b]);
                else
                    System.out.printf("%d", table[a][b]);
            }
            System.out.println();
        }

    }
}
