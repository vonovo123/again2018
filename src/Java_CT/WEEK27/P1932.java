package WEEK27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

class P1932 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] ida = new int[N + 1][N];
        for (int i = 1; i <= N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                ida[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int[][] idra = new int[N + 1][N];
        idra[1][0] = ida[1][0];
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    idra[i][j] = idra[i - 1][j];
                } else if (j == i - 1) {
                    idra[i][j] = idra[i - 1][j - 1];
                } else {
                    idra[i][j] = Math.max(idra[i - 1][j - 1], idra[i - 1][j]);
                }
                idra[i][j] += ida[i][j];
            }
        }
        int result = 0;
        // for (int i = 1; i <= N; i++) {
        // String[] tmp = br.readLine().csplit(" ");
        for (int j = 0; j < N; j++) {
            if (result < idra[N][j]) {
                result = idra[N][j];
            }
        }
        System.out.println(result);
        // }
    }
}