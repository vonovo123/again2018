package WEEK12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13549 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static LinkedList<obj>[] arr;

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] timeTable = new int[100001];
        boolean[] occupied = new boolean[100001];

        q.add(N);
        occupied[N] = true;
        while (q.size() != 0) {
            int t = q.poll();
            // System.out.println(t);
            if (t != 0) {
                arr[t].add(new obj(t * 2, 0));
            }
            arr[t].add(new obj(t - 1, 1));
            arr[t].add(new obj(t + 1, 1));

            Iterator<obj> itr = arr[t].iterator();
            while (itr.hasNext()) {
                obj nextObj = itr.next();
                int idx = nextObj.idx;
                int time = nextObj.time;
                if (idx >= 0 && idx <= 100000) {
                    if (!occupied[idx]) {
                        if (idx == K) {
                            System.out.println(timeTable[t] + time);
                            return;
                        } else {
                            timeTable[idx] = timeTable[t] + time;
                            occupied[idx] = true;
                            q.add(idx);
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        // 간선표시를 위해 배열 속 Linkedlist 초기화
        arr = new LinkedList[100001];
        for (int i = 0; i <= 100000; i++) {
            arr[i] = new LinkedList<obj>();
        }
        if (N >= K) {
            System.out.println(N - K);
        } else {
            bfs();
        }

    }

    static class obj {
        int idx;
        int time;

        public obj(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}
