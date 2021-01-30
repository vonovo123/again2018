package WEEK6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class P10973 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        //주어지는 순열의 길이
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        //순열
        Integer[] a = new Integer[tmp.length];
        int index = 0;
        for (String i : tmp) {
            a[index] = Integer.parseInt(i);
            index++;
        }
        //순열의 오른쪽 부터 내림차순으로 정렬된 부분순열의 왼쪽 끝 위치
        int e = N - 1;
        //순열의 오른쪽 끝부터 탐색
        for (int i = N - 1; i >= 0; i--) {
            //현재 부분순열 끝의 값보다 작으면 내림차순
            if (a[i] <= a[e])
                //왼쪽 끝의 위치는 탐색부 i 가 된다.
                e = i;
            //현재 부분순열의 끝의 값보다 크면 내림차순이 아님   
            else {
                //더이상 탐색하지 않는다.
                break;
            }
        }
        //왼쪽끝까지 내림차순으로 정렬돼있으면 오름차순이므로 -1 출력
        if (e == 0) {
            System.out.println(-1);
        } else {
            //s는 오른쪽 끝부터 이어진 내림차순 왼쪽끝 부분의 왼쪽요소의 위치
            int s = e - 1;
            //e 부터 순열의 끝까지의 부분순열을 왼쪽 내림차순으로 정렬한다
            Arrays.sort(a, e, N, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    // TODO Auto-generated method stub
                    return o2.compareTo(o1);
                }
            });
            //내림차순으로 정렬된 부분순열에서 a[s]의 값과 가장 작고 가깝운 값을 찾아 s와 위치를 변경한다
            for (int i = e; i < N; i++) {
                if (a[i] < a[s]) {
                    int temp = a[i];
                    a[i] = a[s];
                    a[s] = temp;
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                if (i == N - 1) {
                    System.out.println(a[i]);
                } else {
                    System.out.printf("%d ", a[i]);
                }
            }

    }
}
}