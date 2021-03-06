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
    //지정된 좌우 위치를 바꿈
    static void switchArrR(int i, int j) {
        if (iaa[i][j].equals(iaa[i][j + 1])) {
            return;
        }
        String tmp = null;
        tmp = iaa[i][j];
        iaa[i][j] = iaa[i][j + 1];
        iaa[i][j + 1] = tmp;

        
    }
    
    // 지정된 상하 위치를 바꿈
    static void switchArrC(int i, int j) {
        if (iaa[i][j].equals(iaa[i + 1][j])) {
            return;
        }
        String tmp = iaa[i][j];
        iaa[i][j] = iaa[i + 1][j];
        iaa[i + 1][j] = tmp;
    }
    
    // 같은열에 좌우로 인접한 같은 색이 몇개 있는지 탐색
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
    //같은행에 위아래로 인접한 같은 색이 몇개 있는지 탐색
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
        //보드의 크기
        N = Integer.parseInt(br.readLine());
        
        iaa = new String[N][N];
        //최대로 먹을 수 있는 사탕수
        int max = 0;

        // 사탕 배열
        for (int i = 0; i < N; i++) {
            iaa[i] = br.readLine().split("");
        }
        //바꾸지않은 상태에서 먹을 수 있는 사탕색상 탐색
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
        //배열내의 모든 각각 사탕을 좌우로 바꾼 후 최대로 먹을 수 있는 사탕 수 탐색 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                //좌우 위치 바꾸기
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
                //원복
                switchArrR(i, j);
            }
        }
        // 배열내의 모든 각각 사탕을 위아래로 바꾼 후 최대로 먹을 수 있는 사탕 수 탐색
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                //위아래로 바꾸기
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
                //원복
                switchArrC(i, j);
            }
        }
        System.out.println(max);
    }
}
