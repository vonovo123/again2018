package WEEK4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] NA;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        NA = new int[N + 1];
        // 1이 1이 되는 최소횟수는 0
        NA[1] = 0;
        // 2에서 N까지 최소횟수 구하기
        for (int i = 2; i <= N; i++) {
            // 임시 최소횟수는 i - 1이 1이 되는 횟수에서 + 1( 1을 더해서 왔을때 )
            int tmp = NA[i - 1] + 1;
            // 2로 나누어 떨어질때
            if (i % 2 == 0) {
                // i를 2로 나눈 값이 1이 되는 횟수 + 1 ( 2를 곱해서 왔을때 ) 와 1을 더해서 왔을때 의 값중 작은값(최소값을 구해야하기때문)이
                // 최소횟수
                tmp = tmp > NA[i / 2] + 1 ? NA[i / 2] + 1 : tmp;
            }
            // 3으로 나누어 떨어질때
            if (i % 3 == 0) {
                // i를 3로 나눈 값이 1이 되는 횟수 + 1 ( 3를 곱해서 왔을때 ) 와 1을 더해서 왔을때 의 값중 작은값(최소값을 구해야하기때문)이
                // 최소횟수
                tmp = tmp > NA[i / 3] + 1 ? NA[i / 3] + 1 : tmp;
            }
            // 최소값 저장
            NA[i] = tmp;
        }
        // 출력
        System.out.println(NA[N]);
    }
}
