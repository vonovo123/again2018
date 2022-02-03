package WEEK20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P14889Bit {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] ia = new int[N][N];
        int min = 1000;
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ia[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = (1 << (N / 2)) - 1; i < (1 << N) - 1; i++) {
            int count = 0;
            // Vector<Integer> v = new Vector<Integer>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    count += 1;
                }
            }
            if (count == N / 2) {
                Vector<Integer> A = new Vector<Integer>();
                Vector<Integer> B = new Vector<Integer>();
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) != 0) {
                        A.add(j);
                    } else {
                        B.add(j);
                    }
                }
                int sumA = 0;
                int sumB = 0;
                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < count; k++) {
                        sumA += ia[A.get(j)][A.get(k)];
                        sumB += ia[B.get(j)][B.get(k)];
                    }
                }
                if (Math.abs(sumA - sumB) < min) {
                    min = Math.abs(sumA - sumB);
                }
            }
        }
        System.out.println(min);
    }
}
