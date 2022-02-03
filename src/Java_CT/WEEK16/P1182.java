package WEEK16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1182 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N, S, result;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        // 주어지는 수의 개수
        N = Integer.parseInt(stk.nextToken());
        // 합이되야하는 값
        S = Integer.parseInt(stk.nextToken());
        String[] sa = new String[N];
        sa = br.readLine().split(" ");
        // 주어진 수
        int[] ia = new int[N];
        for (int i = 0; i < N; i++) {
            ia[i] = Integer.parseInt(sa[i]);
        }
        // 비트마스크로 표현하기위해 제곱수 만들가
        Long pal = Math.round(Math.pow(2, N));
        //결과값
        result = 0;
        while (pal >= 2) {
            // N 자리 비트마스크 값 부터 1까지 탐색  
            String tmp = Long.toBinaryString(pal -= 1);
            int r = 0;
            //비트마스크 값 맨 오른쪽 자리부터 탐색
            for (int i = 0; i < tmp.length(); i++) {
                
                int val = tmp.charAt(tmp.length() - 1 - i) - 48;
                // 해당 자리가 1이면
                if (val == 1) {
                    //
                    r += ia[ia.length - 1 - i];
                }
                ;
            }
            if (r == S) {
                result++;
            }
            ;
        }
        System.out.println(result);
    }
}
