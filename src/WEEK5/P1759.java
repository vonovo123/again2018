package WEEK5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, C;
    static String[] inA;
    static int[] isPossible;
    static String[] result;
    static String mo;
    static String ja;
    static int parseInt(String in) {
        return Integer.parseInt(in);
    }

    static int checkMo(String[] result) {
        for (int i = 0; i < result.length; i++) {
            if (mo.indexOf(result[i]) != -1) {
                return 1;
            }
        }
        return 0;
    }

    static int checkJa(String[] result) {
        int output = 0;
        for (int i = 0; i < result.length; i++) {
            if (ja.indexOf(result[i]) != -1) {
                output++;
            }
            if (output == 2)
                return 1;
        }
        return -1;
    }
    static void bfs(int d) {
        if (d == L) {
            if (checkMo(result) == 1) {
                if ( checkJa(result ) == 1 ) {
                    for (int i = 0; i < d; i++) {
                        System.out.print(result[i]);
                    }
                    System.out.println(); 
                }
 
            }
            return;
        }
        
        for (int i = 0; i < C; i++) {
            if (isPossible[i] != 1) {
                isPossible[i] = 1;
                if (d == 0) {
                    result[d] = inA[i];
                    bfs(d + 1);
                } else {
                    if ((int) result[d - 1].charAt(0) < (int) inA[i].charAt(0)) {
                        result[d] = inA[i];
                        bfs(d + 1);
                    }
                }
                isPossible[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        L = parseInt(in[0]);
        C = parseInt(in[1]);
        isPossible = new int[C];
        inA = br.readLine().split(" ");
        Arrays.sort(inA);
        result = new String[L];
        mo = "aeiou";
        ja = "bcdfghjklmnpqrstvwxyz";
        bfs(0);
    }
    
}
