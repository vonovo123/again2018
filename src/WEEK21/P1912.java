package WEEK21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P1912 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] ia = new int[tmp.length];
        int[] iia = new int[tmp.length];

        int max = -100000000;
        for (int i = 0; i < ia.length; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
            iia[i] = Integer.parseInt(tmp[i]);
            if (max < ia[i])
                max = ia[i];
        }

        for (int i = 1; i < n; i++) {
            if (iia[i - 1] + ia[i] < 0) {
                iia[i] = 0;
            } else {
                iia[i] = iia[i - 1] + ia[i];
                if (iia[i] > max)
                    max = iia[i];
            }
        }
        // for (int i = 0; i < n; i++) {
        // System.out.printf("%d ", iia[i]);
        // }
        System.out.println(max);
    }
}