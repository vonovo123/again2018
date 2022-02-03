package WEEK3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P2309_BITMASKING {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] inA = new int[9];
        //입력받기
        for (int i = 0; i < inA.length; i++) {
            inA[i] = Integer.parseInt(br.readLine());
        }

        //오름차순 정렬
        Arrays.sort(inA);

        //000000000 ~ 111111111 까지 탐색 ( 0: 키합산에 포함, 1 : 키합산에 미포함)
        for (int i = 0; i < (1 << 9); i++) {
            // 9자리의 비트마스크 중 1이 7개면(7명의 키)
            if (Integer.bitCount(i) == 7) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    //비트마스크중 1인 부분의 인덱스 j를 찾아서
                    if ((i & (1 << j)) > 0) {
                        //합한다.
                        sum += inA[j];
                    }
                }
                //그 합이 100이면
                if (sum == 100) {
                    for (int j = 0; j < 9; j++) {
                        //1에 해당하는 자리의 값을 모두 출력해준다.
                        if ((i & (1 << j)) > 0) {
                            System.out.println(inA[j]);
                        }
                    }
                    //case 하나만 찾으면 되기때문에 탐색 중단.
                    break; 
                }

            }

            
        }

    }
}
