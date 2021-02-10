package WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class P2529 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int K;// 부등호 수
    static String[] KA;// 부등호를 담을 배열
    static Vector<Integer> ia;//탐색한 수를 담는 배열
    static Long min = 9876543210L;//부등호 조건에 만족하는 최소값
    static Long max = 0L;//부등호 조건에 만족하는 최댓값
    

    static void DFSUtil() {
        //ia에 담긴 수의 개수가 주어진 부등호 보다 하나 많으면 탐색 끝
        if (ia.size() == K + 1) {
                String ans = "";
                // 크기비교를 위해
                // 배열 ia에 담긴 탐색한 수들을 빼서 문자열로 변환한다.
                for (int i : ia) {
                    ans += String.valueOf(i);
                }
                // 문자열로 변환한 수를 다시 Long 타입 수로 변환해 크기 비교한다.
                Long ansL = Long.parseLong(ans);
                // 최댓값, 최솟값과 크기비교 후 탐색 종료
                if (ansL > max)
                    max = ansL;
                if (ansL < min)
                    min = ansL;
            return;
        }
        //탐색
        for (int i = 0; i < 10; i++) {
            //이미 사용된 숫자인지를 판단하는 flag
            int flag = 0;
            //탐색한 수를 담은 배열 ia에 i에 담긴 수가 이미 존재하면 탐색하지 않는다.
            for (int j = 0; j < ia.size(); j++) {
                if (ia.get(j) == i) {
                    flag = 1;
                    break;
                }
            }
            //ia에 없는 수에 한하여 탐색
            if (flag == 0) {
                //ia의 맨앞 탐색이 아니라서 비교할 수가 있으면
                if (ia.size() != 0) {
                     // < 가 주어졌을때 앞의 값보다 큰 경우만 탐색 진행
                     if (KA[ia.size() - 1].equals("<")) {
                         if (ia.get(ia.size() - 1) < i) {
                             ia.add(i);
                             DFSUtil();
                             ia.remove(ia.size() - 1);
                         }
                    // < 가 주어졌을때 앞의 값보다 작은경우만 탐색 진행
                     } else {
                         if (ia.get(ia.size() - 1) > i) {
                             ia.add(i);
                             DFSUtil();
                             ia.remove(ia.size() - 1);
                         }
                     }
                 //ia의 맨앞을 정하는 경우는 부등호 비교할 필요 없이 다음 탐색     
                 } else {
                     ia.add(i);
                     DFSUtil();
                     ia.remove(ia.size() - 1);
                 }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        KA = br.readLine().split(" ");
        //탐색할 수의 개수는 부등호의 개수 K 보다 1 만큼 크다.
        ia = new Vector<Integer>();
        DFSUtil();
        //탐색 종료 후 조건에 해당하는 최댓값 출력
        System.out.println(max);
        //맨 앞자리에 0이 오는경우를 표현하기위해 분기
        if (min < Math.pow(10, K))
            System.out.println("0" + min);
        else 
            System.out.println(min);

    }

}
