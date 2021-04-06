package WEEK3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int in = 0;

    static void add(int x) {
        in = in | 1 << x - 1; // 0 과 1을 x-1 비트만큼 왼쪽으로 민 값의 or 연산값
    }

    static void remove(int x) {
        in = in & ~(1 << x - 1); // 1을 x-1 비트만큼 왼쪽으로 민 값(10, 100, 1000 등)의 ~연산(0,1 반전)한 값의 and 연산, 왼쪽으로 밀린 위치는
                                 // and 연산 후 0이 된다.
    }

    static int check(int x) {
        if ((in & (1 << x - 1)) > 0) { // in의 값에서 해당위치(1을 x-1 만큼 왼쪽으로 민 값의 1 위치)가 1이면 1을 아니면 0을 반환한다.
            return 1;
        }
        return 0;
    }

    static void toggle(int x) { // x -1 위치의 비트 값을 반전한다.
        if (check(x) == 1) {// 있으면{
            remove(x);
        } else {
            add(x);
        }
    }

    static void all() { // 모든 자리를 1로 바꾼다.
        for (int i = 0; i < 20; i++) {
            in = in | 1 << i;
        }
    }

    static void empty() { // 0과 and 연산을 통해 모든 자리를 0으로 바꾼다.
        in = in & 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 수행해야하는 연산의 수
        int M = Integer.parseInt(br.readLine());
        // 연산과 숫자 담는 배열
        String[] cmdA;
        // 연산
        String cmd;
        int x = 0;
        for (int i = 0; i < M; i++) {
            cmdA = br.readLine().split(" ");
            cmd = cmdA[0];
            if (cmdA.length == 2) {// 숫자가 주어지는 연산이면
                x = Integer.parseInt(cmdA[1]);
            }

            if ("add".equals(cmd)) {
                add(x);
            } else if ("remove".equals(cmd)) {
                remove(x);
            } else if ("check".equals(cmd)) {
                bw.write(check(x) + "\n");
            } else if ("toggle".equals(cmd)) {
                toggle(x);
            } else if ("all".equals(cmd)) {
                all();
            } else {
                empty();
            }
        }
        bw.flush();
    }
}
