package WEEK6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11726 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] fac;

    public static void main(String[] args) throws NumberFormatException, IOException {
        fac = new long[1001];
        fac[1] = 1;
        fac[2] = 2;
        int N = Integer.parseInt(br.readLine());
        for (int i = 3; i <= N; i++) {
            // i-3은 안되는 이유 : 3은 2와 1로 만들수 있기 때문에 -2까지만한다
            fac[i] = (fac[i - 1] = fac[i - 2]) % 10007;
        }
        System.out.println(fac[N]);
    }
}