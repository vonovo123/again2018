package WEEK16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14503 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] ia;

    public static void main(String[] args) throws IOException {
        int N, M; // 가로세로 크기
        int r, c; // 현재위치
        int d, ans; // 바라보는 방향, 청소한 수
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        ans = 0; // 제자리

        // 지도
        ia = new String[N][M];
        for (int i = 0; i < N; i++) {
            ia[i] = br.readLine().split(" ");
        }
        robot robo = new robot(r, c, d);
        int dir = 1;
        while (true) {
            if (dir == 1) {
                if (ia[robo.r][robo.c].equals("0")) {
                    ans += 1;
                    ia[robo.r][robo.c] = "2";
                }
            }
            if (ia[robo.lr][robo.lc].equals("0")) {// 왼쪽에 청소할 수 있으면 a
                robo.turnLeft();
                robo.moveForward();
                dir = 1;
                continue;
            } else {
                if (!ia[robo.rr][robo.rc].equals("0") && !ia[robo.rr][robo.rc].equals("0")
                        && !ia[robo.fr][robo.fc].equals("0") && !ia[robo.br][robo.bc].equals("0")) {
                    if (ia[robo.br][robo.bc].equals("1")) { // 네 방향이 청소못하고 뒤가 벽이면 d
                        System.out.println(ans);
                        break;
                    } else { // 네 방향이 청소 못하고 뒤가 벽이 아니면 C
                        robo.moveToBack();
                        dir = 1;
                        continue;
                    }
                }
                // b
                robo.turnLeft();
                dir = 0;
                continue;
            }
        }
    }
}

class robot {
    int r; // y위치
    int c; // x위치
    int d; // 바라보는 방향

    int lr; // 왼쪽 y 위치
    int lc; // 왼쪽 x 위치
    int rr; // 오른쪽 y 위치
    int rc; // 오른쪽 x 위치
    int fr; // 북쪽 y 위치
    int fc; // 북쪽 x 위치
    int br; // 남쪽 y 위치
    int bc; // 남쪽 x 위치

    public robot(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
        setLoc(d);
    }

    void setLoc(int d) {
        if (d == 0) {// 북
            lr = r;
            lc = c - 1;

            rr = r;
            rc = c + 1;

            fr = r - 1;
            fc = c;

            br = r + 1;
            bc = c;

        } else if (d == 1) { // 동
            lr = r - 1;
            lc = c;

            rr = r + 1;
            rc = c;

            fr = r;
            fc = c + 1;

            br = r;
            bc = c - 1;
        } else if (d == 2) { // 남
            lr = r;
            lc = c + 1;

            rr = r;
            rc = c - 1;

            fr = r + 1;
            fc = c;

            br = r - 1;
            bc = c;
        } else if (d == 3) {// 서
            lr = r + 1;
            lc = c;

            rr = r - 1;
            rc = c;

            fr = r;
            fc = c - 1;

            br = r;
            bc = c + 1;
        }
    }

    void turnLeft() { // 왼쪽으로 돌기
        if (d == 0) {// 북
            d = 3;
        } else if (d == 1) { // 동
            d = 0;
        } else if (d == 2) { // 남
            d = 1;
        } else if (d == 3) {// 서
            d = 2;
        }
        setLoc(d);
    }

    void moveForward() {// 바라보는 방향으로 이동
        r = fr;
        c = fc;
        setLoc(d);
    }

    void moveToBack() {
        r = br;
        c = bc;
        setLoc(d);
    }
}
