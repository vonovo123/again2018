package WEEK28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P11055 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tmp[i]);
        }
        int[] result = new int[N];
        result[0] = A[0];
        for (int i = 1; i < N; i++) {
            int v = A[i];
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (v > A[j]) {
                    if (max < result[j]) {
                        max = result[j];
                    }
                }
            }
            result[i] = v + max;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            // System.out.printf("%d ", result[i]);
            if (max < result[i]) {
                max = result[i];
            }
        }
        System.out.println(max);
    }
}