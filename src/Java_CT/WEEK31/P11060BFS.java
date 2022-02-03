package WEEK31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class P11060BFS {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer>[] links;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[N];
        String[] tmpA = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            ia[i] = Integer.parseInt(tmpA[i]);
        }
        links = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            links[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= ia[i]; j++) {
                links[i].add(i + j);
            }
        }
        int result = -1;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {

        }
        LinkedList<Integer> v = new LinkedList<Integer>();
        v.add(0);
        while (v.size() != 0) {
            int tmp = v.poll();
            Iterator<Integer> itr = links[tmp].iterator();
            while (itr.hasNext()) {
                int next = itr.next();
                if (next < N) {
                    if (arr[next] == 0) {
                        arr[next] = arr[tmp] + 1;
                    } else {
                        if (arr[next] > arr[tmp] + 1) {
                            arr[next] = arr[tmp] + 1;
                        }
                    }
                    v.add(next);
                }
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.printf("%d ", arr[i]);
        // }
        // System.out.println();
        if (arr[N - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(arr[N - 1]);
        }
    }
}
