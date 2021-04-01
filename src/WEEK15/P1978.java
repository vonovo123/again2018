package WEEK15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1978 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        boolean[] arr = new boolean[1001];
        arr[1] = true;
        int s = 2;
        while (s <= 1000) {
            if (arr[s]) {
                s++;
                continue;
            } else {
                for (int i = 2; i <= 1000 / s; i++) {
                    arr[s * i] = true;
                }
                s++;
            }
        }
        int result = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (!arr[Integer.parseInt(tmp[i])])
                result++;
        }
        System.out.println(result);
    }
}
