package WEEK21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14500 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N, M;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        int[][] one = new int[N][M];
        String[][] tmp = new String[N][M];
        for (int i = 0; i < N; i++) {
            tmp[i] = br.readLine().split(" ");
            for (int j = 0; j < tmp[i].length; j++) {
                one[i][j] = Integer.parseInt(tmp[i][j]);
            }
        }

        int[][] twoP = new int[N][M - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) {
                twoP[i][j] = one[i][j] + one[i][j + 1];
            }
        }
        int[][] twoH = new int[N - 1][M];
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                twoH[i][j] = one[i][j] + one[i + 1][j];
            }
        }

        int[][] threeP = new int[N][M - 2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 2; j++) {
                threeP[i][j] = one[i][j] + one[i][j + 1] + one[i][j + 2];
            }
        }
        int[][] threeH = new int[N - 2][M];
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M; j++) {
                threeH[i][j] = one[i][j] + one[i + 1][j] + one[i + 2][j];
            }
        }
        int max = 0;
        int val = 0;

        // ----
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 3; j++) {
                val = twoP[i][j] + twoP[i][j + 2];
                if (val > max) {
                    max = val;
                }
            }
        }

        // |
        // |
        // |
        // |

        for (int i = 0; i < N - 3; i++) {
            for (int j = 0; j < M; j++) {
                val = twoH[i][j] + twoH[i + 2][j];
                if (val > max) {
                    max = val;
                }
            }
        }

        // // ㅁ
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = twoH[i][j] + twoH[i][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        // |
        // |
        // |_
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = twoH[i][j] + twoP[i + 2][j];
                if (val > max) {
                    max = val;
                }
            }
        }

        // *|
        // *|
        // _|
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = twoH[i][j + 1] + twoP[i + 2][j];
                if (val > max) {
                    max = val;
                }
            }
        }

        // ---
        // |
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = twoH[i][j] + twoP[i][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        // ---
        // **|
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = twoP[i][j] + twoH[i][j + 2];
                if (val > max) {
                    max = val;
                }
            }
        }

        // -|
        // *|
        // *|
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = twoP[i][j] + twoH[i + 1][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        // |-
        // |
        // |
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = twoP[i][j] + twoH[i + 1][j];
                if (val > max) {
                    max = val;
                }
            }
        }

        // **|
        // ---
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = twoP[i + 1][j] + twoH[i][j + 2];
                if (val > max) {
                    max = val;
                }
            }
        }

        // |
        // ---
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = twoH[i][j] + twoP[i + 1][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        // |
        // ||
        // *|
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = twoH[i][j] + twoH[i + 1][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        // *|
        // ||
        // |
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = twoH[i][j + 1] + twoH[i + 1][j];
                if (val > max) {
                    max = val;
                }
            }
        }

        // *--
        // --
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = twoP[i][j + 1] + twoP[i + 1][j];
                if (val > max) {
                    max = val;
                }
            }
        }
        // --
        // *--
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = twoP[i][j] + twoP[i + 1][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        // ---
        // *|
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = threeP[i][j] + one[i + 1][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        // *|
        // ---
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                val = one[i][j + 1] + threeP[i + 1][j];
                if (val > max) {
                    max = val;
                }
            }
        }

        // *|
        // -|
        // *|
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = one[i + 1][j] + threeH[i][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }
        // |
        // |-
        // |
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                val = threeH[i][j] + one[i + 1][j + 1];
                if (val > max) {
                    max = val;
                }
            }
        }

        System.out.println(max);
    }
}
