package WEEK30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Pr72410 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Vector<String> v;

    static void addVal(char c) {
        // 1단계
        if (c >= 65 && c <= 90) {
            // System.out.println("1: " + c);
            v.add(String.valueOf((char) (c + 32)));
        }
        // 2단계
        if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.') {
            if (c == '.') {
                // 3단계
                if (v.size() != 0) {
                    if (!v.get(v.size() - 1).equals(".")) {
                        v.add(String.valueOf(c));
                        // System.out.println("2: " + c);
                    } else {
                        v.add(String.valueOf(c));
                    }
                }

            } else {
                v.add(String.valueOf(c));
                // System.out.println("2: " + c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        v = new Vector<String>();
        String in = br.readLine();
        String[] new_id = in.split("");

        for (int i = 0; i < new_id.length; i++) {
            char input = new_id[i].charAt(0);
            addVal(input);
        }
        // for (int i = 0; i < v.size(); i++) {
        // System.out.println("v:" + v.get(i));
        // }

        // 4단계
        if (v.size() != 0 && v.get(0).equals(".")) {
            v.remove(0);
        }
        if (v.size() != 0 && v.get(v.size() - 1).equals(".")) {
            v.remove(v.size() - 1);
        }

        // 5단계
        if (v.size() == 0) {
            v.add(0, "a");
        }
        // 6단게
        while (v.size() > 15) {
            v.remove(v.size() - 1);
        }
        if (v.get(v.size() - 1).equals(".")) {
            v.remove(v.size() - 1);
        }

        // 7단계
        if (v.size() <= 2) {
            while (v.size() < 3) {
                v.add(v.get(v.size() - 1));
            }
        }

        for (int i = 0; i < v.size(); i++) {
            System.out.printf("%s", v.get(i));
        }

        System.out.println();
    }
}
