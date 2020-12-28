import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2846 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        String[] tmp;
        int [] pi;
        N = Integer.parseInt(br.readLine());
        tmp = br.readLine().split(" ");
        pi = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            pi[i] = Integer.parseInt(tmp[i]);
        }
        int flag = 0;
        int s = pi[0], e = pi[0], result = 0, c = 0;//오르막길 시작, 끝, 결과, 횟수
        
        for (int i = 1; i < pi.length; i++) {
            //오르막일때
            if (pi[i] > pi[i - 1]) {
                //최초인 경우 
                if (flag == 0) {
                    s = pi[i - 1];
                    flag = 1;
                }
                // 이미 오르막인 경우
                e = pi[i];
                c++;
                if (e - s > result)
                    result = e - s;
            } else {

                flag = 0;
                s = pi[i];
            }
        }
        if (c == 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
