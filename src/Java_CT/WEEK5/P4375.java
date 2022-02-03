package WEEK5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String in = null;
        // 입력값이 안들어올때까지 계속
        while ((in = br.readLine()) != null) {
            int iin = Integer.parseInt(in);

            // 1은 1로나누어지는 수이기 때문에 바로 출력
            if (iin == 1) {
                System.out.println(iin);
            } else {
                // 입력값이 1이 아니면
                long t = 1;
                int ti = 2;

                // 1로만 이루어진 수를 직접 만들면 나누는 중 시간초과
                // 이전수를 입력값으로 나눈 나머지에 10을 곱하고 1을 더한 후(1로만 이루어진 수 만들기) 계산한다.
                while ((t = ((t * 10 + 1) % iin)) != 0) {
                    System.out.println(t);
                    ti++;
                }
                System.out.println(ti);
            }
        }
    }
}
