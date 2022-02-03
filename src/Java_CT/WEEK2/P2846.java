package WEEK2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2846 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int N; //상근이가 측정한 높이의 수
        int[] Pi; //측정한 높이
        // 입력부
        N = Integer.parseInt(br.readLine());
        String[]  tmp = br.readLine().split(" ");
        Pi = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            Pi[i] = Integer.parseInt(tmp[i]);
        }
        // 입력부 끝

        //이전 길이 오르막이었는지 여부
        int flag = 0;
        // 오르막길 시작, 끝, 연속되는 오르막길의 수, 오르막길의 크기
        int s = Pi[0], e = Pi[0], c = 0, result = 0;
        
        //측정한 2번째 높이 부터 끝까지 탐색
        for (int i = 1; i < Pi.length; i++) {
            //탐색한 길이 이전 길의 높이보다 높을 때(오르막 일때)
            if (Pi[i] > Pi[i - 1]) {
                //이전 길이 오르막이 아니었다면
                if (flag == 0) {
                    //오르막길의 시작을 이전 길로 기록한다.
                    s = Pi[i - 1];
                    flag = 1;
                }
                // 탐색한 길을 오르막길의 끝으로 기록한다.
                e = Pi[i];
                //오르막이 있었는지 판단하기 위해 오르막 갯수를 기록한다.
                c++;
                //탐색한 오르막길의 높이가 최대인지 판별하여 기록한다.
                if (e - s > result)
                    result = e - s;
                //오르막이 아니면 탐색한 길을 시작점으로 잡고 계속 탐색한다.        
            } else {
                flag = 0;
                s = Pi[i];
            }
        }
        //오르막이 한번도 나온적이 없으면 0 출력
        if (c == 0) {
            System.out.println(0);
        //있으면 나온 오르막중 높이 출력    
        } else {
            System.out.println(result);
        }
    }
}
