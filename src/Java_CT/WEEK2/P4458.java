package WEEK2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4458 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 문자열 수
        String in; // 문자열
        char zi; // 각 글자
        for (int i = 0; i < N; i++) {
            in = br.readLine();
            zi = in.charAt(0);
            if (zi >= 'a' && zi <= 'z') { // 첫글자가 소문자이면
                zi = (char) (zi - 32);// 대문자로바꾼다
                System.out.println(String.valueOf(zi) + in.substring(1));// 바꾼 글자 + 나머지
            } else {
                System.out.println(in); // 대문자이면 그냥출력
            }

        }

    }
}
