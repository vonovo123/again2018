package WEEK15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10844 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[10];
        for (int i = 1; i < 10; i++) {
            ia[i] = 1;
        }
        if (N == 1) {
            System.out.println(9);
        } else {
            for (int i = 0; i < N - 1; i++) {
                int[] tia = new int[10];
                Long result = 0L;
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        tia[j + 1] += (ia[j] % 1000000000);
                    } else if (j == 9) {
                        tia[j - 1] += (ia[j] % 1000000000);
                    } else {
                        tia[j + 1] += (ia[j] % 1000000000);
                        tia[j - 1] += (ia[j] % 1000000000);
                    }
                }

                System.arraycopy(tia, 0, ia, 0, tia.length);
                for (int j = 0; j < ia.length; j++) {
                    result += (ia[j] % 1000000000);
                }
                if (i == N - 2) {
                    System.out.println(result % 1000000000);
                    break;
                }

            }
        }

        // Long result = 0L;

        // System.out.println();
        // System.out.println(result);
    }
}
