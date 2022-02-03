package WEEK32;

public class Pr77484 {

    static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int same = 0;
        int blank = 0;
        for (int i : lottos) {
            if (i == 0)
                blank++;
            for (int j : win_nums) {
                if (i == j) {
                    same++;
                }
            }
        }
        // [최고, 최저]
        answer[0] = 7 - (same + blank);
        answer[1] = 7 - same;
        if (answer[0] > 6)
            answer[0] -= 1;
        if (answer[1] > 6)
            answer[1] -= 1;

        return answer;
    }

    public static void main(String[] args) {
        int[] answer;
        // [3, 5]
        answer = solution(new int[] { 44, 1, 0, 0, 31, 25 }, new int[] { 31, 10, 45, 1, 6, 19 });
        // [1, 6]
        // answer = solution(new int[] { 0, 0, 0, 0, 0, 0 }, new int[] { 38, 19, 20, 40,
        // 15, 25 });
        // [1, 1]
        // answer = solution(new int[] { 45, 4, 35, 20, 3, 9 }, new int[] { 20, 9, 3,
        // 45, 4, 35 });
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
