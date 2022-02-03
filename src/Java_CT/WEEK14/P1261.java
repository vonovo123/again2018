package WEEK14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[][] cArr;
    static LinkedList<tNode>[][] edges;
    static int M, N;

    static void BFS() {
        tNode sn = new tNode(0, 0, 0);
        cArr[0][0] = 0;
        PriorityQueue<tNode> q = new PriorityQueue<>();
        q.add(sn);

        while (q.size() > 0) {
            tNode mn = q.poll(); // 기준점
            System.out.printf("mn : %d : %d : %d\n", mn.y, mn.x, mn.cost);
            if (mn.y == N - 1 && mn.x == M - 1) {
                System.out.println(cArr[mn.y][mn.x]);
                return;
            }
            Iterator<tNode> itr = edges[mn.y][mn.x].iterator();
            while (itr.hasNext()) {
                tNode cn = itr.next();
                if (cArr[cn.y][cn.x] > cArr[mn.y][mn.x] + arr[cn.y][cn.x]) {
                    cArr[cn.y][cn.x] = cArr[mn.y][mn.x] + arr[cn.y][cn.x];
                    cn.cost = cArr[cn.y][cn.x];
                    System.out.printf("%d : %d : %d\n", cn.y, cn.x, cn.cost);
                    q.add(cn);
                }
                // cArr[cn.y][cn.x] = Math.min(, );

            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stk.nextToken());// 가로
        N = Integer.parseInt(stk.nextToken());// 세로
        // 이동하는 비용이 들어있는 배열
        arr = new int[N][M];
        // 0.0에서 정점 까지 최소 비용을 담을 배열
        cArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                cArr[i][j] = Integer.MAX_VALUE;
            }
        }
        // 간선을 담을 배열
        edges = new LinkedList[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                edges[i][j] = new LinkedList<tNode>();
                if (i > 0)
                    edges[i][j].add(new tNode(i - 1, j, 0));
                if (i < N - 1)
                    edges[i][j].add(new tNode(i + 1, j, 0));
                if (j > 0)
                    edges[i][j].add(new tNode(i, j - 1, 0));
                if (j < M - 1)
                    edges[i][j].add(new tNode(i, j + 1, 0));
            }
        }
        BFS();
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++) {
        // System.out.printf("%d ", cArr[i][j]);
        // }
        // System.out.println();
        // }

    }
}

class tNode implements Comparable<tNode> {
    int x;// 가로
    int y;// 세로
    int cost;

    tNode(int y, int x, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(tNode o) {
        // TODO Auto-generated method stub
        return this.cost < o.cost ? -1 : 1;
    }

}