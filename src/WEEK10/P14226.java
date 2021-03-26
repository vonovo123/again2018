package WEEK10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class P14226 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int S;
    static boolean[][] visit = new boolean[1001][1001];
    static int min;

    public static void main(String[] args) throws NumberFormatException, IOException {
        S = Integer.parseInt(br.readLine());
        Queue<Node> q = new LinkedList<Node>();
        visit[1][0] = true; // 처음 상태
        // 탐색을 위해 큐에 넣기
        q.add(new Node(1, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            // 화면의 이모티콘 개수가 S가 되는 순간 출력 후 마침
            if (cur.len == S) {
                min = cur.cnt;
                break;
            }
            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            q.add(new Node(cur.len, cur.len, cur.cnt + 1));

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (cur.buf != 0 && cur.len + cur.buf <= 1000 && !visit[cur.len + cur.buf][cur.buf]) {
                visit[cur.len + cur.buf][cur.buf] = true;
                q.add(new Node(cur.len + cur.buf, cur.buf, cur.cnt + 1));
            }

            // 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (cur.len > 0 && cur.len - 1 <= 1000 && !visit[cur.len - 1][cur.buf]) {
                visit[cur.len - 1][cur.buf] = true;
                q.add(new Node(cur.len - 1, cur.buf, cur.cnt + 1));
            }
        }

        System.out.println(min);
    }
}

class Node {
    int len;
    int buf;
    int cnt;

    Node(int len, int buf, int cnt) {
        this.len = len;
        this.buf = buf;
        this.cnt = cnt;
    }
}
