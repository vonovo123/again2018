package WEEK18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P7576 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] box;
    static int N, M;

    static void BFS() {
        Queue<Node> q = new LinkedList<Node>();
        Queue<Node> nq = new LinkedList<Node>();
        int d = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {// 익은토마토
                    q.add(new Node(i, j));
                }
            }
        }
        while (q.size() != 0) {
            Node t = q.poll();
            if (t.y < N - 1 && box[t.y + 1][t.x] == 0) {
                t.link.add(new Node(t.y + 1, t.x));
            }
            if (t.y > 0 && box[t.y - 1][t.x] == 0) {
                t.link.add(new Node(t.y - 1, t.x));
            }
            if (t.x < M - 1 && box[t.y][t.x + 1] == 0) {
                t.link.add(new Node(t.y, t.x + 1));
            }
            if (t.x > 0 && box[t.y][t.x - 1] == 0) {
                t.link.add(new Node(t.y, t.x - 1));
            }
            Iterator<Node> itr = t.link.iterator();
            while (itr.hasNext()) {
                Node tt = itr.next();
                if (box[tt.y][tt.x] == 0) {
                    box[tt.y][tt.x] = 1;
                }

                nq.add(tt);
            }
            if (q.size() == 0) {
                // for (int i = 0; i < N; i++) {
                // for (int j = 0; j < M; j++) {
                // System.out.printf("%d ", box[i][j]);
                // }
                // System.out.println();
                // }
                // System.out.println();
                int size = nq.size();
                if (size != 0)
                    d++;
                for (int i = 0; i < size; i++) {
                    q.add(nq.poll());
                }
            }
        }
        int flag = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    flag = -1;
                    break;
                }
            }
        }
        if (flag == -1)
            System.out.println(flag);
        else
            System.out.println(d);

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stn = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stn.nextToken());
        N = Integer.parseInt(stn.nextToken());
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            stn = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
        BFS();

    }

    static class Node {
        int y;
        int x;
        LinkedList<Node> link;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
            this.link = new LinkedList<Node>();
        }
    }
}
