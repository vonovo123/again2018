package WEEK5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public class P4375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String in = "";
        BigInteger zero = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        BigInteger one = new BigInteger("1");
        while ((in = br.readLine()) != null) {
            BigInteger t = new BigInteger("1");
            int ti = 1;
            BigInteger iin = new BigInteger(in);
            while (t.remainder(iin).compareTo(zero) == 1) {
                t = t.multiply(ten).add(one);
                ti++;
            }
            System.out.println(ti);

        }
    }
}
