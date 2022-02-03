package WEEK13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

public class P14501 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, D;
    static int[][] arr;
    static LinkedList[] lArr;
    static Vector<Integer> v;
    static int result = 0;

    static int stoi(String in) {
        return Integer.parseInt(in);
    }

    static void dfs(int idx, int sum) {
        Iterator<Integer> itr = lArr[idx].iterator();
        if (!itr.hasNext()) {
            if (sum > result) {
                result = sum;
            }
            return;
        }
        while (itr.hasNext()) {
            int n = itr.next();
            v.add(idx);
            int pay = 0;
            if (n == 0) {
                n = idx + 1;
            } else {
                pay = arr[idx][1];
                sum += pay;
            }
            dfs(n, sum);
            v.remove(v.size() - 1);
            sum -= pay;
        }
    }

    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        arr = new int[N + 1][2];
        v = new Vector<Integer>();
        StringTokenizer stk;
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = stoi(stk.nextToken());
            arr[i][1] = stoi(stk.nextToken());
        }
        lArr = new LinkedList[N + 2];
        for (int i = 1; i <= N + 1; i++) {
            lArr[i] = new LinkedList<Integer>();
            // 한다
            if (i != N + 1) {
                if (i + arr[i][0] <= N + 1) {
                    // 일이 끝난 위치
                    lArr[i].add(i + arr[i][0]);
                }
                // 안한다
                if (i + 1 <= N) {
                    lArr[i].add(0);
                }
            }

            // Iterator itr = lArr[i].iterator();
            // System.out.println(i);
            // while (itr.hasNext()) {
            // System.out.printf("%d ", itr.next());
            // }
            // System.out.println();
        }
        dfs(1, 0);
        System.out.println(result);
    }
}
