package WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * 문제 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌
 * 아홉 명이었던 것이다.
 * 
 * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는,
 * 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
 * 
 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 * 
 * 입력 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며,
 * 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
 * 
 * 출력 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
 * 
 * 예제 입력 1 20 7 23 19 10 15 25 8 13 예제 출력 1 7 8 10 13 19 20 23
 * 
 * 
 * 
 */
public class P2309 {
    //난쟁이들의 키를 담은 배열
    static int[] inputA;
    //9명의 키 합이 max가 되는  경우를 담은 배열
    static Vector<Integer> resultA;

    static void dfs(int index) {
        if (resultA.size() == 7) {
            //0~6까지 모두 탐색했을때 sum이 max(100)이면 
            int sum = 0;
            for (int i = 0; i < resultA.size(); i++) {
                sum += resultA.get(i);
            }
            if (sum == 100) {
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
        //다음 depth 탐색
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
        //아홉난쟁이의 키를 담은 배열, 합이 되야하는 값 , 합이 100이 되는 조합을 담을 배열, 탐색해야하는 깊이, 임시값을 담을 배열

        for (int i = 0; i < 1; i++) {
            // 모든 경우를 출력하기 위해 임시값을 담을 배열
            dfs(i);
        }
    }
}
