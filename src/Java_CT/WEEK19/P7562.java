package WEEK19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int I;
    static Loc nLoc;
    static Loc fLoc;
    static int count;
    static int[][] visited;

    static void bfs() throws IOException {
        Queue<Loc> v = new LinkedList<Loc>();
        v.add(nLoc);
        visited[nLoc.x][nLoc.y] = 1;
        while (v.size() != 0) {
            Loc t = v.poll();

            if (t.x - 1 >= 0 && t.y - 2 >= 0) {
                if (visited[t.x - 1][t.y - 2] == 0) {
                    t.link.add(new Loc(t.x - 1, t.y - 2, t.count + 1));
                }

            }

            if (t.x - 2 >= 0 && t.y - 1 >= 0) {
                if (visited[t.x - 2][t.y - 1] == 0) {
                    t.link.add(new Loc(t.x - 2, t.y - 1, t.count + 1));
                }

            }

            if (t.x - 2 >= 0 && t.y + 1 < I) {
                if (visited[t.x - 2][t.y + 1] == 0) {
                    t.link.add(new Loc(t.x - 2, t.y + 1, t.count + 1));
                }

            }
            if (t.x - 1 >= 0 && t.y + 2 < I) {
                if (visited[t.x - 1][t.y + 2] == 0) {
                    t.link.add(new Loc(t.x - 1, t.y + 2, t.count + 1));
                }

            }
            if (t.x + 1 < I && t.y + 2 < I) {
                if (visited[t.x + 1][t.y + 2] == 0) {
                    t.link.add(new Loc(t.x + 1, t.y + 2, t.count + 1));
                }

            }
            if (t.x + 2 < I && t.y + 1 < I) {
                if (visited[t.x + 2][t.y + 1] == 0) {
                    t.link.add(new Loc(t.x + 2, t.y + 1, t.count + 1));
                }

            }

            if (t.x + 2 < I && t.y - 1 >= 0) {
                if (visited[t.x + 2][t.y - 1] == 0) {
                    t.link.add(new Loc(t.x + 2, t.y - 1, t.count + 1));
                }

            }
            if (t.x + 1 < I && t.y - 2 >= 0) {
                if (visited[t.x + 1][t.y - 2] == 0) {
                    t.link.add(new Loc(t.x + 1, t.y - 2, t.count + 1));
                }
            }
            Iterator<Loc> itr = t.link.iterator();
            while (itr.hasNext()) {
                Loc n = itr.next();
                if (n.x == fLoc.x && n.y == fLoc.y) {
                    bw.write(n.count + "\n");
                    return;
                }
                visited[n.x][n.y] = 1;
                v.add(n);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int nx = 0, ny = 0, fx = 0, fy = 0;
        Queue<Loc> v;
        for (int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            nx = Integer.parseInt(stk.nextToken());
            ny = Integer.parseInt(stk.nextToken());
            nLoc = new Loc(nx, ny, 0);
            stk = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(stk.nextToken());
            fy = Integer.parseInt(stk.nextToken());
            fLoc = new Loc(fx, fy, 0);
            count = 0;
            visited = new int[I][I];
            // System.out.println(count);
            if (nLoc.x == fLoc.x && nLoc.y == fLoc.y) {
                bw.write(count + "\n");
            } else {
                bfs();
            }

        }
        bw.flush();
    }

    static class Loc {
        int x;
        int y;
        LinkedList<Loc> link;
        int count;

        public Loc(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.link = new LinkedList<Loc>();
            this.count = c;
        }
    }
}
