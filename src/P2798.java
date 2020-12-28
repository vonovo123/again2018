import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2798 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    int[] V;
    int[][] al;
    boolean[] visitArr;
    int M;
    int max;

    P2798(int N, int[] V, int M) {
        this.N = N;
        al = new int[this.N + 1][this.N + 1];
        visitArr = new boolean[this.N + 1];
        this.V = V;
        this.M = M;
        this.max = 0;
    }

    void put(int x, int y) {
        al[x][y] = 1;

    }

    void DFSUtil(int v, boolean[] visiatArr, int step, int sum) {
        visiatArr[v] = true;
        step++;
        sum += V[v];
        if (step == 3) {
            if (sum <= M && sum > max) {
                this.max = sum;
            }
            return;
        }
        for (int i = 1; i < al[v].length; i++) {
            if ((al[v][i] == 1)) {
                DFSUtil(i, visiatArr, step, sum);
            }
        }
    }

    void DFS(int v) {
        DFSUtil(v, visitArr, 0, 0);
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] V = new int[N + 1];
        for (int i = 0; i < N; i++) {
            V[i + 1] = Integer.parseInt(input[i]);
        }
        // 설정부

        P2798 bj = new P2798(N, V, M);

        for (int i = 1; i < V.length; i++) {
            for (int j = i + 1; j < V.length; j++) {
                if (i == 1 && j == V.length - 1) {
                    continue;
                }
                bj.put(i, j);
            }
        }

        for (int i = 1; i < V.length; i++) {
            bj.DFS(i);
        }

        System.out.println(bj.max);

    }

}
