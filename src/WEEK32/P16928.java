package WEEK32;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P16928 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class node {
        int idx;
        LinkedList<node> link;
        int distance;

        node(int idx) {
            this.idx = idx;
            this.link = new LinkedList<node>();
            this.distance = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) throws IOException {
        int N, M;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        node[] S = new node[101];

        // B : 블록 L : 사다리 S: 뱀
        for (int i = 1; i <= 100; i++) {
            S[i] = new node(i);
        }
        // 사다리
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            S[from].link.add(new node(to));
        }

        // 뱀
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            S[from].link.add(new node(to));
        }
        LinkedList<node> q = new LinkedList<node>();

        S[1].distance = 0;
        q.add(S[1]);
        while (q.size() != 0) {
            node node = q.pop();
            // System.out.println(node.idx);
            // System.out.println(node.distance);
            if (node.link.size() != 0) { // 사다리 혹은 뱀이 있으면

                node nNode = node.link.get(0);

                // 목적지의 최소 주사위 횟수가 탐색노드의 최소 주사위 수보다 크면 탐색노드의 최소 주사위 수로
                if (S[nNode.idx].distance > node.distance) {
                    S[nNode.idx].distance = node.distance;
                    q.add(S[nNode.idx]);
                }
            } else {
                for (int i = 1; i <= 6; i++) {
                    int idx = node.idx + i;
                    if (idx <= 100) {
                        if (S[idx].distance > node.distance) {
                            S[idx].distance = node.distance + 1;
                            q.add(S[idx]);
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 10 != 0) {
                System.out.printf("%d ", S[i].distance);
            } else {
                System.out.printf("%d\n", S[i].distance);
            }
        }
        System.out.println(S[100].distance);
    }
}
