package WEEK10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

public class P1260 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 정점수, 간선수, 탐색시작번호
    static int N, M, V;
    static boolean[] visited;
    static LinkedList<Integer>[] arr;
    static Vector<Integer> dv;

    static void dfs(int in) {
        Iterator<Integer> it = arr[in].iterator();
        dv.add(in);
        visited[in] = true;
        while (it.hasNext()) {
            int next = it.next();
            if (!visited[next]) {
                dfs(next); 
            }
        } 
    }

    static void bfs(int in) {
        Vector<Integer> tmp = new Vector<Integer>();
        tmp.add(in);
        while (tmp.size() > 0) {
            int first = tmp.firstElement();
            tmp.remove(0);
            if(!visited[first]){
                Iterator<Integer> it = arr[first].iterator();
                visited[first] = true;
                dv.add(first);
                while (it.hasNext()) {
                    int next = it.next();
                    tmp.add(next);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        V = Integer.parseInt(stk.nextToken());
        dv = new Vector<Integer>();
        visited = new boolean[N + 1];
        //정점을 담을 배열 생성
        arr = new LinkedList[N + 1];

        //정점 별 간선을 담기위한 LinkedList 초기화
        for (int i = 1; i <= N; i++) {
            arr[i] = new LinkedList<Integer>();
        }
        //정점별 간선 추간
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i], new Comparator<Integer>() {
                // compare 함수를 사용하여 정렬을 어떻게 할 것인지 정의한다.
                @Override
                public int compare(Integer o1, Integer o2) {
                    // 순차 정렬을 해주는 코드(역방향은 부등호를 변경하거나 return 값을 바꿔주면 됨)
                    // if-else 동등의 개념을 포함 , -1이 있기 때문에 +1로 적어서 동등하게 맞춰준다.
                    if (o1 > o2) // if(o1.n < o2.n) : 역순
                        return 1; // 양수의 대명사를 +1이라고 본다.
                    else
                        return -1;

                }
            });
        }
        

        dfs(V);
        String result = "";
        for (int i = 0; i < dv.size(); i++) {
            result += dv.get(i) + " ";
        }

         System.out.println(result.trim());

        visited = new boolean[N + 1];
        dv = new Vector<Integer>();
        result = "";
        bfs(V);
        for (int i = 0; i < dv.size(); i++) {
            result += dv.get(i) + " ";
        }

        System.out.println(result.trim());
    }
}
