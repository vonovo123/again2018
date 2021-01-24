package WEEK1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2798 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N;//카드수
    int[] V;//카드담은 배열
    int M;//기준값
    int max;//최대값

    P2798(int N, int[] V, int M) {
        this.N = N;
        this.V = V;
        this.M = M;
        this.max = 0;
        

    }

    //배열 V 속의 v 번째 카드를 step + 1번째로 탐색하는 경우의 sum
    void DFSUtil(int v, int step, int sum) {
        // step + 1
        step++;
        //그때의 합
        sum += V[v];
        //마지막 3번째인경우
        if (step == 3) {
            //최대값인지 확인하고 탐색 종료
            if (sum <= M && sum > max) {
                this.max = sum;
                if(this.max == 21) System.out.println("v: " + V[v]);
            }
            return;
        }
        //V 배열 내의 v번째카드 다음 카드를 뽑는 경우 탐색
        for (int i = v + 1; i < N + 1; i++) {
            DFSUtil(i, step, sum);
        }
    }
    // 배열 V 속의 v번째 카드를 최초로 뽑는 경우부터 시작
    void DFS(int v) {
        DFSUtil(v, 0, 0);
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        //카드 수와 기준값을 담는다.
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] V = new int[N + 1];
        for (int i = 0; i < N; i++) {
            V[i + 1] = Integer.parseInt(input[i]);
        }
        // 객체 초기화
        P2798 bj = new P2798(N, V, M);

        //배열의 1 번 카드를 뽑는 경우부터 탐색 시작
        for (int i = 1; i < V.length; i++) {
            bj.DFS(i);
        }

        System.out.println(bj.max);

    }

}
