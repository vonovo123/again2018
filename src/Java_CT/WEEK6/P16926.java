package WEEK6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class P16926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] table;
    static int t;
    static int N, M, R;


    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        R = Integer.parseInt(tmp[2]);
        R = R % (N * M - ((N - 2) * (M - 2)));
        table = new int[N][M];
        t = Math.min(N, M) / 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            turn();
        }

        printArray(table);
    }
    
    static void printArray(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void turn() {
        for (int i = 0; i < t; i++) {
            int R = N - 1 - i; // 로우
            int C = M - 1 - i; // 컬럼
            int tmp = table[i][i];
            // 상단 가로변
            for (int j = i; j < C; j++) {
                table[i][j] = table[i][j + 1];
            }
            // 우측 세로변
            for (int j = i; j < R; j++) {
                table[j][C] = table[j + 1][C];
            }
            // 하단 가로변
            for (int j = C; j > i; j--) {
                table[R][j] = table[R][j - 1];
            }
            // 좌측 세로변
            for (int j = R; j > i; j--) {
                table[j][i] = table[j - 1][i];
            }
            table[i + 1][i] = tmp;
        }
    }
}
