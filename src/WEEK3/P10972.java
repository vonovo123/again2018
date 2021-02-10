package WEEK3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stk;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 순열 길이 입력
        int N = Integer.parseInt(br.readLine());
        // 순열 입력
        stk = new StringTokenizer(br.readLine());
        // 입력 받은 순열
        int[] NA = new int[N];
        for (int i = N; i >= 1; i--) {
            NA[N - i] = Integer.parseInt(stk.nextToken());
        }

        // 내림차순의 시작부를 순열의 끝으로 잡는다.
        int dsi = N - 1;
        // 내림차순 시작부(dsi)를 찾는다.
        for (int i = N - 2; i >= 0; i--) {
            if (NA[i] > NA[i + 1]) {
                dsi = i;
            } else {
                break;
            }
        }
        // 내림차순 시작점이 0이면 (이미 내림차순으로 정렬되어있으면)
        if (dsi == 0) {
            // 조건대로 -1 출력
            System.out.println(-1);
            return;
            // 내림차순으로 정렬된 부분이 있으면
        } else {
            // 내림차순으로 정렬된 부분순열의 끝부분 부터 탐색하면서
            for (int i = N - 1; i >= dsi; i--) {
                // 부분순열 시작점에서 하나 왼쪽에 있는 값보다 큰값중 가장 작은값과 위치를 변경한다.
                if (NA[dsi - 1] < NA[i]) {
                    int tmp = NA[dsi - 1];
                    NA[dsi - 1] = NA[i];
                    NA[i] = tmp;
                    break;
                }
            }
            //다시 내림차순을 정렬
            for (int i = dsi; i <= N - 2; i++) {
                for (int j = i + 1; j <= N - 1; j++) {
                    if (NA[i] > NA[j]) {
                        int tmp = NA[j];
                        NA[j] = NA[i];
                        NA[i] = tmp;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                System.out.printf("%d\n", NA[i]);
            } else {
                System.out.printf("%d ", NA[i]);
            }

        }
    }
}
