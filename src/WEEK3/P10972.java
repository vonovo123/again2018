package WEEK3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        String[] SA = br.readLine().split(" ");
        int[] NA = new int[N];
        for (int i = N; i >= 1; i--) {
            NA[N - i] = Integer.parseInt(SA[N - i]);
        }

            //배열의 끝에서 부터 시작
            int dsi = N - 1;
            //내림차순의 시작 부분(dsi)를 찾는다.
            for (int i = N - 2; i >= 0; i--) {
                if (NA[i] > NA[i + 1]) {
                    dsi = i;
                } else {
                    break;
                }
            }
            //전부 내림차순으로 정렬되어있으면
            if (dsi == 0) {
                System.out.println(-1);
                return;
            } else {
                for (int i = N - 1; i >= dsi; i--) {
                    if (NA[dsi - 1] < NA[i]) {
                        int tmp = NA[dsi - 1];
                        NA[dsi - 1] = NA[i];
                        NA[i] = tmp;
                        break;
                        }
                    }
                    for (int i = dsi; i <= N - 2; i++) {
                        for (int j = i + 1; j <= N - 1; j++) {
                            if (NA[i] > NA[j]) {
                                int tmp = NA[j];
                                NA[j] = NA[i];
                                NA[i] = tmp;
                            }
                        }
                    }
                }
            for (int i = 0; i < N; i++) {
                if (i == N - 1) {
                    System.out.printf("%d\n", NA[i]);  
                } else {
                    System.out.printf("%d ", NA[i]);
                }
                
            }    
    }
}
