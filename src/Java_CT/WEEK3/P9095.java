package WEEK3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        //테스트 케이스 n의 개수
        int T = Integer.parseInt(br.readLine());
        //1, 2, 3으로 n을 만들 수 있는 경우의 수를 담는 배열, 크기는 n의 최대값인 10까지 담을 수 있도록 11
        int[] ia = new int[11];
        //1을 만들 수 있는 경우는 1가지 1
        ia[1] = 1;
        //2를 만들 수 있는 경우는 2가지 1 + 1, 2
        ia[2] = 2;
        //3을 만들 수 있는 경우는 4가지 1+1+1, 1+2, 2+1, 3
        ia[3] = 4;
        //4 이상의 값 n을 만들 수 있는 경우는 n - 1, n - 2, n -3 을 만들 수 있는 경우의 수의 합이다.
        for (int i = 4; i <= 10; i++) {
            ia[i] = ia[i - 1] + ia[i - 2] + ia[i - 3];
        }
        for (int i = 0; i < T; i++) {
                System.out.println(ia[Integer.parseInt(br.readLine())]);
        }

    }
}
