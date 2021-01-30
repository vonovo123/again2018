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
            fac[i] = (fac[i - 2] + fac[i - 1]) % 10007;
        }
        System.out.println(fac[N]);
    }
}