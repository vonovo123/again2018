package WEEK2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //주어지는 문제의 길이
        int N = Integer.parseInt(br.readLine());
        //시험의 정답
        String CA = br.readLine();
        //각자의 ID
        String[] NA = { "Adrian", "Bruno", "Goran" };
        //각자의 답변방식
        String[] AA = { "ABC", "BABC", "CCAABB" };
        //답변방식별 맞춘 갯수를 담을 Array
        int[] CN = new int[3];
        //출력할 맞춘수의 최대값
        int max = 0;
       // 답변방식 모두 탐색
       for (int k = 0; k < AA.length; k++) {
           //답변방식
           String A = AA[k];
           int len = A.length();
           //답안에 답변방식을 직접비교
           // (N / len) 번 비교
           for (int i = 0; i < N / len; i++) {
               for (int j = 0; j < len; j++) {
                   if (CA.charAt(i * len + j) == A.charAt(j)) {
                       CN[k]++;
                   }
               }
           }
           //N/len하고 남은 답안 만큼 추가비교
           for (int i = N - (N % len); i < N; i++) {
               if (CA.charAt(i) == A.charAt(i % len))
                   CN[k]++;
           }
           //최대로 정답수를 구한다.
           if (max < CN[k])
               max = CN[k];
       }
        //출력
        System.out.println(max);
        for (int i = 0; i < CN.length; i++) {
            if(CN[i] == max) System.out.println(NA[i]);
        }
    }
}
