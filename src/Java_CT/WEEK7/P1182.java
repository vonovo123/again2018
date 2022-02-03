package WEEK7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P1182 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] NA;
    static Vector<Integer> v;
    static int result;
    static int stio(String in) {
        return Integer.parseInt(in);
    }

    static void dfs(int index) {
        if (v.size() != 0) {
            int sum = 0;
            for (int i = 0; i < v.size(); i++) {
                sum += NA[v.get(i)];
            }
            if (sum == S) {
                result++;
            }
            if (v.size() == N)
                return;
        }
        
        for (int i = index; i < NA.length; i++) {
            int flag = 0;
            for (int j = 0; j < v.size(); j++) {
                if (v.get(j) == i) {
                    flag = 1;
                }
            }
                if (flag == 0) {
                   
                    v.add(i);
                    dfs(i);
                    v.remove(v.size() - 1);
                }

        }

    }

    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        N = stio(tmp[0]);
        S = stio(tmp[1]);

        tmp = br.readLine().split(" ");
        NA = new int[tmp.length];
        v = new Vector<Integer>();
        result = 0;
        for (int i = 0; i < tmp.length; i++) {
            NA[i] = stio(tmp[i]);
        }

        dfs(0);

        System.out.println(result);

    }
}
