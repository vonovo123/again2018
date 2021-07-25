package WEEK30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

class P6603 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        while (flag) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            if (N == 0) {
                break;
            } else {
                int[] ia = new int[N];
                int[] a = new int[N];
                for (int i = 0; i < N; i++) {
                    ia[i] = Integer.parseInt(stk.nextToken());
                    if (i > 5)
                        a[i] = 1;
                }
                for (int i = 0; i < N; i++) {
                    if (a[i] == 0) {
                        System.out.printf("%d ", ia[i]);
                    }
                }
                System.out.println();
                while (true) {
                    int p = -1;
                    Vector<Integer> v = new Vector<Integer>();
                    // 내림차순 시작부(dsi)를 찾는다.
                    // 직전부가 탐색부 보다 작으면 탐색부는 내림차순 시작점
                    for (int i = N - 1; i >= 1; i--) {
                        v.add(a[i]);
                        if (a[i - 1] < a[i]) {
                            p = i;
                            break;
                        }
                    }
                    ;
                    // 내림차순 시작점이 0이면 (이미 내림차순으로 정렬되어있으면)
                    if (p == -1) {
                        // 조건대로 -1 출력
                        break;
                    } else { // 내림차순으로 정렬된 부분이 있으면
                        int s = p - 1;
                        // 내림차순 시작점부터 오름차순으로 정렬
                        for (int i = 0; i < v.size(); i++) {
                            a[p + i] = v.get(i);
                        }
                        // System.out.println("s:" + s);

                        // s와 s의 가장 가까운 큰 수와 자리바꿈
                        for (int i = 0; i < v.size(); i++) {
                            // System.out.println("p + i:" + a[p + i]);

                            if (a[s] < a[p + i]) {
                                int tmpp = a[p + i];
                                a[p + i] = a[s];
                                a[s] = tmpp;
                                break;
                            }
                        }

                        for (int i = 0; i < N; i++) {
                            if (a[i] == 0) {
                                System.out.printf("%d ", ia[i]);
                            }
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
    }
}