package WEEK31;

import java.util.LinkedList;

public class ZUMCTP3 {
    public static void main(String[] args) {
        // 인쇄 또는 대기없으면 즉출
        // 인쇄 대기있으면 뒤로추가
        // 인쇄중 끝나면 뒤로추가
        // 페이지수가 적은것
        // 페이지수가 같을 경우 먼저요청된것
        // 페이지수/ 시간이 모두 같을 경우 새로 추가후 다시 비교
        // 한페이지 출력 소요시간 1초
        // [1, 0, 5],[2, 2, 2],[3, 3, 1],[4, 4, 1],[5, 10, 2]
        // 번호 인쇄 요청시각 페이지수
        // int[][] data = { { 1, 0, 5 }, { 2, 2, 2 }, { 3, 3, 1 }, { 4, 4, 1 }, { 5, 10,
        // 2 } };
        // int[][] data = { { 1, 0, 3 }, { 2, 1, 3 }, { 3, 3, 2 }, { 4, 9, 1 }, { 5, 10,
        // 2 } };
        int[][] data = { { 1, 2, 10 }, { 2, 5, 8 }, { 3, 6, 9 }, { 4, 20, 6 }, { 5, 25, 5 } };
        int[] answer = {};
        LinkedList<int[]> list = new LinkedList<>();
        LinkedList<int[]> waiting = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }

        // 시작

        // int[] working = null;
        // 시간
        int time = 0;
        while (list.size() != 0) {
            // 다음작업 인덱스
            int minIdx = 0;
            waiting.add(list.remove(minIdx));
            while (waiting.size() != 0) {
                int[] working = waiting.remove(minIdx);
                // 대기열 없는 상태에서 첫 작업일 경우 전체시작시간은 요청시작시간으로 바로 이동
                if (time < working[1]) {
                    time = working[1];
                }
                System.out.printf("return: %d %d %d %d\n", working[0], working[1], working[2], time);
                // 한장씩 출력하면서 시간에 맞게 요청 추가
                for (int i = 0; i < working[2]; i++) {
                    time++;
                    System.out.println(time);
                    for (int j = 0; j < data.length; j++) {
                        if (time == data[j][1]) {
                            waiting.add(data[j]);
                            list.remove(data[j]);
                        }
                    }
                }
                // 다음 출력대상 찾기
                minIdx = 0;
                for (int i = 0; i < waiting.size(); i++) {
                    if (waiting.get(i)[2] < waiting.get(minIdx)[2])
                        minIdx = i;
                }
                // System.out.println(minIdx);
            }

        }
    }
}
