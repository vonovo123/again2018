package WEEK12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14890 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int L;
    static int count;

    static void cal(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int[] road = new int[N];
            int[] croad = new int[N];
            for (int j = 0; j < N; j++) {
                road[j] = arr[i][j];
                croad[j] = arr[i][j];
            }
            for (int j = 1; j < road.length; j++) {
                int h = road[j] - road[j - 1];
                if (h < 0) { // 탐색방향이 더 낮으면
                    if (h == -1) { // 높이 차이가 1 이면 경사로를 놓을수 있는지 탐색
                        if (N - j < L) {// 경사로를 놓을 길이가 안되면.
                            break;
                        } else {// 길이는 되는데 겹치는지 여부 확인
                            int height = road[j];
                            int flag = 1;

                            for (int k = j; k < j + L; k++) {
                                if (road[k] != height) {// 경사로를 놓을곳이 평지가 아니면ㄱ
                                    flag = 0;
                                    break;
                                }
                                // 이미 경사로가 놓여있으면
                                if (croad[k] == 0) {
                                    flag = 0;
                                    break;
                                }

                            }
                            if (flag == 0) {
                                break;
                            } else {
                                for (int k = j; k < j + L; k++) {
                                    croad[k] = 0;
                                }
                            }

                        }
                    } else {
                        break;
                    }
                } else if (h > 0) { // 탐색방향이 더 높으면
                    if (h == 1) { // 높이 차이가 1 이면 경사로를 놓을수 있는지 탐색
                        if (j - L < 0) {// 경사로를 놓을 길이가 안되면.
                            break;
                        } else {// 길이는 되는데 겹치는지 여부 확인
                            int height = road[j - 1];
                            int flag = 1;
                            for (int k = j - 1; k >= j - L; k--) {
                                if (road[k] != height) {// 경사로를 놓을곳이 평지가 아니면ㄱ
                                    flag = 0;
                                    break;
                                }
                                // 이미 경사로가 놓여있으면
                                if (croad[k] == 0) {
                                    flag = 0;
                                    break;
                                }

                            }
                            if (flag == 0) {
                                break;
                            } else {
                                for (int k = j - 1; k >= j - L; k--) {
                                    croad[k] = 0;
                                }
                            }

                        }
                    } else {
                        break;
                    }
                }
                if (j == road.length - 1) {
                    count += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        String[][] temp = new String[N][N];
        int[][] arr = new int[N][N];
        int[][] carr = new int[N][N];

        count = 0;
        for (int i = 0; i < N; i++) {
            temp[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(temp[i][j]);
            }
        }
        cal(arr);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                carr[i][j] = arr[j][N - 1 - i];
            }
        }

        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < N; j++) {
        // System.out.printf("%d ", carr[i][j]);
        // }
        // System.out.println();
        // }

        cal(carr);
        System.out.println(count);
    }
}
