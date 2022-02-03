package WEEK2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //울림제미니스 점수
        String[] ul = br.readLine().split(" ");
        //스타트링크 점수
        String[] st = br.readLine().split(" ");
        int pUl = 0, pSt = 0;
        //역전패 여부
        String ans = "No";
        //이닝이 진행되는 동안 
        for (int i = 0; i < ul.length; i++) {
            //울림제미니스의 i 이닝까지의 점수가
            pUl += Integer.parseInt(ul[i]);
            //i - 1 이닝까지의 스타트링크 점수보다 크면 역전패 요건 성립
            if (pUl > pSt) {
                ans = "Yes";
                break;
            }
            //스타트링크 i 점수
            pSt += Integer.parseInt(st[i]);
        }
        //역전패 여부 출력
        System.out.println(ans);

    }
}
