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

public class P13023 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int N, M;
    static LinkedList<Integer>[] rel;
    static int max = 4;
    static Vector<Integer> v;
    static int flag = 0;
    static int stoi(String in) {
        return Integer.parseInt(in);
    }

    static void addEg(int v, int w) {
        rel[v].add(w);
    }

    static void DFS(int in) {
        //탐색할 사람의 관계를 담은 linkedList를 직렬화 한다.
        ListIterator<Integer> lirt = rel[in].listIterator();
        
        //관계가 5까지 이어지면 flag 키고 종료
        if (v.size() == 5) {
            flag = 1;
            return;
        }
        //탐색할 사람의 관계를 탐색한다.
        while (lirt.hasNext()) {
            //탐색할 사람의 관계가 
            int n = lirt.next();
            //조건만족여부 확인을 위한 linkedList에 존재하지 않으면
            if (!v.contains(n)) {
                //추가하고 
                v.add(n);
                //추가한 사람의 관계 탐색을 진행한다
                DFS(n);
                //만족하지 않으면 뺀다.
                v.remove(v.size() - 1);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        //사람 수
        N = stoi(stk.nextToken());
        //관계 수
        M = stoi(stk.nextToken());
        //사람끼리의 관계를 표현하는 LinkedList 담을 배열 
        rel = new LinkedList[N];
        //사람별 관계를 담기위해 배열자리마다 LinkedList 초기화
        for (int i = 0; i < N; i++) {
            rel[i] = new LinkedList<Integer>();
        }
        //관계를 입력 받아서
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int A = stoi(stk.nextToken());
            int B = stoi(stk.nextToken());
            //A 사람과 B사람은 친구
            addEg(A, B);
            //B사람과 A사람은 친구
            addEg(B, A);
        }
        //탐색
        for (int i = 0; i < N; i++) {
            //문제에 주어진 관계를 한번이라도 만족하면 더이상 탐색하지 않음.
            if (flag == 0) {
                //문제에 조건에 만족하는 관계가 있는지 확인하기 위한 LinkenList 초기화
                v = new Vector<Integer>();
                //시작점을 LinkenList에 담는다.
                v.add(i);
                DFS(v.get(0));
            }
        }
        System.out.println(flag);
    }
}
