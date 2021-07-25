package WEEK30;

import java.util.*;

public class Pr72410Reg {
    public static String solution(String new_id) {
        String newId = new_id.toLowerCase();
        newId = newId.replaceAll("[^-_.a-z0-9]", "");
        System.out.println(newId);
        newId = newId.replaceAll("[.]{2,}", ".");
        System.out.println(newId);
        newId = newId.replaceAll("^[.]|[.]$", "");
        System.out.println(newId);
        if (newId.length() == 0) {
            newId += "a";
        }
        if (newId.length() > 15) {
            newId = newId.substring(0, 15);
        }
        newId = newId.replaceAll("[.]$", "");

        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }
        String answer = newId;
        return answer;
    }

    public static void main(String[] args) {
        // solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(solution("abcdefghijklmn.p"));
        // solution("....");
    }
}
