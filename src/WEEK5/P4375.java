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
        String in = "";

        while (!(in = br.readLine()).equals("")) {
            int iin = Integer.parseInt(in);
            if (iin == 1) {
                System.out.println(iin);
            } else {
                long t = 1;
                int ti = 2;
                //1로만 이루어진 수가 나누어 떨어질때까지 나머지에 1씩 더하면서 나눈다
                while ((t = ((t * 10) + 1) % iin) != 0) {
                    //자리수는 하나씩 더하면서 구한다
                    ti += 1;
                }
                System.out.println(ti);
            }

        }
    }
}
