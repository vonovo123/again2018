package WEEK15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] arr;
    static LinkedList<Point>[][] link;
    static int N;
    static boolean[][] visited;
    static int total;
    static Vector<Integer> rv;

    static void bfs(Point sp) {
        Queue<Point> q = new LinkedList<Point>();
        int count = 0;
        if (!visited[sp.y][sp.x]) {
            if (arr[sp.y][sp.x].equals("1")) {
                q.add(sp);
                visited[sp.y][sp.x] = true;
                count += 1;
                while (q.size() != 0) {
                    Point p = q.poll();
                    LinkedList<Point> l = link[p.y][p.x];
                    Iterator<Point> itr = l.iterator();
                    while (itr.hasNext()) {
                        Point np = itr.next();
                        if (!visited[np.y][np.x]) {
                            visited[np.y][np.x] = true;
                            count += 1;
                            q.add(np);
                        }
                    }
                }
                rv.add(count);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }
        link = new LinkedList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                link[i][j] = new LinkedList<Point>();
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j].equals("1")) {
                    if (i - 1 >= 0) {
                        if (arr[i - 1][j].equals("1"))
                            link[i][j].add(new Point(i - 1, j));
                    }
                    if (i + 1 < N) {
                        if (arr[i + 1][j].equals("1"))
                            link[i][j].add(new Point(i + 1, j));
                    }

                    if (j - 1 >= 0) {
                        if (arr[i][j - 1].equals("1"))
                            link[i][j].add(new Point(i, j - 1));
                    }

                    if (j + 1 < N) {
                        if (arr[i][j + 1].equals("1"))
                            link[i][j].add(new Point(i, j + 1));
                    }
                }
            }
        }
        total = 0;
        rv = new Vector<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(new Point(i, j));
            }
        }
        System.out.println(rv.size());
        Collections.sort(rv);
        // rv.sort();
        for (int i = 0; i < rv.size(); i++) {
            System.out.println(rv.get(i));
        }
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < N; j++) {
        // System.out.printf("%d ", link[i][j].size());
        // }
        // System.out.println();
        // }
    }
}

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
