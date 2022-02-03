class Solution {
    public int[] solution(int[] answers) {
       int[] answer = null;
        int a = 0;
        int b = 0;
        int c = 0;
        int[] aa = { 1, 2, 3, 4, 5 };
        int[] ba = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] ca = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == aa[i % 5]) {
                a++;
            }
            if (answers[i] == ba[i % 8]) {
                b++;
            }
            if (answers[i] == ca[i % 10]) {
                c++;
            }
        }

        if (a != b && b != c && c != a) {
            answer = new int[1];
            answer[0] = a > b ? (c > a ? 3 : 1) : (b > c ? 2 : 3) ;
        } else {
            if (a == b && b == c && c == a) {
                answer = new int[] { 1, 2, 3 };
            } else {
                if (a == b) {
                    if (a < c) {
                        answer = new int[] { 3 };
                    } else {
                        answer = new int[] { 1, 2 };
                    }

                } else if (a == c) {
                    if (a < b) {
                        answer = new int[] { 2 };
                    } else {
                        answer = new int[] { 1, 3 };
                    }
                } else if (b == c) {
                    if (b < a) {
                        answer = new int[] { 1 };
                    } else {
                        answer = new int[] { 2, 3 };
                    }
                }
            }

        }
        return answer;
    }
}