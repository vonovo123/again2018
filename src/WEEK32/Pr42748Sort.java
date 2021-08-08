package WEEK32;

import java.util.*;

public class Main {
    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int s = commands[i][0] - 1;
            int e = commands[i][1];
            int idx = commands[i][2] - 1;
            int[] tmp = Arrays.copyOfRange(array, s, e);
            sort(tmp, 0, tmp.length - 1);
            answer[i] = tmp[idx];
        }

        return answer;
    }

    static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = left;
        int l = left + 1;
        int h = right;

        while (l <= h) {
            // low와 high가 교차 할때까지
            while (l <= right && a[p] >= a[l]) { // p 인덱스 보다 큰 l인덱스 값 찾기
                l++;
            }
            while (h > left && a[p] <= a[h]) { // p 인덱스 보다 작은 h 인덱스 찾기
                h--;
            }
            // 엇갈렸으면
            if (l > h) {
                int tmp = a[h];
                a[h] = a[p];
                a[p] = tmp;
            } else { // 엇갈리지않았으면
                int tmp = a[l];
                a[l] = a[h];
                a[h] = tmp;
            }
            // System.out.println();
            // break;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
        // 교차했으면
        sort(a, left, h - 1);
        sort(a, h + 1, right);

    }

    public static void main(String[] args) {
        // int[] answer = solution(new int[] { 1, 5, 2, 6, 3, 7, 4 },
        // new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } });
        // for (int i = 0; i < answer.length; i++) {
        // System.out.println(answer[i]);
        // }
        int[] test = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // int[] test = new int[] { 1, 5, 2, 6, 3, 7, 4 };
        for (int i = 0; i < test.length; i++) {
            System.out.printf("%d ", test[i]);
        }
        System.out.println();
        sort(test, 0, test.length - 1);

        // 9 8 7 6 5 4 3 2 1
        // 1 8 7 6 5 4 3 2 9
    }
}
