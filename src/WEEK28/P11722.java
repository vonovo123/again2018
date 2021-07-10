package WEEK28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P11722 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] ia = new int[N];
        int[] ir = new int[N];
        int i = 0;
        for (String j : tmp) {
            ia[i] = Integer.parseInt(j);
            ir[i] = 1;
            i++;
        }

        for (int j = 1; j < N; j++) {
            int max = 0;
            for (int k = j - 1; k >= 0; k--) {
                if (ia[k] > ia[j]) {
                    if (max < ir[k]) {
                        max = ir[k];
                    }
                }
            }
            // System.out.println("max " + max);
            ir[j] += max;
        }
        int max = 0;
        for (int j = 0; j < N; j++) {
            if (max < ir[j]) {
                max = ir[j];
            }
        }
        System.out.println(max);

    }
}