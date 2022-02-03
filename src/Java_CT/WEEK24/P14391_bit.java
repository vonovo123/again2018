package WEEK24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P14391_bit {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        // 세로크기
        N = Integer.parseInt(tmp[0]);
        // 가로크기
        M = Integer.parseInt(tmp[1]);
        // 길이가 N / M 인 직사각형
        String[][] arr = new String[N][M];
        int MAX = 0;

        for (int i = 0; i < N; i++) {
            String tmpS = br.readLine();
            // 초기 최대값은 모두 한칸으로 잘랐을때의 값
            MAX += Integer.parseInt(tmpS);
            arr[i] = tmpS.split("");
        }
        int t = N * M;
        for (int i = 0; i < Math.pow(2, t); i++) {
            int tResult = 0;
            String[] biArr = new String[t];
            int[] visited = new int[t];
            for (int j = 0; j < biArr.length; j++) {
                biArr[j] = "0";
            }
            String[] biTmp = Integer.toBinaryString(i).split("");

            for (int j = 0; j < biTmp.length; j++) {
                biArr[(biArr.length - 1) - j] = biTmp[(biTmp.length - 1) - j];
            }
            // for (int j = 0; j < biArr.length; j++) {
            // System.out.printf("%s ", biArr[j]);
            // }
            // System.out.println();
            for (int j = 0; j < biArr.length; j++) {
                if (visited[j] == 0) {
                    if ("1".equals(biArr[j])) {// 세로
                        if (!"0".equals(arr[j / M][j % M])) {
                            // 첫숫자
                            String result = arr[j / M][j % M];
                            int tt = j;
                            visited[tt] = 1;
                            while ((tt = tt + M) < t) {
                                if (!"0".equals(biArr[tt])) {
                                    visited[tt] = 1;
                                    result += arr[tt / M][tt % M];
                                } else {
                                    break;
                                }
                            }
                            // System.out.println("1: " + result);
                            tResult += Integer.parseInt(result);
                        }
                    } else {
                        if (!"0".equals(arr[j / M][j % M])) {
                            // 첫숫자
                            String result = arr[j / M][j % M];
                            int tt = j;
                            int idx = 1;
                            visited[tt] = 1;
                            while ((tt % M + idx) < M) {
                                if ("0".equals(biArr[tt + idx])) {
                                    result += arr[(tt + idx) / M][(tt + idx) % M];
                                    visited[tt + idx] = 1;
                                    idx += 1;
                                } else {
                                    break;
                                }

                            }
                            // System.out.println("0: " + result);
                            tResult += Integer.parseInt(result);
                        }
                    }
                }
            }
            if (MAX < tResult) {
                MAX = tResult;
            }
        }
        System.out.println(MAX);
    }
}
