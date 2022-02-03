package FASTCAMPUS.ALGO.D16;
import java.io.*;
import java.util.*;

public class P15970 {
    //시간 2초 2억번
    //메모리 512mb
    //직선위에 음이아닌 정수를 한 방향으로 N개의 점을 정렬
    //주어진 점의 위치는 모두 다르다.
    //각 점은 N개의 색중 하나를 가진다. 색은 편의상 1~N으로 칭한다.
    //점 p와 q를 연결하려는데 q는 p와 같은색을 가진점중 가장 가까운 점이다.
    //가까운 점이 두개면 아무거나 하나 고른다.
    //모든 점에 대해 같은색을 가진점은 항상 존재한다.
    //각각의 점 p에서 q까지의 거리의 합을 출력
    //최대 N 5000 정렬시 6만번 -> 가능
    //점의 위치 x와 점의 위치 y는 0 < x < 10^5의 크기이다 1 <= y <= N int
    //정답의 최대치
    //N이 5000일때
    //x(위치)의 최대값인 10^5 100000 만큼의 길이를 가진점이 2500쌍있다면
    //모든점간의 거리의 합은 5000 * 100000 ->500,000,000 => int로 커버가능하다.
    static int N;
    static Node[] A;
    static int sum;
    static class Node implements Comparable<Node>{
        int x;
        int color;
        
        Node (int x, int color){
            this.x = x;
            this.color = color;
        }
        @Override
        public int compareTo(Node o) {
            if(this.color == o.color){
                return this.x - o.x;
            } else{
                return this.color - o.color;
            }
        }
        
    }
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new Node[N];
        sum = 0;
        for(int i = 0; i < N; i ++){
            int x = scan.nextInt();
            int color = scan.nextInt();
            A[i] = new Node(x, color);
        }
        
   
    }  
    
    public static void main(String[] args) {
        input();
        solve();
    }
    public static void solve(){
        Arrays.sort(A);
        // for (Node node : A) {
        //     System.out.printf("[%d %d]", node.x, node.color);
        // }
        for(int i = 0; i < N; i ++){
            int left  = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if(i - 1 >= 0){
                if(A[i].color == A[i - 1].color){
                    left = Math.abs(A[i].x - A[i - 1].x);
                }
            }
            if(i + 1 < N){
                if(A[i].color == A[i + 1].color){
                    right = Math.abs(A[i].x - A[i + 1].x);
                }
            }

            if (left < right){
                //System.out.println("left: " + left);
                sum += left;
            } else {
                //System.out.println("right: " + right);
                sum += right;
            }
            
        }
        System.out.println(sum);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}