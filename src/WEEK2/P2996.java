package WEEK2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        String CA = br.readLine();
        String[] AA = { "ABC", "BABC", "CCAABB" };
        String[] NA = { "Adrian", "Bruno", "Goran" };
        int[] CN = new int[3];
        int max = 0;
       
        for (int k = 0; k < AA.length; k++) {
            String A = AA[k];
            for (int i = 0; i < N / A.length(); i++) {
                for (int j = 0; j < A.length(); j++) {
                    if (CA.charAt(i * A.length() + j) == A.charAt(j)) {
                        CN[k]++;
                    }
                }
            }
            for (int i = N - (N % A.length()); i < N; i++) {
                if (CA.charAt(i) == A.charAt(i % A.length()))
                    CN[k]++;
            }
            if (max < CN[k])
                max = CN[k];
        }
        System.out.println(max);
        for (int i = 0; i < CN.length; i++) {
            if(CN[i] == max) System.out.println(NA[i]);
        }
    }
}
