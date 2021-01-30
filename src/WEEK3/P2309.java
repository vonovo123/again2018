package WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class P2309 {
    //난쟁이들의 키를 담은 배열
    static int[] inputA;
    //9명의 키 합이 max가 되는  경우를 담은 배열
    static Vector<Integer> resultA;

    static void dfs(int index) {
        //7명의 난쟁이의 키가 결과배열에 담겼을때
        if (resultA.size() == 7) {
            int sum = 0;
            for (int i = 0; i < resultA.size(); i++) {
                sum += resultA.get(i);
            }
            //7명의 키의 합이 100이면
            if (sum == 100) {
                //정렬해서 출력
                Collections.sort(resultA, new Comparator<Integer>() {
                    public int compare(Integer p1, Integer p2) {
                        if (p1 < p2) {
                            return -1;
                        } else if (p1 == p2) {
                            return Integer.compare(p1, p2);
                        } else {
                            return 1;
                        }
                    }
                });

                for (int i = 0; i < resultA.size(); i++) {
                    System.out.println(resultA.get(i));
                }
            }
            return;
        }
        
        //
        for (int i = index; i < 9; i++) {
            int flag = 0;
            for (int j = 0; j < resultA.size(); j++) {
                if (resultA.get(j) == inputA[i]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                resultA.add(inputA[i]);
                dfs(i);
                resultA.remove(resultA.size() - 1); 
            }
            
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //총 난쟁이는 9명
        inputA= new int[9];
        //7명의 키의 합이 max 가 되는 경우를 담을 배열
        resultA = new Vector<Integer>();
        
        //주어진 아홉 난쟁이의 키를 담는다.
        for (int i = 0; i < 9; i++) {
            inputA[i] = Integer.parseInt(br.readLine());
        }
        //초기화
            dfs(0);
    }
}
