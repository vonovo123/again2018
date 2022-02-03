package WEEK24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2255 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        long[][] arr = new long[K + 1][N + 1]; // K 개로 N을 만드는 수를 담는 배열
        for (int i = 0; i < N + 1; i++) {
            arr[1][i] = 1;// 숫자 1개로 N을 만드는 방법은 무조건 1개
        }

        for (int i = 2; i < K + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i - 1][j - k];
                    arr[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(arr[K][N]);
    }
}
