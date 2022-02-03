package WEEK19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2290 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stk.nextToken());
        String n = stk.nextToken();
        String[] tmp = n.split("");
        int v, h, size;
        size = tmp.length;
        int[] na = new int[size];
        for (int i = 0; i < size; i++) {
            na[i] = Integer.parseInt(tmp[i]);
        }
        v = s + 2;
        h = 2 * s + 3;
        // 가로줄 : 0, (h - 1) / 2 , h - 1

        // String[] blocks = new String[] { " ", " -- ", "| ", " |", "| |" };
        String[] blocks = makeBlock(v);

        // for (int i = 0; i < blocks.length; i++) {
        // System.out.println(blocks[i]);
        // }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < na.length; j++) {
                if (i == 0) {
                    if (na[j] == 1 || na[j] == 4) {
                        bw.write(blocks[0]);
                    } else {
                        bw.write(blocks[1]);
                    }
                } else if (i == (h - 1) / 2) {
                    if (na[j] == 1 || na[j] == 0 || na[j] == 7) {
                        bw.write(blocks[0]);
                    } else {
                        bw.write(blocks[1]);
                    }
                } else if (i == h - 1) {
                    if (na[j] == 1 || na[j] == 4 || na[j] == 7) {
                        bw.write(blocks[0]);
                    } else {
                        bw.write(blocks[1]);
                    }
                } else {
                    if (i < (h - 1) / 2) {
                        if (na[j] == 1 || na[j] == 2 || na[j] == 3 || na[j] == 7) {
                            bw.write(blocks[3]);
                        } else if (na[j] == 5 || na[j] == 6) {
                            bw.write(blocks[2]);
                        } else {
                            bw.write(blocks[4]);
                        }
                    } else {
                        if (na[j] == 1 || na[j] == 3 || na[j] == 4 || na[j] == 5 || na[j] == 7 || na[j] == 9) {
                            bw.write(blocks[3]);
                        } else if (na[j] == 2) {
                            bw.write(blocks[2]);
                        } else {
                            bw.write(blocks[4]);
                        }
                    }

                }

                // 한글자 쓰고나서 처리
                if (j == na.length - 1) {
                    bw.write("\n");
                } else {
                    bw.write(" ");
                }
            }
        }
        bw.flush();
    }

    static String[] makeBlock(int v) {
        String[] blocks = new String[5];
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";

        for (int i = 0; i < v; i++) {
            a += " ";

            if (i == 0 || i == v - 1) {
                b += " ";
                e += "|";
            } else {
                b += "-";
                e += " ";
            }

            if (i == 0) {
                c += "|";
            } else {
                c += " ";
            }

            if (i == v - 1) {
                d += "|";
            } else {
                d += " ";
            }
        }
        blocks[0] = a;
        blocks[1] = b;
        blocks[2] = c;
        blocks[3] = d;
        blocks[4] = e;

        return blocks;
    }
}
