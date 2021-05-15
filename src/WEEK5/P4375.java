package WEEK5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class P4375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String in = "";
        // Input이 안들어올때 까지 반복
        while ((in = br.readLine()) != null) {
            int n = Integer.parseInt(in);
            if (n == 1) {
                System.out.println(1);
            } else {
                int cnt = 2;
                long div = 1;
                while ((div = ((div * 10) % n + 1) % n) == 1) {
                    System.out.println(div);
                    cnt += 1;
                }
            }
        }
    }
}
