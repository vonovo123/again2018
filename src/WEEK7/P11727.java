package WEEK7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11727 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[1001];
        A[1] = 1;
        for (int i = 2; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = (A[i - 1] * 2 + 1) % 10007;
            } else {
                A[i] = (A[i - 1] * 2 - 1) % 10007;
            }
        }

        System.out.println(A[N]);
    }
}
