package WEEK32;

import java.util.Arrays;
import java.util.stream.LongStream;

public class P16928RAMDA {

    static int[] solution(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos)
                        .filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1)
                        - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count())
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op)).toArray();
    }

    public static void main(String[] args) {

        int[] lottos = new int[] { 44, 1, 0, 0, 31, 25 };
        int[] winNums = new int[] { 31, 10, 45, 1, 6, 19 };

        long max = Arrays.stream(lottos).filter(i -> Arrays.stream(winNums).anyMatch(j -> j == i) || i == 0).count();
        long min = Arrays.stream(lottos).filter(i -> Arrays.stream(winNums).anyMatch(j -> j == i)).count();
        LongStream ls = LongStream.of(max, min);
        int[] result = ls.mapToInt(v -> (int) (v > 6 ? v - 1 : v)).toArray();

    }
}
