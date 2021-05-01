package WEEK19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P11053 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[N];
        int[] iaa = new int[N];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < tmp.length; i++) {
            ia[i] = Integer.parseInt(tmp[i]);
        }
        iaa[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (ia[i] > ia[j]) { // 증가하는 수 일때
                    if (max < iaa[j]) {// 이전 위치에서 증가하는 수열 길이의 최댓값
                        max = iaa[j];
                    }
                }
            }
            iaa[i] = max + 1;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < iaa[i])
                max = iaa[i];
        }
        System.out.println(max);

    }
}