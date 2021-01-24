package WEEK3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P2309_BITMASKING {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] inA = new int[9];
        for (int i = 0; i < inA.length; i++) {
            inA[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inA);
        for (int i = 0; i < (1 << 9); i++) {
            if (Integer.bitCount(i) == 7) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    if ((i & (1 << j)) > 0) {
                        sum += inA[j];
                    }
                }
                if (sum == 100) {
                    for (int j = 0; j < 9; j++) {
                        if ((i & (1 << j)) > 0) {
                            System.out.println(inA[j]);
                        }
                    }
                    break; 
                }

            }

            
        }

    }
}
