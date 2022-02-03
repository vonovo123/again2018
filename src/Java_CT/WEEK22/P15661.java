package WEEK22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P15661 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] ia = new int[N][N];
        int min = 1000;
        for (int i = 0; i < ia.length; i++) {
            String[] tmp = new String[N];

            tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                ia[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        for (int i = (1 << N - 1); i < (1 << N) - 1; i++) {
            // System.out.println(Integer.toBinaryString(i));
            Vector<Integer> A = new Vector<Integer>();
            Vector<Integer> B = new Vector<Integer>();
            int sumA = 0;
            int sumB = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    if (A.size() != 0) {
                        for (int k = 0; k < A.size(); k++) {
                            sumA += ia[A.get(k)][j];
                            sumA += ia[j][A.get(k)];

                        }
                    }
                    A.add(j);
                } else {
                    if (B.size() != 0) {
                        for (int k = 0; k < B.size(); k++) {
                            sumB += ia[B.get(k)][j];
                            sumB += ia[j][B.get(k)];

                        }
                    }
                    B.add(j);
                }
            }

            // for (int j = 0; j < A.size(); j++) {
            // for (int k = 0; k < A.size(); k++) {
            // sumA += ia[A.get(j)][A.get(k)];
            // }
            // }
            // for (int j = 0; j < B.size(); j++) {
            // for (int k = 0; k < B.size(); k++) {
            // sumB += ia[B.get(j)][B.get(k)];
            // }
            // }
            if (Math.abs(sumA - sumB) < min) {
                min = Math.abs(sumA - sumB);
            }
        }
        System.out.println(min);
    }
}
