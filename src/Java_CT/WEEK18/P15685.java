package WEEK18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class P15685 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[101][101];
        System.out.println();
        for (int i = 0; i < N; i++) {

            StringTokenizer stn = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stn.nextToken()); // x좌표
            int y = Integer.parseInt(stn.nextToken()); // y좌표
            int d = Integer.parseInt(stn.nextToken()); // 방향
            int g = Integer.parseInt(stn.nextToken()); // 세대

            Vector<P> v = new Vector<P>();
            P s = new P(x, y);// 시작점
            // 1세대 구하기
            P e = null;
            if (d == 0) {// 오른쪽
                e = new P(x + 1, y);
            } else if (d == 1) {// 위쪽
                e = new P(x, y - 1);
            } else if (d == 2) {// 왼쪽
                e = new P(x - 1, y);
            } else {// 아래쪽
                e = new P(x, y + 1);
            }
            v.add(s);
            v.add(e);
            for (int j = 1; j <= g; j++) { // 1세대부터 그리기
                s = v.get(v.size() - 1);// 끝점이 기준점
                Vector<P> t = new Vector<P>();
                for (int k = 0; k < v.size() - 1; k++) {// 끝점빼고 복사
                    t.add(v.get(k));// 복사
                }
                for (int k = t.size() - 1; k >= 0; k--) {
                    P tt = t.get(k);
                    int xs = s.x - tt.x;
                    int ys = s.y - tt.y;
                    if (s.x + ys >= 0 && s.x + ys <= 100 && s.y - xs >= 0 && s.y - xs <= 100) {
                        v.add(new P(s.x + ys, s.y - xs));
                    }
                }

            }

            for (int j = 0; j < v.size(); j++) {
                int xx = v.get(j).x;
                int yy = v.get(j).y;
                // System.out.printf("%d %d\n", v.get(j).x, v.get(j).y);
                if (table[yy][xx] == 0) {
                    table[yy][xx] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (table[i][j] == 1 && table[i + 1][j] == 1 && table[i][j + 1] == 1 && table[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
