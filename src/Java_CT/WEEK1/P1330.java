package WEEK1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        String in = br.readLine();
        char[] ca = in.toCharArray();
        int index = 0;
        for (char p : ca) {
            if (p != ' ')
                index++;
            else
                break;
        }
        a = Integer.parseInt(in.substring(0, index));
        b = Integer.parseInt(in.substring(index + 1, in.length()));  
        if (a < b)
            System.out.println("<");
        else if ( a > b)
            System.out.println(">");
        else
            System.out.println("==");
    }
}
