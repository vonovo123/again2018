package WEEK8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class P13913 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer>[] field;
    static int N, K;

    static int stoi(String in) {
        return Integer.parseInt(in);
    }

    static void BFS(int N) {
        LinkedList<Integer> queue = new LinkedList();
        int[] timeField = new int[100001];
        queue.add(N);
        timeField[N] = 0;
        while (queue.size() != 0) {
            int n = queue.poll();
            field[n].add(n - 1);
            field[n].add(n + 1);
            field[n].add(2 * n);
            ListIterator<Integer> li = field[n].listIterator();
            while (li.hasNext()) {
                int p = li.next();
                if (p == K) {
                    timeField[p] = timeField[n] + 1;
                    System.out.println(timeField[p]);
                    Vector<Integer> v = new Vector<>();
                    //노드
                    v.add(p);
                    int x = p; //17
                    int s = timeField[p]; //4
                    while (s > 1) {
                        s -= 1;
                        if (x + 1 < 100000 && timeField[x + 1] == s) {
                            x = x + 1;
                        } else if (x - 1 < 100000 && timeField[x - 1] == s) {
                            x = x - 1;

                        } else if (x / 2 < 100000 && timeField[x / 2] == s) {
                            x = x / 2;
                        }

                        v.add(x);
                    }
                    v.add(N);


                    for (int i = v.size() - 1; i >= 0; i--) {
                        if (i != 0) {
                            System.out.print(v.get(i) + " ");    
                        } else {
                            System.out.print(v.get(i));
                        }
                    }
                    System.out.println();
                    return;
                } else {
                    if (p >= 0 && p <= 100000) {
                        if (timeField[p] == 0) {
                            queue.add(p);
                            timeField[p] = timeField[n] + 1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        field = new LinkedList[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        if (K <= N) {
            System.out.println(N - K);
            for (int i = N; i >= K; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < field.length; i++) {
            field[i] = new LinkedList<Integer>();
        }
        BFS(N);
    }
}
