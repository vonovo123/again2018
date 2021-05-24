package WEEK21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[N + 1];
        ia[1] = 1;
        Vector<Integer> r = new Vector<Integer>();
        r.add(1);
        for (int i = 2; i <= N; i++) {
            int t = (int) Math.sqrt(i);
            if (i - (t * t) == 0) {
                ia[i] = 1;
                r.add(t * t);
            } else {
                int min = 100000;
                for (int j = 0; j < r.size(); j++) {
                    int rr = r.get(j);
                    // System.out.println("rr: " + rr);
                    int val = ia[rr] + ia[i - rr];
                    // System.out.println("val: " + val);
                    if (min > val) {
                        min = val;
                        ia[i] = min;
                    }

                }

                // System.out.println();
                // System.out.println("i: " + i);
                // System.out.println("r: " + r);
                // System.out.println(ia[çr]);
                // System.out.println(ia[i - r]);
                // System.out.println(val);
                // System.out.println();

            }
        }
        System.out.println(ia[N]);
        /**
         * 1
         * 
         * 1 1
         * 
         * 1 1 1
         * 
         * 2
         * 
         * 
         * 1 1 2
         * 
         * 
         * 1 1 1 2
         * 
         * 1122
         * 
         * 22
         * 
         * 33
         * 
         * 
         */
    }
}