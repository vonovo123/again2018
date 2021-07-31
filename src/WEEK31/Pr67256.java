package WEEK31;

public class Main {
    public static void main(String[] args) {

        int[][] cell = new int[][] { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 },
                { 2, 1 }, { 2, 2 }, { 3, 0 }, { 3, 2 } }; // 10: *, 11:#
        String hand = "right";
        String cHand = hand.valueOf(0).toUpperCase();
        // int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };// "LRLLLRLLRRL"
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };// "LRLLLRLLRRL"

        // LRLL
        int left = 10;
        int right = 11;
        String answer = "";
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 1) {
                answer += "L";
                left = numbers[i];
            } else if (numbers[i] != 0 && numbers[i] % 3 == 0) {
                answer += "R";
                right = numbers[i];
            } else {
                int npy = cell[numbers[i]][0];
                int npx = cell[numbers[i]][1];
                int lpy = cell[left][0];
                int lpx = cell[left][1];
                int rpy = cell[right][0];
                int rpx = cell[right][1];

                int ld = Math.abs(npy - lpy) + Math.abs(npx - lpx);
                int rd = Math.abs(npy - rpy) + Math.abs(npx - rpx);
                if (numbers[i] == 0) {
                    System.out.println(npy);
                    System.out.println(npx);
                    System.out.println(lpy);
                    System.out.println(lpx);
                    System.out.println(rpy);
                    System.out.println(rpx);
                }
                if (ld < rd) {
                    answer += "L";
                    left = numbers[i];
                } else if (rd < ld) {
                    answer += "R";
                    right = numbers[i];
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = numbers[i];
                    } else {
                        answer += "R";
                        right = numbers[i];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
