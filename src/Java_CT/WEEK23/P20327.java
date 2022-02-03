package WEEK23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P20327 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, R; // N : 배열 크기 2^N R :적용연산 수
    static int[][] A; // input array

    static void cal(int k, int l) {// k command, l 단계
        if (k != 5 && k != 6 && k != 7 && k != 8) {
            int length = (int) Math.pow(2, l);// 부분집합의 길이
            int y = 0;
            int size = (int) Math.pow(2, N);
            while (y <= size - length) {
                int x = 0;
                while (x <= size - length) {
                    if (k == 1) {
                        for (int i = 0; i < length / 2; i++) {
                            for (int j = 0; j < length; j++) {
                                int tmp = A[(y + length - 1) - i][x + j];
                                A[(y + length - 1) - i][x + j] = A[y + i][x + j];
                                A[y + i][x + j] = tmp;
                            }
                        }
                    } else if (k == 2) {
                        for (int i = 0; i < length; i++) {
                            for (int j = 0; j < length / 2; j++) {
                                int tmp = A[y + i][(x + length - 1) - j];
                                A[y + i][(x + length - 1) - j] = A[y + i][x + j];
                                A[y + i][x + j] = tmp;
                            }
                        }
                    } else if (k == 3 || k == 4) {

                        for (int i = 0; i <= l; i++) {// 시작점 끝나는점 0 1 2
                            int innerLength = length - 2 * i; // 깊이에 따른 부분배열 내부 배열의 길이
                            int innerYs = y + i; // 깊이에 따른 부분배열의 y시작점
                            int innerYe = y + i + innerLength - 1; // 깊이에 따른 부분배열의 y 끝점
                            int innerXs = x + i; // 깊이에 따른 부분배열의 x시작점
                            int innerXe = x + i + innerLength - 1; // 깊이에 따른 부분배열의 x 시작점
                            int[] tmp = new int[innerLength]; // 임시로 담을 배열

                            if (k == 3) {
                                for (int j = 0; j < innerLength; j++) {
                                    // 깊이에 따른 부분배열의 맨윗행 끝에서부터 복사
                                    tmp[j] = A[innerYs][innerXe - j];
                                }
                                for (int j = 0; j < innerLength; j++) {
                                    // 깊이에 따른 부분배열의 맨오른쪽열에 맨 윗행 끝에서부터 복사
                                    A[innerYs][innerXe - j] = A[innerYs + j][innerXs];
                                }
                                for (int j = 0; j < innerLength; j++) {
                                    A[innerYs + j][innerXs] = A[innerYe][innerXs + j];
                                }

                                for (int j = 0; j < innerLength; j++) {
                                    A[innerYe][innerXs + j] = A[innerYe - j][innerXe];
                                }

                                for (int j = 0; j < innerLength; j++) {
                                    A[innerYe - j][innerXe] = tmp[j];
                                }
                            } else {
                                for (int j = 0; j < innerLength; j++) {
                                    // 깊이에 따른 부분배열의 맨윗행 끝에서부터 복사
                                    tmp[j] = A[innerYs][innerXs + j];
                                }
                                for (int j = 0; j < innerLength; j++) { // 부분배열에서 맨 윗줄 첫요소와 끝요소
                                    A[innerYs][innerXs + j] = A[innerYs + j][innerXe];
                                }
                                for (int j = 0; j < innerLength; j++) {
                                    A[innerYs + j][innerXe] = A[innerYe][innerXe - j];
                                }

                                for (int j = 0; j < innerLength; j++) {
                                    A[innerYe][innerXe - j] = A[innerYe - j][innerXs];
                                }
                                for (int j = 0; j < innerLength; j++) {
                                    A[innerYe - j][innerXs] = tmp[j];
                                }
                            }
                        }
                    }
                    x += length;
                }
                y += length;

            }

        } else {
            if (k == 5) {
                cal(1, N);
                cal(1, l);
            } else if (k == 6) {
                cal(2, N);
                cal(2, l);
            } else if (k == 7) {
                cal(3, N);
                cal(4, l);
            } else if (k == 8) {
                cal(4, N);
                cal(3, l);

            }
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        A = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
        for (int i = 0; i < A.length; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                A[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < R; i++) {
            String cmd = br.readLine();
            StringTokenizer tstk = new StringTokenizer(cmd);
            int kk = Integer.parseInt(tstk.nextToken());
            int ll = Integer.parseInt(tstk.nextToken());
            cal(kk, ll);

            // for (int j = 0; j < A.length; j++) {
            // for (int k = 0; k < A[0].length; k++) {
            // System.out.printf("%d ", A[j][k]);
            // }
            // System.out.println();
            // }
            // System.out.println();
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j != A[0].length - 1) {
                    System.out.printf("%d ", A[i][j]);
                } else {
                    System.out.printf("%d", A[i][j]);
                }

            }
            System.out.println();
        }
    }
}
