package WEEK17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P1107 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] ma = new int[10];
        if (M != 0) {
            String[] tmp = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                ma[Integer.parseInt(tmp[i])] = 1; // 고장
            }
        }
        int s = 100;// 시작점
        int cn = N; // 주어진 채널
        int size = 1; // 주어진 채널의 최소 크기
        while ((cn /= 10) != 0) {
            size++;
        } // 주어진 채널의 크기
        int gap = 0;
        if (N >= s) { // 100번 보다 위일때
            gap = N - s;
        } else {// 100번보다 아래일때
            gap = s - N;
        }

        if (gap < size) { // 직접입력하는 것 보다 방향키로 이동하는게 빠르면
            System.out.println(gap);
            return;
        }

        int result = gap; // 최대값은 방향키로 직접이동할때
        int q = N; // 주어진 채널보다 위로 탐색
        while (q - N + size < gap) {// 탐색 채널과 목표채널사이의 거리
            int ct = q;
            boolean flag = true;
            Vector<Integer> v = new Vector<Integer>();
            v.add(ct % 10);
            while ((ct /= 10) != 0) {
                v.add(ct % 10);
            }
            for (int i = v.size() - 1; i >= 0; i--) {
                if (ma[v.get(i)] == 1) {
                    flag = false;
                } // 가야하는 채널의 숫자중 고장난 숫자가 있는지 판단
            }
            if (flag) {// 숫자패드로 입력할 수 있으면
                int pResult = 0;
                pResult += v.size();// 주어진 채널과 가장 가까운 채널을 누르고
                pResult += q - N;// 주어진 채널만큼 - 방향키로 이동
                result = pResult;
                break;
            } else {
                q += 1;
            }
        }

        int nq = N;
        while (nq >= 0) {
            int ct = nq;
            boolean flag = true;
            Vector<Integer> v = new Vector<Integer>();
            v.add(ct % 10);
            while ((ct /= 10) != 0) {
                v.add(ct % 10);
            }
            for (int i = v.size() - 1; i >= 0; i--) {
                if (ma[v.get(i)] == 1) {
                    flag = false;
                } // 가야하는 채널의 숫자중 고장난 숫자가 있는지 판단
            }
            if (flag) {// 숫자패드로 입력할 수 있으면
                int nResult = 0;
                nResult += v.size();
                nResult += N - nq;
                if (nResult < result)
                    result = nResult;
                break;
            } else {
                nq--;
            }
        }
        System.out.println(result);
        return;
    }
}
