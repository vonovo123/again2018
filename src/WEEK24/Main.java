package WEEK24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()); // 컨베이어벨트 한 면의 수
        int K = Integer.parseInt(stk.nextToken()); // 내구도가 0인칸의 최대갯수
        int[] conN = new int[2 * N];
        int[] conNT = new int[2 * N];
        int[] con = new int[2 * N];
        int[] conT = new int[2 * N];

        int count = 0;
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < conN.length; i++) {
            conN[i] = Integer.parseInt(stk.nextToken());
        }
        while (true) {
            count++;
            // 컨베이어 벨트 한칸씩 이동
            for (int i = 0; i < 2 * N - 1; i++) {
                conNT[i + 1] = conN[i];
            }
            // 0의 내구도는 2 * N - 1의 내구도로 바뀜
            conNT[0] = conN[2 * N - 1];

            for (int i = 0; i < 2 * N; i++) {
                conN[i] = conNT[i];
            }
            // 이동 끝

            // 컨베이어 이동에 따라 로봇도 이동
            for (int i = 0; i < 2 * N - 1; i++) {
                conT[i + 1] = con[i];
            }
            conT[N - 1] = 0; // 내리는지점
            conT[0] = 0; // 타는지점
            // 로봇위치 복사
            for (int i = 0; i < 2 * N - 1; i++) {
                con[i] = conT[i];
            }

            for (int i = 2 * N - 2; i >= 0; i--) {
                if (i != N - 1 && con[i + 1] != 1 && conN[i + 1] != 0 && con[i] == 1) {
                    con[i + 1] = con[i];// 로봇이동 후 위치
                    con[i] = 0; // 로봇이동 전 위치
                    conN[i + 1]--; // 내구도 감소
                    if (i + 1 == N - 1) {
                        con[i + 1] = 0;
                    }
                }
            }
            // 올리기
            if (conN[0] != 0) {
                con[0] = 1;
                conN[0]--;
            }

            int tmp = 0;
            for (int i = 0; i < 2 * N; i++) {
                if (conN[i] == 0) {
                    tmp++;
                }
            }
            if (tmp >= K) {
                System.out.println(count);
                break;
            }
        }

    }
}
