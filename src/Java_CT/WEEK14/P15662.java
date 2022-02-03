package WEEK14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P15662 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] top;
    static int[][] direction;

    static int[] turn(int idx, int dir) {
        int[] bDirection = new int[4];
        for (int i = 0; i < 4; i++) {
            bDirection[i] = direction[idx][i];
            if (dir == 1) {
                direction[idx][i] = (direction[idx][i] == 0) ? 7 : direction[idx][i] - 1;
            } else {
                direction[idx][i] = (direction[idx][i] == 7) ? 0 : direction[idx][i] + 1;
            }

        }
        return bDirection;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        top = new String[T][8];
        direction = new int[T][4];
        StringTokenizer stk;
        for (int i = 0; i < T; i++) {
            top[i] = br.readLine().split("");
            direction[i][0] = 0;
            direction[i][1] = 2;
            direction[i][2] = 4;
            direction[i][3] = 6;
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(stk.nextToken()) - 1;
            int dir = Integer.parseInt(stk.nextToken());
            int lDir = dir;// 움직인 톱니 왼쪽에 있는 톱니들의 움직임 방향
            int rDir = dir;// 움직인 톱니 오른쪽에 있는 톱니들의 움직임 방향
            int[] bDirection = new int[4]; // 움직이기전 상태
            int[] bLDirection = new int[4]; // 움직이기전 상태
            int[] bRDirection = new int[4]; // 움직이기전 상태

            bDirection = turn(idx, dir);
            // System.out.println("dir:" + dir);
            bLDirection = bDirection;
            for (int j = idx - 1; j >= 0; j--) {
                if (!top[j][direction[j][1]].equals(top[j + 1][bLDirection[3]])) { // 극이 다르면
                    lDir = lDir == 1 ? -1 : 1;
                    bLDirection = turn(j, lDir);

                } else {
                    break;
                }
            }
            bRDirection = bDirection;
            for (int j = idx + 1; j < T; j++) {
                // System.out.printf("right: %s %s\n ", top[j][direction[j][3]], top[j -
                // 1][bRDirection[1]]);
                if (!top[j][direction[j][3]].equals(top[j - 1][bRDirection[1]])) { // 극이 다르면
                    rDir = rDir == 1 ? -1 : 1;
                    bRDirection = turn(j, rDir);
                } else {
                    break;
                }
            }
        }
        int result = 0;
        for (int j = 0; j < T; j++) {
            if (top[j][direction[j][0]].equals("1")) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
