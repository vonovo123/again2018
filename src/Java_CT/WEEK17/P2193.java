package WEEK17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2193 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        Long[] ia = new Long[91];
        ia[1] = 1L;
        ia[2] = 1L;
        for (int i = 3; i <= n; i++) {
            ia[i] = ia[i - 1] + ia[i - 2];
        }
        System.out.println(ia[n]);

    }

}