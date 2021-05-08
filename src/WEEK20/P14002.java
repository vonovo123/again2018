package WEEK20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P14002 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] ia = new int[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        Vector<Integer>[] result = new Vector[tmp.length];
        for (int i = 0; i < ia.length; i++) {
            result[i] = new Vector<Integer>();
        }

        result[0].add(ia[0]);
        for (int i = 1; i < ia.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ia[j] < ia[i]) {
                    if (result[i].size() < result[j].size()) {
                        Vector<Integer> tv = new Vector<Integer>();
                        for (int k = 0; k < result[j].size(); k++) {
                            tv.add(result[j].get(k));
                        }
                        result[i] = tv;
                    }
                }
            }
            // for (int k = 0; i < result[k].size(); k++) {
            // tmpV.add(result[j].get(k));
            // }
            result[i].add(ia[i]);
        }
        int max = 0;
        for (int i = 0; i < ia.length; i++) {
            if (result[max].size() < result[i].size()) {
                max = i;
            }
            // System.out.println(result[i].size());
        }
        System.out.println(result[max].size());
        for (int i = 0; i < result[max].size(); i++) {
            System.out.printf("%d ", result[max].get(i));
        }
        System.out.println();
    }
}
