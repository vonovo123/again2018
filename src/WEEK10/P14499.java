package WEEK10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int stoi(String in){
        return Integer.parseInt(in);
    }
    public static void main(String[] args) throws IOException {
        int N, M, x, y, K;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = stoi(stk.nextToken());
        M = stoi(stk.nextToken());
        x = stoi(stk.nextToken());
        y = stoi(stk.nextToken());
        K = stoi(stk.nextToken());
        int[][] field = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < tmp.length; j ++){
                field[i][j] = stoi(tmp[j]);
            }
        }

        String[] command = new String[K];
        
        command = br.readLine().split(" ");
        // 0: top
        // 1: bottom
        // 2: north
        // 3: east
        // 4: south
        // 5: west
        int[] dir = new int[6];
        for (int i = 0; i < K; i++) {
            String com = command[i];
            int tmp = dir[1];
            if (com.equals("1")) { //동쪽으로 이동
                if (y + 1 < M) {
                    y += 1; //현재 위치를 동쪽으로 하나 이동 
                    //동쪽은 바닦
                    dir[1] = dir[3];
                    if (field[x][y] == 0) {
                        field[x][y] = dir[1];
                    } else {// 0이 아닌경우
                        dir[1] = field[x][y];
                        field[x][y] = 0;
                    }
                    //탑은 동쪽
                    dir[3] = dir[0];
                    //서쪽은 탑
                    dir[0] = dir[5];
                    //바닦은 서쪽
                    dir[5] = tmp;
                    System.out.println(dir[0]);
                }
            } else if (com.equals("2")) { //서쪽으로 이동
                if (y - 1 >= 0) {
                    y -= 1; // 현재 위치를 서쪽으로 하나 이동
                    // 서쪽은 바닦
                    dir[1] = dir[5];
                    if (field[x][y] == 0) {
                        field[x][y] = dir[1];
                    } else {// 0이 아닌경우
                        dir[1] = field[x][y];
                        field[x][y] = 0;
                    }
                    // 탑은 서쪽
                    dir[5] = dir[0];
                    // 동쪽은 탑
                    dir[0] = dir[3];
                    // 바닦은 동쪽
                    dir[3] = tmp;
                    System.out.println(dir[0]);
                }
            } else if (com.equals("3")) { //북쪽으로
                if (x - 1 >= 0) {
                    x -= 1;
                    // 북쪽은 바닦
                     dir[1] = dir[2];
                    if (field[x][y] == 0) {
                        field[x][y] = dir[1];
                    } else {// 0이 아닌경우
                        dir[1] = field[x][y];
                        field[x][y] = 0;
                    }
                    // 탑은 북쪽
                    dir[2] = dir[0];
                    // 남쪽은 탑
                    dir[0] = dir[4];
                    // 바닦은 남쪽
                    dir[4] = tmp;
                    System.out.println(dir[0]);
                }
            } else if (com.equals("4")) { //남쪽
                 if (x + 1 < N) {
                    x += 1;
                    // 남쪽은 바닦
                    dir[1] = dir[4];
                    if (field[x][y] == 0) {
                        field[x][y] = dir[1];
                    } else {// 0이 아닌경우
                        dir[1] = field[x][y];
                        field[x][y] = 0;
                    }
                    // 탑은 남쪽
                    dir[4] = dir[0];
                    // 북쪽은 탑
                    dir[0] = dir[2];
                    // 바닦은 남쪽
                    dir[2] = tmp;
                    System.out.println(dir[0]);
                }
             }
        }

        
    }
}
