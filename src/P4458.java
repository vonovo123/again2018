import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4458 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String in;
        char zi;
        for (int i = 0; i < N; i++) {
            in = br.readLine();
            zi = in.charAt(0);
            if (zi >= 'a' && zi <= 'z') {
                zi = (char) (zi - 32);
                System.out.println(String.valueOf(zi) + in.substring(1));  
            } else {
                System.out.println(in);
            }

        }


    }
}
