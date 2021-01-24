package WEEK3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        int[] ia = new int[11];
        ia[1] = 1;
        ia[2] = 2;
        ia[3] = 4;
        for (int i = 4; i <= 10; i++) {
            ia[i] = ia[i - 1] + ia[i - 2] + ia[i - 3];
        }
        for (int i = 0; i < T; i++) {
                System.out.println(ia[Integer.parseInt(br.readLine())]);
        }

    }
}
