import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

class P1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K, N;
    static LinkedList<Integer> adj[];
    

    static void addEdge(int v, int w) {
        adj[v].add(w);
    };

    static int BFS(int t) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int checkCount[] = new int[100001];
        queue.add(t);//큐에 s를 넣는다.
        checkCount[t] = 1;
        while (queue.size() != 0) {
            int s = queue.poll(); //맨앞 요소를 꺼내고 지운다. 선입선출
            Iterator<Integer> i = adj[s].listIterator();// s 와 연결된 링크 모두 꺼냄
            while (i.hasNext()) {
                int n = i.next();
                if (n == K)
                    return checkCount[s];
                if (n >= 0 && n <= 100000) {
                    if (checkCount[n] == 0) {
                        //System.out.printf("n: %d\n", n);
                        queue.add(n); // 연결된 위치로 이동하도록 큐에 추가
                        checkCount[n] = checkCount[s] + 1; //해당 위치까지 가는대 걸린 시간(현위치(s)로 오는 시간  더하기 1)
                    } 
                }
  
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
         String in = br.readLine();
         String[] inA = in.split(" "); 
         N = Integer.parseInt(inA[0]);//언니 위치
         K = Integer.parseInt(inA[1]);//동생 위치
         // 동생이 언니보다 앞에 있으면 X-1 방법으로 N-K초 만큼가는방법 밖에 없음
         if (K <= N) {
             System.out.println(N - K);
             return;
         }
         // 너비우선 탐색을 위해 0 에서 N 으로 이동중 나올 수 있는 모든 지점의 갯수만큼의 LinkedList를 담을 수 있는 배열 생성.
         adj = new LinkedList[100001];
        
        //모든 지점이 각각의 링크를 가질수 있도록 linkedList를 할당한다.
        for (int i = 0; i <=100000; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        //지점 0은 최소 지점으로 1로만 이동할 수 있으므로 1개의 링크를 가진다.
        //지점 100000은 최대지점으로 -1로만 이동할 수 있으므로 1개의 링크를 가진다.
        //나머지 지점은 
        for (int i = 0; i <= K; i++) {
                addEdge(i, i - 1);
                addEdge(i, i + 1);
                addEdge(i, i * 2);
        }
        System.out.println(BFS(N)); 

        //   for (int i = 0; i <= K; i++) {
        //      System.out.printf("index : %d value %d\n", i, checkCount[i]);
        //  }
     }
}
