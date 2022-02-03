package FASTCAMPUS.ALGO.D20;
import java.io.*;
import java.util.*;

public class P2251 {
    static int A, B, C, _A, _B, _C;
    static int [][][] Array;
    static void input() {
        FastReader scan = new FastReader();
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
        _A = 0;
        _B = 0;
        _C = C;
        Array = new int [A + 1][B + 1][C + 1];
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static void pro(){
        dfs(_A,_B,_C);
    }
    static void dfs(int _A, int _B, int _C){

        if(_A == 0){
            System.out.printf("_A : %d _B : %d _C :%d\n", _A, _B, _C);
        }
        
        //if(Array[_A][_B][_C] == 0) {
            Array[_A][_B][_C] = 1;
        //}
        int nA,nB,nC;
        //A->B 
        if(_A + _B > B){
            nA = (_A + _B) - B;
            nB = B;
        } else {
            nA = 0;
            nB = _A + _B;
        }
        nC = _C;
        if(Array[nA][nB][nC] == 0) {
            // System.out.println("A->B");
            // System.out.printf("_A : %d _B : %d _C :%d\n", _A, _B, _C);
            // System.out.printf("nA : %d nB : %d nC :%d\n", nA, nB, nC);
            // System.out.println();
            dfs(nA,nB,nC);
        }
        //A->C
        if(_A + _C > C){
            nA = (_A + _C) - C;
            nC = C;
        } else {
            nA = 0;
            nC = _A + _C;
        }
        nB = _B;
        if(Array[nA][nB][nC] == 0) {
            // System.out.println("A->C");
            // System.out.printf("_A : %d _B : %d _C :%d\n", _A, _B, _C);
            // System.out.printf("nA : %d nB : %d nC :%d\n", nA, nB, nC);
            // System.out.println();
            dfs(nA,nB,nC);
        }
        //B->A
        if(_B + _A > A){
            nB = (_B + _A) - A;
            nA = A;
        } else {
            nB = 0;
            nA = _B + _A;
        }
        nC = _C;
        if(Array[nA][nB][nC] == 0) {
            // System.out.println("B->A");
            // System.out.printf("_A : %d _B : %d _C :%d\n", _A, _B, _C);
            // System.out.printf("nA : %d nB : %d nC :%d\n", nA, nB, nC);
            // System.out.println();
            dfs(nA,nB,nC);
        }
        //B->C
        if(_B + _C > C){
            nB = (_B + _C) - C;
            nC = C;
        } else {
            nB = 0;
            nC = _B + _C;
        }
        nA = _A;
        if(Array[nA][nB][nC] == 0) {
            // System.out.println("B->C");
            // System.out.printf("_A : %d _B : %d _C :%d\n", _A, _B, _C);
            // System.out.printf("nA : %d nB : %d nC :%d\n", nA, nB, nC);
            // System.out.println();
            dfs(nA,nB,nC);
        }
        //C->A
        if(_C + _A > A){
            nC = (_C + _A) - A;
            nA = A;
        } else {
            nC = 0;
            nA = _C + _A;
        }
        nB = _B;
        if(Array[nA][nB][nC] == 0) {
            // System.out.println("C->A");
            // System.out.printf("_A : %d _B : %d _C :%d\n", _A, _B, _C);
            // System.out.printf("nA : %d nB : %d nC :%d\n", nA, nB, nC);
            // System.out.println();
            dfs(nA,nB,nC);
        }
        //C->B
        if(_C + _B > B){
            nC = (_C + _B) - B;
            nB = B;
        } else {
            nC = 0;
            nB = _C + _B;
        }
        nA = _A;
        if(Array[nA][nB][nC] == 0) {
            // System.out.println("C->B");
            // System.out.printf("_A : %d _B : %d _C :%d\n", _A, _B, _C);
            // System.out.printf("nA : %d nB : %d nC :%d\n", nA, nB, nC);
            // System.out.println();
            dfs(nA,nB,nC);
        }
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