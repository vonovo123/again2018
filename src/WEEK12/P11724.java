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
import java.util.Vector;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int stoi(String in) {
        return Integer.parseInt(in);
    }

    public static void main(String[] args) throws IOException {
        int N, M, S, E;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = stoi(stk.nextToken());
        M = stoi(stk.nextToken());
        LinkedList<Integer>[] arr = new LinkedList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            S = stoi(stk.nextToken());
            E = stoi(stk.nextToken());
            arr[S].add(E);
            arr[E].add(S);

        }
        boolean[] visited = new boolean[N + 1];
        int result = 0;
        for (int i = 1; i < N; i++) {
            int s = i;
            Vector<Integer> trace = new Vector<Integer>();
            if (!visited[i]) {
                Queue<Integer> v = new LinkedList<Integer>();
                trace.add(s);
                v.add(s);
                visited[s] = true;
                while (v.size() != 0) {
                    int t = v.poll();
                    Iterator<Integer> itr = arr[t].iterator();
                    while (itr.hasNext()) {
                        int n = itr.next();
                        if (!visited[n]) {
                            visited[n] = true;
                            v.add(n);
                            trace.add(n);
                        }
                    }
                }
            }
            // for (int j = 0; j < trace.size(); j++) {
            // System.out.println(trace.get(j));
            // }
            // System.out.println();
            if (trace.size() > 0) {
                result++;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                result += 1;
        }
        System.out.println(result);
    }
}
