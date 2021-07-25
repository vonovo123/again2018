package WEEK6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P10973 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 주어지는 순열의 길이
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        // 순열
        Integer[] a = new Integer[tmp.length];
        int index = 0;
        for (String i : tmp) {
            a[index] = Integer.parseInt(i);
            index++;
        }
        // 오름차순 시작점 찾기

        // 탐색부가 탐색부의 이전 요소보다 작으면 오름차순 시작점
        while (true) {
            Vector<Integer> v = new Vector<Integer>();
            int p = -1;
            for (int i = N - 1; i >= 1; i--) {
                // 오름차순으로 정렬해서 붙일 수 있도록 벡터에 담기
                v.add(a[i]);
                if (a[i] < a[i - 1]) {
                    p = i;
                    break;
                }
            }
            // 이미 오름차순으로 정렬되어있으면 이전 순열이 없음
            if (p == -1) {
                System.out.println(-1);
                break;
            } else {
                // 오름차순 시작점의 직전 부분
                int s = p - 1;
                // 오름차순 시작점부터 내림차순으로 정렬
                int c = 0; // 위치바꿀 부분
                int diff = a[s]; // 차이
                for (int i = 0; i < v.size(); i++) {
                    a[p + i] = v.get(i);
                    if (a[s] > a[p + i] && diff > a[s] - a[p + i]) {
                        diff = a[s] - a[p + i];
                        c = p + i;
                    }
                }
                // s와 s의 가장 가까운 작은 수와 자리바꿈
                int tmpp = a[c];
                a[c] = a[s];
                a[s] = tmpp;
                for (int i = 0; i < N; i++) {
                    System.out.printf("%d ", a[i]);
                }
                System.out.println();
            }
        }

    }
}