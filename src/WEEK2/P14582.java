package WEEK2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ul = br.readLine().split(" ");
        String[] st = br.readLine().split(" ");
        int pUl = 0, pSt = 0;
        String ans = "No";
        for (int i = 0; i < ul.length; i++) {
            pUl += Integer.parseInt(ul[i]);
            if (pUl > pSt) {
                ans = "Yes";
                break;
            }
            pSt += Integer.parseInt(st[i]);
 
        }

        System.out.println(ans);

    }
}
