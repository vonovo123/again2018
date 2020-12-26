import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int[] ia = new int[3];
        int index = 0; 
        int s = 0;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == ' ') {
                ia[index] = Integer.parseInt(in.substring(s, i));
                s = i + 1;
                index++;
            } else if (i == in.length() - 1) {
                ia[index] = ia[index] = Integer.parseInt(in.substring(s, i + 1));
            }
        }
        if (ia[0] < ia[1]) {
            if (ia[0] < ia[2]) { // 0 (1, 2)
                if (ia[1] < ia[2]) {
                    System.out.printf("%d %d %d", ia[0], ia[1], ia[2]);
                } else {
                    System.out.printf("%d %d %d", ia[0], ia[2], ia[1]);
                }
            } else {// 
                System.out.printf("%d %d %d", ia[2], ia[0], ia[1]);    
            }
        } else { // 1 < 0
            if (ia[2] < ia[1]) {
                System.out.printf("%d %d %d", ia[2], ia[1], ia[0]);
            } else { // 
                if (ia[2] < ia[0]) {
                    System.out.printf("%d %d %d", ia[1], ia[2], ia[0]);  
                } else {
                    System.out.printf("%d %d %d", ia[1], ia[0], ia[2]);
                }
            }
        }
    }
}
