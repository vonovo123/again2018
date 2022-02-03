package WEEK13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2609 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A, B;

    static int GCD(int A, int B) { // 최대공약수
        int r = A % B;
        while (r != 0) {
            A = B;
            B = r;
            r = A % B;
        }
        return B;
    }

    static int LCM(int A, int B) { // 최소공배수

        return (A / GCD(A, B)) * (B / GCD(A, B) * GCD(A, B));
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());

        System.out.println(GCD(A, B));
        System.out.println(LCM(A, B));

    }
}
