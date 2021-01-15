import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class P16935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, R;
    static int[][] inA;
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    
    static void command(String in){
        int[][] temp = new int[inA.length][inA[0].length];
        for (int i = 0; i < inA.length; i++) {
            for (int j = 0; j < inA[0].length; j++) {
                temp[i][j] = inA[i][j];
               
            }
        }
        if ("1".equals(in)) {
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    inA[i][j] = temp[temp.length - i - 1][j];
                }
            }
        } else if ("2".equals(in)) {
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    inA[i][j] = temp[i][temp[0].length - j - 1];
                }
            } 
        } else if ("3".equals(in)) {
            inA = new int[inA[0].length][inA.length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    inA[j][temp.length - i - 1] = temp[i][j];
                }
            }
        } else if ("4".equals(in)) {
            inA = new int[inA[0].length][inA.length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    inA[temp[0].length - j - 1][i] = temp[i][j];
                }
            }            
        } else if ("5".equals(in)) {
            inA = new int[inA.length][inA[0].length];
            int NP = inA.length / 2;
            int MP = inA[0].length / 2;

            for (int i = 0; i < inA.length; i++) {
                if (i < NP) {
                    for (int j = 0; j < inA[0].length; j++) {
                        //4 - > 1
                        if (j < MP) {
                            inA[i][j] = temp[i + NP][j];
                        //2
                        } else {
                            inA[i][j] = temp[i][j - MP];
                        }
                    }
                } else {
                    for (int j = 0; j < inA[0].length; j++) {
                        //4
                        if (j < MP) {
                            inA[i][j] = temp[i][j + MP];
                        //3
                    } else {
                            inA[i][j] = temp[i - NP][j];
                        }
                    }
                }
  
            }
        } else if("6".equals(in)) {
            inA = new int[inA.length][inA[0].length];
            int NP = inA.length / 2;
            int MP = inA[0].length / 2;

            for (int i = 0; i < inA.length; i++) {
                if (i < NP) {
                    for (int j = 0; j < inA[0].length; j++) {
                        //  1
                        if (j < MP) {
                            inA[i][j] = temp[i][j + MP];
                            // 2
                        } else {
                            inA[i][j] = temp[i + NP][j];
                        }
                    }
                } else {
                    for (int j = 0; j < inA[0].length; j++) {
                        // 4
                        if (j < MP) {
                            inA[i][j] = temp[i - NP][j];
                        // 3
                        } else {
                            inA[i][j] = temp[i][j - MP];
                        }
                    }
                }

            }
        }

    }
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        N = stoi(in[0]);
        M = stoi(in[1]);
        R = stoi(in[2]);
        inA = new int[N][M];

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                inA[i][j] = stoi(in[j]);
            }
        }

        in = br.readLine().split(" ");
        for (int i = 0; i < in.length; i++) {
            command(in[i]);
        }

        for (int i = 0; i < inA.length; i++) {
            for (int j = 0; j < inA[0].length; j++) {
                if (j != inA[0].length - 1)
                    System.out.printf("%d ", inA[i][j]);
                else 
                    System.out.println(inA[i][j]);
            }
        }
    }
}
