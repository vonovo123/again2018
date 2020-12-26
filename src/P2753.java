import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2753 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int in = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = Integer.parseInt(br.readLine());
        int c1, c2, c3;
        c1 = in % 4;
        c2 = in % 100;
        c3 = in % 400;

        if ((c1 == 0 && c2 != 0) || c3 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0); 
        }
    }
}
