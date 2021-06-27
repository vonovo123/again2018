package WEEK26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[][] S;
    static int[] iarr;
    static String[] sarr;
    static int[] result;
    static boolean find;

    // 판별
    static boolean make(int in) {
        for (int i = 0; i < in; i++) {
            for (int j = i; j < in; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += iarr[k];
                }
                if ("-".equals(S[i][j])) {
                    if (sum >= 0) {
                        return false;
                    }
                } else if ("0".equals(S[i][j])) {
                    if (sum != 0) {
                        return false;
                    }
                } else {
                    if (sum <= 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void dfs(int depth) {
        if (depth == N) {
            if (make(N)) {
                for (int j = 0; j < N; j++) {
                    result[j] = iarr[j];
                    // System.out.println("t: " + iarr[j]);
                }
                // System.out.println("done");
                find = true;
            }
            return;
        } else {
            if (!make(depth))
                return;
        }
        if (!find) {
            for (int i = 1; i <= 10; i++) {
                if ("-".equals(sarr[depth])) {
                    iarr[depth] -= 1;
                } else if ("+".equals(sarr[depth])) {
                    iarr[depth] += 1;
                }
                dfs(depth + 1);
                if (depth < N - 1) {
                    iarr[depth + 1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        int size = N * (N + 1) / 2;
        String[] tmp = new String[size];
        tmp = br.readLine().split("");
        find = false;
        // for (int i = 0; i < size; i++) {
        // System.out.println(tmp[i]);
        // }
        S = new String[N][N];
        int k = 0;
        iarr = new int[N];
        sarr = new String[N];
        result = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                S[i][j] = tmp[k];
                k++;
                if (j == i) {// 각각의 수
                    sarr[i] = S[i][j];
                }
            }
        }
        // iarr[0] = -2;
        // iarr[1] = 5;
        // iarr[2] = -3;
        // iarr[3] = 1;
        // boolean result = false;
        dfs(0);
        for (int i = 0; i < N; i++) {
            System.out.printf("%d ", result[i]);
        }
        System.out.println();
        // result = make();
    }
}
