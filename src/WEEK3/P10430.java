package WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class P10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inA = br.readLine().split(" ");
        int A, B, C;
        A = Integer.parseInt(inA[0]);
        B = Integer.parseInt(inA[1]);
        C = Integer.parseInt(inA[2]);
        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A*B)%C);
        System.out.println(((A%C)*(B%C))%C);

    }
}