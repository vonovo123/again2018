package WEEK3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class P15649 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M; 
    static boolean[] visited;
    static Vector<Integer> v;
    //깊이 탐색
    static void dfs() throws IOException {
        //수열의 사이즈가 M이 되면 탐색 종료
        if (v.size() == M) {
            //일괄 출력을 위해 버퍼에 담음
            for (int j = 0; j < v.size(); j++) {
                if (j != v.size() - 1) {
                    bw.write(v.get(j) + " ");
                } else {
                    bw.write(v.get(j) + "\n");
                }
            }
            return;
        }
        //완전탐색
        for (int i = 1; i <= N; i++) {
            //방문한 곳이 아니면 
            if (!visited[i - 1]) {
                //방문
                visited[i - 1] = true;
                //수열에 넣고
                v.add(i);
                //다음 탐색진행
                dfs();
                //완전 탐색을 위한 백트레킹
                visited[i - 1] = false;
                v.remove(v.size() - 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        //1 부터 N 까지 자연수 중        
        N = Integer.parseInt(in[0]);
        //중복없이 M 개를 고른 수열
        M = Integer.parseInt(in[1]);
        //수열을 담을 vector
        v = new Vector<Integer>();
        //탐색 여부를 기록할 배열
        visited = new boolean[N];
        dfs();
        bw.flush();
        

    }
}
