package WEEK14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1707 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Node[] arr;
    static int V;
    static int E;

    static void bfs() {
        Deque<Integer> q = new LinkedList<Integer>();
        boolean[] occu = new boolean[V + 1];
        // 시작점
        for (int i = 1; i < V; i++) {
            q.add(i);
            arr[i].color = 1;
            while (q.size() != 0) {
                int p = q.poll();
                if (!occu[p]) {
                    occu[p] = true;
                    Iterator<Integer> itr = arr[p].link.iterator();
                    while (itr.hasNext()) {
                        int t = itr.next();
                        if (arr[t].color == 0) {
                            if (arr[p].color == 1)
                                arr[t].color = 2;
                            else
                                arr[t].color = 1;
                            // System.out.printf("%d : %d, %d : %d\n", p, arr[p].color, t, arr[t].color);
                        } else {
                            if (arr[p].color == arr[t].color) {
                                System.out.println("NO");
                                return;
                            }
                        }
                        q.add(t);
                    }

                }
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int K = 0;
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            V = Integer.parseInt(stk.nextToken());
            E = Integer.parseInt(stk.nextToken());
            arr = new Node[V + 1];
            // 노드 번호와 색 매겨서 초기화
            for (int j = 1; j <= V; j++) {
                arr[j] = new Node(j, 0);
            }
            for (int j = 0; j < E; j++) {
                stk = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(stk.nextToken());
                int e = Integer.parseInt(stk.nextToken());
                arr[v].link.add(e);
                arr[e].link.add(v);
            }
            bfs();
        }
    }
}

class Node {
    int num;
    int color;
    LinkedList<Integer> link;

    Node(int num, int color) {
        this.num = num;
        this.color = color;
        link = new LinkedList<Integer>();
    }
}