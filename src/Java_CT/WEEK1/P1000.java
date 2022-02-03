package WEEK1;

import java.io.BufferedReader;

public class P1000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int in, sum = 0;
        while ((in = br.read()) != 10) {
            if (in != 32)
                sum += (in - 48);
        }
        System.out.println(sum);
    }
}
