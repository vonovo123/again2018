package WEEK4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P16935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, R;
    static int[][] inA;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static void command(String in) {
        // 이전상태를 저장하기위한 temp 배열
        int[][] temp = new int[inA.length][inA[0].length];
        // 매번 직전상태의 배열 복사한다.
        for (int i = 0; i < inA.length; i++) {
            for (int j = 0; j < inA[0].length; j++) {
                temp[i][j] = inA[i][j];

            }
        }

        if ("1".equals(in)) {// 1: 상하반전
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    // i번째 행의 모든열에 tmp의 모든행의 마지막열(length - 1)위치 - i 번째 열의 요소를 넣는다.
                    inA[i][j] = temp[temp.length - 1 - i][j];
                }
            }
        } else if ("2".equals(in)) {// 2: 좌우반전
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    // 각행의 j 번째 요소에 temp의 각행 마지막열(length - 1)위치 - j 번째 요소를 넣는다.
                    inA[i][j] = temp[i][temp[0].length - 1 - j];
                }
            }
        } else if ("3".equals(in)) { // 오른쪽으로 90도
            // 행/열의 길이가 다른 배열의 경우 90도로 돌렸을때 행/열의 길이가 바뀌기때문에 inA를 새로 생성해준다.
            inA = new int[inA[0].length][inA.length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    inA[j][temp.length - 1 - i] = temp[i][j];
                }
            }
        } else if ("4".equals(in)) { // 왼쪽으로 90도
            // 행/열의 길이가 다른 배열의 경우 90도로 돌렸을때 행/열의 길이가 바뀌기때문에 inA를 새로 생성해준다.
            inA = new int[inA[0].length][inA.length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    inA[temp[0].length - j - 1][i] = temp[i][j];
                }
            }
        } else if ("5".equals(in)) {// 4개의 단면을 각각 시계방향으로 이동
            // 행/열의 길이가 다른 배열의 경우 분면을 시계방향으로 돌렸을때 행/열의 길이가 바뀌기때문에 inA를 새로 생성해준다.
            int NP = inA.length / 2;
            int MP = inA[0].length / 2;

            for (int i = 0; i < inA.length; i++) {
                if (i < NP) {
                    for (int j = 0; j < inA[0].length; j++) {
                        // 4 - > 1
                        if (j < MP) {
                            inA[i][j] = temp[i + NP][j];
                            // 2
                        } else {
                            inA[i][j] = temp[i][j - MP];
                        }
                    }
                } else {
                    for (int j = 0; j < inA[0].length; j++) {
                        // 4
                        if (j < MP) {
                            inA[i][j] = temp[i][j + MP];
                            // 3
                        } else {
                            inA[i][j] = temp[i - NP][j];
                        }
                    }
                }

            }
        } else if ("6".equals(in)) {// 4개의 단면을 각각 반시계방향으로 이동
            int NP = inA.length / 2;
            int MP = inA[0].length / 2;

            for (int i = 0; i < inA.length; i++) {
                if (i < NP) {
                    for (int j = 0; j < inA[0].length; j++) {
                        // 1
                        if (j < MP) {
                            inA[i][j] = temp[i][j + MP];
                            // 2
                        } else {
                            inA[i][j] = temp[i + NP][j];
                        }
                    }
                } else {
                    for (int j = 0; j < inA[0].length; j++) {
                        // 4
                        if (j < MP) {
                            inA[i][j] = temp[i - NP][j];
                            // 3
                        } else {
                            inA[i][j] = temp[i][j - MP];
                        }
                    }
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        // 배열의 크기 N, M
        N = stoi(in[0]);
        M = stoi(in[1]);
        // 수행해야하는 연산의 수
        R = stoi(in[2]);
        // 이차원 배열
        inA = new int[N][M];
        // 입력
        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                inA[i][j] = stoi(in[j]);
            }
        }
        // 수행해야하는 커맨드 입력
        in = br.readLine().split(" ");
        for (int i = 0; i < in.length; i++) {
            command(in[i]);
        }

        for (int i = 0; i < inA.length; i++) {
            for (int j = 0; j < inA[0].length; j++) {
                if (j != inA[0].length - 1)
                    System.out.printf("%d ", inA[i][j]);
                else
                    System.out.println(inA[i][j]);
            }
        }
    }
}
