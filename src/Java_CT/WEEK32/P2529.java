package WEEK32;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P2529 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visited;
    static String[] tmp;
    static Vector<Integer> v;
    static int N;
    static long min, max;

    static void dfs() {
        if (v.size() == N + 1) {
            String tmp = "";
            for (int i = 0; i < v.size(); i++) {
                tmp += String.valueOf(v.get(i));
            }

            if (Long.parseLong(tmp) < min) {
                min = Long.parseLong(tmp);
            }
            if (Long.parseLong(tmp) > max) {
                max = Long.parseLong(tmp);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (visited[i] == 0) {
                if (v.size() == 0) {
                    v.add(i);
                    visited[i] = 1;
                    dfs();
                    visited[i] = 0;
                    v.remove(v.size() - 1);
                } else {
                    if (tmp[v.size() - 1].equals("<")) {
                        if (v.get(v.size() - 1) < i) {
                            v.add(i);
                            visited[i] = 1;
                            dfs();
                            visited[i] = 0;
                            v.remove(v.size() - 1);
                        }
                    } else {
                        if (v.get(v.size() - 1) > i) {
                            v.add(i);
                            visited[i] = 1;
                            dfs();
                            visited[i] = 0;
                            v.remove(v.size() - 1);
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        tmp = br.readLine().split(" ");
        visited = new int[10];
        v = new Vector<Integer>();
        min = 9999999999L;
        max = 0;
        dfs();
        if (Math.pow(10, N) > max) {
            System.out.println("0" + max);
        } else {
            System.out.println(max);
        }
        if (Math.pow(10, N) > min) {
            System.out.println("0" + min);
        } else {
            System.out.println(min);
        }

    }
}
