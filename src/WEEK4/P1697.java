package WEEK4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

class P1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K, N;
    static LinkedList<Integer> adj[];

    static void BFS(int t) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int checkCount[] = new int[100001];
        queue.add(t);// 큐에 시작점을 추가한다.
        while (queue.size() != 0) {
            int s = queue.poll(); // 큐의 맨앞 요소를
            // 갈수있는 위치를 추가한다.
            adj[s].add(s - 1);
            adj[s].add(s + 1);
            adj[s].add(s * 2);
            Iterator<Integer> i = adj[s].iterator();// s 와 연결된 링크 모두 꺼냄
            // 너비탐색
            while (i.hasNext()) {
                int n = i.next();
                // 갈수 있는 위치가 동생위치이면 현재 위치에서 1초 지난 시간이 정답
                if (n == K) {
                    System.out.println(checkCount[s] + 1);
                    return;
                }
                // n은 동생이 움직일 수 있는 범위내만 가능
                if (n >= 0 && n <= 100000) {
                    // 위치에 도착할 수 있는 가장 빠른 시간을 기록한다.
                    if (checkCount[n] == 0) {
                        queue.add(n); // 연결된 위치로 이동하도록 큐에 추가
                        checkCount[n] = checkCount[s] + 1; // 해당 위치까지 가는대 걸린 시간(현위치(s)로 오는 시간 더하기 1)
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        String in = br.readLine();
        String[] inA = in.split(" ");
        N = Integer.parseInt(inA[0]);// 언니 위치
        K = Integer.parseInt(inA[1]);// 동생 위치
        // 동생이 언니보다 앞에 있으면 X-1 방법으로 N-K초 만큼가는방법 밖에 없음
        if (K <= N) {
            System.out.println(N - K);
            return;
        }
        // 너비우선 탐색을 위해 0 에서 N 으로 이동중 나올 수 있는 모든 지점의 갯수만큼의 LinkedList를 담을 수 있는 배열 생성.
        adj = new LinkedList[100001];

        // 모든 지점이 각각의 링크를 가질수 있도록 linkedList를 할당한다.
        for (int i = 0; i <= 100000; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        // 언니위치 N에서 너비탐색 시작
        BFS(N);
    }
}
