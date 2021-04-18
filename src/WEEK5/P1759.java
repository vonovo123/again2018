package WEEK5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Vector;

public class P1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, C;
    static String[] inA;
    static int[] isPossible;
    static Vector<String> result;
    static String mo;
    static String ja;

    static int parseInt(String in) {
        return Integer.parseInt(in);
    }

    static int checkMo() {
        for (int i = 0; i < result.size(); i++) {
            if (mo.indexOf(result.get(i)) != -1) {
                return 1;
            }
        }
        return 0;
    }

    static int checkJa() {
        int output = 0;
        for (int i = 0; i < result.size(); i++) {
            if (ja.indexOf(result.get(i)) != -1) {
                output++;
            }
            if (output == 2)
                return 1;
        }
        return -1;
    }

    static void dfs(int d) {
        if (result.size() == L) {// 탐색문자열의 길이가 암호의 길이와 같으면
            if (checkMo() == 1) {// 모음이 최소 1개있는지 확인
                if (checkJa() == 1) {// 자음이 최소 2개있는지 확인
                    for (int i = 0; i < result.size(); i++) {
                        // 만족하면 출력
                        System.out.print(result.get(i));
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int i = d; i < C; i++) {
            // 방문한적이 없는 알파벳이면
            if (isPossible[i] != 1) {
                // 방문처리
                isPossible[i] = 1;
                // 암호의 첫자리 탐색이면
                if (result.size() == 0) {
                    // d번째 자리에 d번째 알파벳 대입
                    result.add(inA[i]);
                    // 다음 노드로 이동
                    dfs(d + 1);
                    // 첫자리 이후 이면
                } else {
                    // 오름차순정렬을 위해 직전 위치의 알파뱃이 해당 알파벳 보다 작으면
                    // System.out.println(i);
                    // System.out.println(result.get(result.size() - 1).charAt(0));
                    // System.out.println(inA[i].charAt(0));
                    // System.out.println(result.get(result.size() - 1).charAt(0) < (int)
                    // inA[i].charAt(0));
                    if ((int) result.get(result.size() - 1).charAt(0) < (int) inA[i].charAt(0)) {
                        // d번째 자리에 d번째 알파벳 대입
                        result.add(inA[i]);
                        // 다음 탐색
                        dfs(i + 1);
                    }
                }
                // 백트래킹을 위해 탐색한 요소 뺀다.
                isPossible[i] = 0;
                for (int j = 0; j < result.size(); j++) {
                    System.out.printf("%s ", result.get(j));
                }
                System.out.println();
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        // 암호의 길이
        L = parseInt(in[0]);
        // 주어지는 알파벳의 길이
        C = parseInt(in[1]);
        // 가불판별값 담을 배열
        isPossible = new int[C];
        // 주어진 알파벳
        inA = br.readLine().split(" ");
        // 알파벳 순으로 정렬
        Arrays.sort(inA);
        for (String s : inA) {
            System.out.printf("%s ", s);
        }
        System.out.println();
        // 결과값
        result = new Vector<String>();
        // 모음
        mo = "aeiou";
        // 자음
        ja = "bcdfghjklmnpqrstvwxyz";
        dfs(0);
    }

}
