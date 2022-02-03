package WEEK31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

public class P16234 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class node {
        int val;
        int occ;
        int y;
        int x;
        LinkedList<node> link;

        node(int val, int y, int x) {
            this.val = val;
            this.y = y;
            this.x = x;
            occ = 0;
            link = new LinkedList<node>();
        }
    }

    public static void main(String[] args) throws IOException {
        int N, L, R;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        node[][] na = new node[N][N];// 인구
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                na[i][j] = new node(Integer.parseInt(tmp[j]), i, j);
            }
        }
        // 연결
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    na[i][j].link.add(na[i][j + 1]);
                }
                if (j - 1 >= 0) {
                    na[i][j].link.add(na[i][j - 1]);
                }

                if (i + 1 < N) {
                    na[i][j].link.add(na[i + 1][j]);
                }
                if (i - 1 >= 0) {
                    na[i][j].link.add(na[i - 1][j]);
                }
            }
        }

        // 횟수
        int turn = 0;
        // 이동여부
        boolean move = true;
        while (move) {
            // 이동이 있을지 판단하기위해 초기화
            move = false;
            Vector<Vector<node>> vCount = new Vector<Vector<node>>();
            vCount.add(null);// idx 0일
            int idx = 1; // 연합번호
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 연합되지않은 영토이면
                    if (na[i][j].occ == 0) {
                        na[i][j].occ = idx;
                        Vector<node> v = new Vector<node>();
                        v.add(na[i][j]);
                        vCount.add(idx, v);
                        idx++;
                    }

                    Iterator<node> itr = na[i][j].link.iterator();
                    while (itr.hasNext()) {
                        node tmp = itr.next();// 인접 국가
                        // 국경선을 열수 있는경우
                        if (Math.abs(tmp.val - na[i][j].val) >= L && Math.abs(tmp.val - na[i][j].val) <= R) {
                            move = true; // 영토이동이 있을경우
                            if (tmp.occ == 0) {
                                Vector<node> tmpV = vCount.get(na[i][j].occ);
                                na[tmp.y][tmp.x].occ = na[i][j].occ;
                                tmpV.add(tmp);
                                vCount.set(na[i][j].occ, tmpV);
                            } else {
                                if (tmp.occ != na[i][j].occ) {
                                    Vector<node> tmpV = vCount.get(tmp.occ);
                                    Vector<node> ttmpV = vCount.get(na[i][j].occ);
                                    for (int k = 0; k < ttmpV.size(); k++) {
                                        node tmpN = ttmpV.get(k);
                                        na[tmpN.y][tmpN.x].occ = tmp.occ;
                                        tmpV.add(tmpN);
                                    }
                                    vCount.set(tmp.occ, tmpV);
                                }
                            }
                        }
                    }
                }
            }
            if (move) {
                turn++;
            }
            Vector<Integer> vSum = new Vector<Integer>();
            // 초기화
            for (int i = 0; i < vCount.size(); i++) {
                vSum.add(0);
            }
            for (int i = 1; i < vCount.size(); i++) {
                int sum = 0;
                for (int j = 0; j < vCount.get(i).size(); j++) {
                    node tmp = vCount.get(i).get(j);
                    sum += tmp.val;
                }
                vSum.set(i, sum / vCount.get(i).size());
                // System.out.printf("sum: %d %d\n", sum, vCount.get(i).size());
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    na[i][j].val = vSum.get(na[i][j].occ);
                    na[i][j].occ = 0;

                }
            }

        }

        System.out.println(turn);
    }
}
