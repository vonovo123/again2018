package WEEK30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

public class P16929 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static tmpNode[][] arr;
    static Vector<tmpNode> v;
    static int[][] visited;
    static int flag;

    static void dfs(tmpNode nd) {
        if (v.size() >= 4) {
            Iterator<tmpNode> itr = v.get(v.size() - 1).link.iterator();
            while (itr.hasNext()) {
                tmpNode tmp = itr.next();
                if (tmp.y == v.get(0).y && tmp.x == v.get(0).x) {
                    // System.out.println("yes");
                    flag = 1;
                }
            }
        }
        Iterator<tmpNode> itr = nd.link.iterator();
        while (itr.hasNext()) {
            tmpNode node = itr.next();
            if (visited[node.y][node.x] == 0) {
                v.add(node);
                visited[node.y][node.x] = 1;
                // System.out.printf("%d %d\n", node.y, node.x);
                dfs(node);
                visited[node.y][node.x] = 0;
                v.remove(v.size() - 1);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        arr = new tmpNode[N][M];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = new tmpNode(i, j, tmp[j]);
            }
        }
        // 인접하는 점 잇기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i > 0) {
                    if (arr[i][j].c.equals(arr[i - 1][j].c))
                        arr[i][j].link.add(arr[i - 1][j]);
                }

                if (i < N - 1) {
                    if (arr[i][j].c.equals(arr[i + 1][j].c))
                        arr[i][j].link.add(arr[i + 1][j]);
                }

                if (j > 0) {
                    if (arr[i][j].c.equals(arr[i][j - 1].c))
                        arr[i][j].link.add(arr[i][j - 1]);
                }

                if (j < M - 1) {
                    if (arr[i][j].c.equals(arr[i][j + 1].c))
                        arr[i][j].link.add(arr[i][j + 1]);
                }

                // for (int k = 0; k < arr[i][j].link.size(); k++) {
                // System.out.printf("%d %d\n", arr[i][j].link.get(k).y,
                // arr[i][j].link.get(k).x);
                // }
                // System.out.println();
            }
            // System.out.println();
        }
        flag = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (flag == 0) {
                    visited = new int[N][M];
                    v = new Vector<tmpNode>();
                    v.add(arr[i][j]);
                    visited[i][j] = 1;
                    dfs(arr[i][j]);
                }
            }
        }
        if (flag == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    static class tmpNode {
        int y;
        int x;
        LinkedList<tmpNode> link;
        String c;

        tmpNode(int y, int x, String c) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.link = new LinkedList<tmpNode>();

        }
    }

}
