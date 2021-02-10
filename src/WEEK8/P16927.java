package WEEK8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, R;
    static int[][] arr;
    static int[] count;
    static int t;
    static int stoi(String in) {
        return Integer.parseInt(in);
    }

    static void turn(int i) {
            int tmp = arr[i][i];
            for (int j = i; j < M - i - 1; j++) {
                arr[i][j] = arr[i][j + 1];
            }
            for (int j = i; j < N - i - 1; j++) {
                arr[j][M - i - 1] = arr[j + 1][M - i - 1];
            }

            for (int j = M - i - 1; j > i; j--) {
                arr[N - i - 1][j] = arr[N - i - 1][j - 1];
            }

            for (int j = N - i - 1; j > i + 1; j--) {
                arr[j][i] = arr[j - 1][i];
            }
            arr[i + 1][i] = tmp;
    }
    
    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = stoi(stk.nextToken());
        M = stoi(stk.nextToken());
        R = stoi(stk.nextToken());
        t = Math.min(N, M) / 2;
        arr = new int[N][M];
        count = new int[t];
        for (int i = 0; i < t; i++) {
            count[i] = (N - i * 2) * (M - i * 2) - (N - (i + 1) * 2) * (M - (i + 1) * 2);
        }

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = stoi(stk.nextToken());
            }
        }
       
        for (int i = 0; i < t; i++) {
            int r = R % count[i];
            for (int j = 0; j < r; j++) {
                turn(i);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j != M - 1) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print(arr[i][j]);
                }
                
            }
            System.out.println();
        }
    }
}
