package WEEK5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class NnM {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static boolean[] visited;
    static Vector<Integer> v;

    // 1부터 N까지 중 중복없이 M개를 고른 수열
    static int printOut() throws IOException {
        // 탐색하여 조건을 만족한 요소의 수가 M개가 되면 출력
        if (v.size() == M) {
            for (int j = 0; j < v.size(); j++) {
                if (j != v.size() - 1) {
                    bw.write(v.get(j) + " ");
                } else {
                    bw.write(v.get(j) + "\n");
                }
            }
            return 0;
        }
        return 1;
    }

    // 1부터 N까지 중 중복없이 M개를 고른 수열
    static void P15649() throws IOException {
        if (printOut() == 0)
            return;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // 오름차순 수열을 위해 vector 내 직전 요소가 새로 입력되는 수보다 작아야함
                // if (v.size() == 0 || v.get(v.size() - 1) < i) {
                visited[i] = true;
                v.add(i);
                P15649();
                // 백트레킹
                visited[i] = false;
                v.remove(v.size() - 1);
                // }
            }
        }
    }

    // 1부터 N까지 중 중복없이 M개를 고른 수열
    // 고른 수열은 오름차순이어야한다.
    static void P15650() throws IOException {
        if (printOut() == 0)
            return;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // 오름차순 수열을 위해 vector 내 직전 요소가 새로 입력되는 수보다 작아야함
                if (v.size() == 0 || v.get(v.size() - 1) < i) {
                    visited[i] = true;
                    v.add(i);
                    P15650();
                    // 백트레킹
                    visited[i] = false;
                    v.remove(v.size() - 1);
                }
            }
        }
    }

    // 1부터 N까지 중 M개를 고른 수열
    // 같은수를 골라도 된다.
    static void P15651() throws IOException {
        if (printOut() == 0)
            return;
        for (int i = 1; i <= N; i++) {
            // 오름차순 수열을 위해 vector 내 직전 요소가 새로 입력되는 수보다 작아야함
            v.add(i);
            P15651();
            // 백트레킹
            v.remove(v.size() - 1);
        }
    }

    // 1부터 N까지 중 M개를 고른 수열
    // 같은수를 골라도 된다.
    // 수열은 비내림차순이여야한다.
    static void P15652() throws IOException {
        if (printOut() == 0)
            return;
        for (int i = 1; i <= N; i++) {
            // 오름차순 수열을 위해 vector 내 직전 요소가 새로 입력되는 수보다 작아야함
            if (v.size() == 0 || v.get(v.size() - 1) <= i) {
                v.add(i);
                P15652();
                // 백트레킹
                v.remove(v.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        // N개의 숫자중
        N = Integer.parseInt(in[0]);
        // 길이가 M 인 수열을 출력한다.
        M = Integer.parseInt(in[1]);
        // 조건에 만족하는 배열의 요소를 담을 Vector
        v = new Vector<Integer>();
        // 탐색여부를 판단할 배열(1부터 시작)
        visited = new boolean[N + 1];
        P15652();
        bw.flush();

    }
}
