package WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2529 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K;// 부등호 수
    String[] KA;// 부등호를 담을 배열
    int[] ia; //탐색한 수를 담는 배열
    Long min = 9876543210L;//부등호 조건에 만족하는 최소값
    Long max = 0L;//부등호 조건에 만족하는 최댓값
    
    //생성자
    P2529(int K, String[] KA, int[] ia) {
        this.K = K;
        this.KA = KA;
        this.ia = ia;

    }

    void DFSUtil(int v, int step, int[] ia) {
        //탐색한 수 v를 배열에 step 번째에 담는다.
        ia[step] = v;
        //주어진 부등호 수 만큼 탐색했으면 (step = K) 탐색 종료
        if (step == K) {
            String ans = "";
            //크기비교를 위해
            //배열 ia에 담긴 탐색한 수들을 빼서 문자열로 변환한다.
            for (int i : ia) {
                ans += String.valueOf(i);
            }
            //문자열로 변환한 수를 다시 Long 타입 수로 변환해 크기 비교한다.
            Long ansL = Long.parseLong(ans);
            //최댓값, 최솟값과 크기비교 후 탐색 종료
            if (ansL > max)
                max = ansL;
            if (ansL < min)
                min = ansL;
            return;
        }
        //탐색
        for (int i = 0; i < 10; i++) {
            //이미 사용된 숫자인지를 판단하는 flag
            int used = 0;
            //탐색한 수를 담은 배열 ia에 i에 담긴 수가 이미 존재하면 탐색하지 않는다.
            for (int j = 0; j < step + 1; j++) {
                if (ia[j] == i) {
                    used = 1;
                    break;
                }
            }
            //ia에 없는 수에 한하여 탐색
            if (used == 0) {
                //step 번째 부등호가 < 이면 
                if (this.KA[step].equals("<")) {
                    //step번째 수가 다음 수 i 보다 작으면 계속 탐색 
                    if (ia[step] < i) {
                        DFSUtil(i, step + 1, ia);
                    //클 경우 탐색하지않음
                } else {
                    continue;
                }
                // step 번째 부등호가 > 이면    
                } else if (this.KA[step].equals(">")) {
                    // step번째 수가 다음 수 i 보다 크면 계속 탐색
                    if (v > i) {
                        DFSUtil(i, step + 1, ia);
                    //작을 경우 탐색하지 않음.
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }
    }

    // 첫번째 수를 v로 하여 step 0 부터 탐색 시작
    void DFS(int v) {
        DFSUtil(v, 0, ia);
    }

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        String[] KA = br.readLine().split(" ");
        //탐색할 수는 부등호의 갯수보다 1 만큼 크다.
        int[] ia = new int[K + 1];
        // 객체 초기화
        P2529 bj = new P2529(K, KA, ia);

        // 첫번째 수가 0 인 경우부터 탐색 시작 
        for (int i = 0; i < 10; i++) {
            bj.DFS(i);
        }
        //탐색 종료 후 조건에 해당하는 최댓값 출력
        System.out.println(bj.max);
        //맨 앞자리에 0이 오는경우를 표현하기위해 분기
        if (bj.min < Math.pow(10, K))
            System.out.println("0" + bj.min);
        else 
            System.out.println(bj.min);

    }

}