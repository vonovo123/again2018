package WEEK24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P14391 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] occ;
    static int N, M;
    static int MAX;
    static String[][] arr;

    static void dfs(int count, int limit, int n, int m) {// count : 1의 개수

        if (count == limit) { // 최대수 만큼 가로판정이 있으면 중지
            int ts = 0;
            int[][] check = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (check[i][j] == 0) {// 아직 방문하지 않은 위치면
                        if (occ[i][j] == 1) {// 세로판정일때
                            if (!"0".equals(arr[i][j])) {// 맨 앞자리기때문에 적힌 수가 0이 아닐때만 탐색
                                String tmp = "";
                                // 아래로 이동하면서 세로 판정이 이어지는 부분의 수를 합쳐 값을 만든다.
                                for (int k = 0; k < N - i; k++) {
                                    if (occ[i + k][j] == 1) {
                                        tmp += arr[i + k][j];// 숫자 만들기
                                        check[i + k][j] = 1; // 방문위치 처리
                                    } else {// 새로판정이 끊어지면 중지
                                        break;
                                    }
                                }
                                // 모든 부분의 합을 구한다
                                ts += Integer.parseInt(tmp);
                            }
                        } else {// 가로판정일때
                            if (!"0".equals(arr[i][j])) { // 맨 앞자리기때문에 적힌 수가 0이 아닐때만 탐색
                                String tmp = "";
                                // 오른쪽으로 이동하면서 가로 판정이 이어지는 부분까지의 숫자를 잇는다.
                                for (int k = 0; k < M - j; k++) {
                                    if (occ[i][j + k] == 0) {
                                        tmp += arr[i][j + k];// 숫자만들기
                                        check[i][j + k] = 1;// 방문처리
                                    } else {
                                        break;
                                    }

                                }
                                // 모든 부분의 합을 구한다
                                ts += Integer.parseInt(tmp);
                            }
                        }
                    }
                }
            }
            // 모든 부분의 합이 max 보다 크면 max는 모든 부분의 합(ts)
            if (ts > MAX)
                MAX = ts;
            return;
        }
        // 탐색한 위치의 다음 좌표부터 전체 탐색
        for (int i = n; i < N; i++) {
            for (int j = m; j < M; j++) {
                // 탐색할 좌표가 세로판정이 아니면
                if (occ[i][j] != 1) {
                    occ[i][j] = 1; // 세로판정으로 변경
                    int next = count + 1;// 세로판정인 부분의 수 + 1
                    dfs(next, limit, i, j); // 재귀 탐색
                    occ[i][j] = 0;// 백트레킹
                }
            }
            // y줄이 바뀌면 x는 0 부터 시작해야함.
            m = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        // 세로크기
        N = Integer.parseInt(tmp[0]);
        // 가로크기
        M = Integer.parseInt(tmp[1]);
        // 길이가 N / M 인 직사각형
        arr = new String[N][M];

        occ = new int[N][M];
        // 직사각형을 잘라 만들수 있는 최대값
        MAX = 0;
        for (int i = 0; i < N; i++) {
            String tmpS = br.readLine();
            // 초기 최대값은 모두 한칸으로 잘랐을때의 값
            MAX += Integer.parseInt(tmpS);
            arr[i] = tmpS.split("");
        }

        int total = N * M;
        // i : 가로로 자를수 있는 최대 수
        for (int i = 1; i <= total; i++) {
            dfs(0, i, 0, 0);
        }
        System.out.println(MAX);
    }
}
