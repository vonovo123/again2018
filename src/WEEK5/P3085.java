package WEEK5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P3085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] iaa;
    static int N;

    static void switchArrR(int i, int j) {
        if (iaa[i][j].equals(iaa[i][j + 1])) {
            return;
        }
        String tmp = null;
        tmp = iaa[i][j];
        iaa[i][j] = iaa[i][j + 1];
        iaa[i][j + 1] = tmp;

        
    }
    
    static void switchArrC(int i, int j) {
        if (iaa[i][j].equals(iaa[i + 1][j])) {
            return;
        }
        String tmp = iaa[i][j];
        iaa[i][j] = iaa[i + 1][j];
        iaa[i + 1][j] = tmp;
    }
    
    static int searchR(int c, int r) {
        int count = 0;
        for (int i = r; i < N; i++) {
            if (iaa[c][i].equals(iaa[c][r])) {
                count++;
            } else {
                break;
            }
        }
        for (int i = r - 1; i > 0; i--) {
            if (iaa[c][i].equals(iaa[c][r])) {
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
    
    static int searchC(int c, int r) {
        int count = 0;
        for (int i = c; i < N; i++) {
            if (iaa[i][r].equals(iaa[c][r])) {
                count++;
            } else {
                break;
            }
        }
        for (int i = c - 1; i > 0; i--) {
            if (iaa[i][r].equals(iaa[c][r])) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
         N = Integer.parseInt(br.readLine());
        iaa = new String[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            iaa[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int result = searchR(i, j);
                if (max < result)
                    max = result;
                result = searchC(i, j);
                if (max < result)
                    max = result;  
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                switchArrR(i, j);
                for (int a = 0; a < N; a++) {
                    for (int b = 0; b < N; b++) {
                        int result = searchR(a, b);
                        if (max < result)
                            max = result;
                        result = searchC(a, b);
                        if (max < result)
                            max = result;
                    }
                }
                switchArrR(i, j);
            }
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                switchArrC(i, j);
                for (int a = 0; a < N; a++) {
                    for (int b = 0; b < N; b++) {
                        int result = searchR(a, b);
                        if (max < result)
                            max = result;
                        result = searchC(a, b);
                        if (max < result)
                            max = result;
                    }
                }
                switchArrC(i, j);
            }
        }
        System.out.println(max);
    }
}
