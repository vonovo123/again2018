package WEEK28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P11054 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] ia = new int[N];
        int[] ira = new int[N];// 앞에서 부터 증가
        int[] irar = new int[N];// 뒤에서부터 증가

        for (int i = 0; i < N; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
            ira[i] = 1;
            irar[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (ia[i] > ia[j]) {
                    if (ira[j] > max) {
                        max = ira[j];
                    }

                }
            }
            ira[i] += max;
        }

        for (int i = N - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < N; j++) {
                if (ia[i] > ia[j]) {
                    if (irar[j] > max) {
                        max = irar[j];
                    }

                }
            }
            irar[i] += max;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (ira[i] + irar[i] - 1 > max) {
                max = ira[i] + irar[i] - 1;
            }
        }
        System.out.println(max);
    }
}