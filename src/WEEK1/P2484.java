package WEEK1;

import java.io.BufferedReader;


public class P2484 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = 0;
        int R = 0;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int sum = 0;
            int[] ia = new int[7];
            String t = br.readLine();
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) != ' ') {
                    ia[t.charAt(j) - 48]++;
                }
            }
            int temp = 0;
            int cone = 0;
            for (int k = 1; k <= 6; k++) {
                if (ia[k] == 4) {
                    sum = 50000 + (k * 5000);
                    break;
                } else if (ia[k] == 3) {
                    sum = 10000 + (k * 1000);
                    break;
                } else if (ia[k] == 2) {
                    if (temp == 0) {
                        sum = 1000 + (k * 100);
                        temp = k;
                    } else {
                        sum = 2000 + (temp * 500) + (k * 500);
                        break;
                    }
                } else if (ia[k] == 1) {
                    cone++;
                    if( cone == 4)
                        sum = (k * 100);
                }
            }
            //System.out.printf("sum: %d\n", sum);
            if (R < sum)
                R = sum;
        }
        System.out.println(R);
    }
}
