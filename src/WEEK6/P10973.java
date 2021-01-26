package WEEK6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class P10973 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        Integer[] a = new Integer[tmp.length];
        int index = 0;
        for (String i : tmp) {
            a[index] = Integer.parseInt(i);
            index++;
        }
        int e = N - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (a[i] <= a[e])
                e = i;
            else {
                break;
            }
        }
        if (e == 0) {
            System.out.println(-1);
        } else {
            int s = e - 1;
            Arrays.sort(a, e, N, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    // TODO Auto-generated method stub
                    return o2.compareTo(o1);
                }
            });

            for (int i = e; i < N; i++) {
                if (a[i] < a[s]) {
                    int temp = a[i];
                    a[i] = a[s];
                    a[s] = temp;
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                if (i == N - 1) {
                    System.out.println(a[i]);
                } else {
                    System.out.printf("%d ", a[i]);
                }
            }

    }
}
}