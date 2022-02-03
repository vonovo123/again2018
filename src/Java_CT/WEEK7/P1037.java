package WEEK7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1037 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int NC = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] NA = new int[NC];
        for (int i = 0; i < tmp.length; i++) {
            NA[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(NA);
        System.out.println(NA[0] * NA[NA.length - 1]);

    }
}