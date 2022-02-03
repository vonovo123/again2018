package WEEK11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P17425 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        // idx까지의 약수의 합을 담은 배열
        long[] faa = new long[1000001];
        faa[1] = 1;
        // 테스트케이스 수
        int t = Integer.parseInt(br.readLine());
        for (int i = 2; i <= 1000000; i++) {
            for (int j = 1; i * j <= 1000000; j++) {
                faa[i * j] += i;
            }
            faa[i] += faa[i - 1] + 1;
        }
        for (int i = 0; i < t; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(faa[N] + "\n");
        }

        bw.flush();

    }
}