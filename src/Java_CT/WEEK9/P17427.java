package WEEK9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17427 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        long sub = 0;
        for (int i = 1; i <= N; i++) {
            System.out.println("ans:" + ((N / i) * i));
            sub =  sub + ((N / i) * i);
        }

        System.out.println(sub);
    }  
}
