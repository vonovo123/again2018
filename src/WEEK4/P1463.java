package WEEK4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] NA;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        NA = new int[N + 1];
        NA[1] = 0;
        for (int i = 2; i <= N; i++) {
            int tmp = NA[i - 1] + 1;
            if (i % 2 == 0) {
                tmp = tmp > NA[i / 2] + 1 ? NA[i / 2] + 1 : tmp;
            }
            if (i % 3 == 0) {
                tmp = tmp > NA[i / 3] + 1 ? NA[i / 3] + 1 : tmp;
            }
            NA[i] = tmp;
        }
        // for (int out : NA) {
        //     System.out.println(out);
        // }
            System.out.println(NA[N]);
    }
//1000000
}
