package WEEK16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P2178 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static String sArr[][];
    static LinkedList<Node> link[][];

    static void bfs(Node s) {
        Queue<Node> q = new LinkedList<Node>();
        int[][] v = new int[N][M];
        q.add(s);
        v[s.y][s.x] = 1;// 첫 칸이동 1
        while (q.size() > 0) {
            Node in = q.poll();
            int y = in.y;
            int x = in.x;
            if (y - 1 >= 0) {
                link[y][x].add(new Node(y - 1, x));
            }
            if (y + 1 < N) {
                link[y][x].add(new Node(y + 1, x));
            }
            if (x - 1 >= 0) {
                link[y][x].add(new Node(y, x - 1));
            }
            if (x + 1 < M) {
                link[y][x].add(new Node(y, x + 1));
            }
            Iterator<Node> itr = link[y][x].iterator();
            while (itr.hasNext()) {
                Node n = itr.next();
                if (n.y == N - 1 && n.x == M - 1) {
                    v[n.y][n.x] = v[in.y][in.x] + 1;

                    // for (int i = 0; i < N; i++) {
                    // for (int j = 0; j < M; j++) {
                    System.out.printf("%d ", v[n.y][n.x]);
                    // }
                    // System.out.println();
                    // }
                    return;
                }
                if (sArr[n.y][n.x].equals("1")) {
                    if (v[n.y][n.x] == 0) {
                        v[n.y][n.x] = v[in.y][in.x] + 1;
                        q.add(n);
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        sArr = new String[N][M];
        for (int i = 0; i < N; i++) {
            sArr[i] = br.readLine().split("");
        }
        link = new LinkedList[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                link[i][j] = new LinkedList<Node>();
            }
        }

        bfs(new Node(0, 0));
    }
}

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}