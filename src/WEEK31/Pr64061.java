package WEEK31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;


public class Pr64061 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int[][] board = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = new int[] { 1, 5, 3, 5, 1, 2, 1, 4 };
        int N = board.length;
        Vector<Integer>[] vBoard = new Vector[board.length];
        Vector<Integer> bagu = new Vector<Integer>();

        for (int i = 0; i < N; i++) {
            vBoard[i] = new Vector<Integer>();
            for (int j = 0; j < N; j++) {
                if (board[N - j - 1][i] != 0) {
                    vBoard[i].add(board[N - j - 1][i]);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i] - 1;
            if (vBoard[move].size() > 0) {
                int get = vBoard[move].remove(vBoard[move].size() - 1);
                if (bagu.size() != 0) {
                    if (get == bagu.get(bagu.size() - 1)) {
                        bagu.remove(bagu.size() - 1);
                        result += 2;
                    } else {
                        bagu.add(get);
                    }
                } else {
                    bagu.add(get);
                }
            }
        }
        System.out.println(result);

    }

}
