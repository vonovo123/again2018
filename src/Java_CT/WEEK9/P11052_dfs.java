package WEEK9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class P11052_dfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count, N, max;//담은카드 수, 담아야할 카드 수, 최고가격
    static Vector<Integer> vec;//카드를 담을 vec
    static int[] packs;//주어지는 카드팩

    static void dfs(int in) {
        //System.out.println("count: " + count);
        if (count == N) {//
            int tmp = 0;
            for (int i = 0; i < vec.size(); i++) {
                tmp += packs[vec.get(i) - 1];
                if (tmp > max) {
                    max = tmp;
                }
            }
            //System.out.println(tmp);
            return;
        } else if (count > N) {
            return;
        }
        for (int i = in; i < N; i++) {
            count += i + 1;
            vec.add(i + 1);
            dfs(i);
            count -= i + 1;
            vec.remove(vec.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        count = 0;
        N = Integer.parseInt(br.readLine());
        vec = new Vector<Integer>();
        max = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        packs = new int[N]; 
        for (int i = 0; i < N; i++) {
            packs[i] = Integer.parseInt(stk.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }
}
