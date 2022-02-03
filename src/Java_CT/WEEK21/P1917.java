package WEEK21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class WEEK21 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        loc[][] typeA = new loc[4][4];
        loc[] typeA1 = new loc[6];
        typeA1[0] = new loc(0, 0);
        typeA1[1] = new loc(1, 0);
        typeA1[2] = new loc(1, 1);
        typeA1[3] = new loc(1, 2);
        typeA1[4] = new loc(1, 3);
        typeA1[5] = new loc(2, 0);

        loc[] typeA2 = new loc[6];
        typeA2[0] = new loc(0, 0);
        typeA2[1] = new loc(0, 1);
        typeA2[2] = new loc(0, 2);
        typeA2[3] = new loc(1, 1);
        typeA2[4] = new loc(2, 1);
        typeA2[5] = new loc(3, 1);

        loc[] typeA3 = new loc[6];
        typeA3[0] = new loc(1, 0);
        typeA3[1] = new loc(1, 1);
        typeA3[2] = new loc(1, 2);
        typeA3[3] = new loc(1, 3);
        typeA3[4] = new loc(0, 3);
        typeA3[5] = new loc(2, 3);

        loc[] typeA4 = new loc[6];
        typeA4[0] = new loc(0, 1);
        typeA4[1] = new loc(1, 1);
        typeA4[2] = new loc(2, 1);
        typeA4[3] = new loc(3, 1);
        typeA4[4] = new loc(3, 0);
        typeA4[5] = new loc(3, 2);

        typeA[0] = typeA1;
        typeA[1] = typeA2;
        typeA[2] = typeA3;
        typeA[3] = typeA4;

        loc[] typeB1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeB1[i] = new loc(typeA1[i].y, typeA1[i].x);
        }
        typeB1[0] = new loc(typeA1[0].y, typeA1[0].x + 1);

        loc[] typeB2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeB2[i] = new loc(typeA2[i].y, typeA2[i].x);
        }
        typeB2[2] = new loc(typeA2[2].y + 1, typeA2[2].x);

        loc[] typeB3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeB3[i] = new loc(typeA3[i].y, typeA3[i].x);
        }
        typeB3[5] = new loc(typeA3[5].y, typeA3[5].x - 1);

        loc[] typeB4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeB4[i] = new loc(typeA4[i].y, typeA4[i].x);
        }
        typeB4[4] = new loc(typeA4[4].y - 1, typeA4[4].x);

        loc[][] typeB = new loc[4][4];
        typeB[0] = typeB1;
        typeB[1] = typeB2;
        typeB[2] = typeB3;
        typeB[3] = typeB4;

        loc[] typeC1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeC1[i] = new loc(typeB1[i].y, typeB1[i].x);
        }
        typeC1[0] = new loc(typeB1[0].y, typeB1[0].x + 1);

        loc[] typeC2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeC2[i] = new loc(typeB2[i].y, typeB2[i].x);
        }
        typeC2[2] = new loc(typeB2[2].y + 1, typeB2[2].x);

        loc[] typeC3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeC3[i] = new loc(typeB3[i].y, typeB3[i].x);
        }
        typeC3[5] = new loc(typeB3[5].y, typeB3[5].x - 1);

        loc[] typeC4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeC4[i] = new loc(typeB4[i].y, typeB4[i].x);
        }
        typeC4[4] = new loc(typeB4[4].y - 1, typeB4[4].x);

        loc[][] typeC = new loc[4][4];
        typeC[0] = typeC1;
        typeC[1] = typeC2;
        typeC[2] = typeC3;
        typeC[3] = typeC4;
        //
        loc[] typeD1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeD1[i] = new loc(typeC1[i].y, typeC1[i].x);
        }
        typeD1[0] = new loc(typeC1[0].y, typeC1[0].x + 1);

        loc[] typeD2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeD2[i] = new loc(typeC2[i].y, typeC2[i].x);
        }
        typeD2[2] = new loc(typeC2[2].y + 1, typeC2[2].x);

        loc[] typeD3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeD3[i] = new loc(typeC3[i].y, typeC3[i].x);
        }
        typeD3[5] = new loc(typeC3[5].y, typeC3[5].x - 1);

        loc[] typeD4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeD4[i] = new loc(typeC4[i].y, typeC4[i].x);
        }
        typeD4[4] = new loc(typeC4[4].y - 1, typeC4[4].x);
        loc[][] typeD = new loc[4][4];
        typeD[0] = typeD1;
        typeD[1] = typeD2;
        typeD[2] = typeD3;
        typeD[3] = typeD4;
        // E
        loc[] typeE1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeE1[i] = new loc(typeB1[i].y, typeB1[i].x);
        }
        typeE1[5] = new loc(typeB1[5].y, typeB1[5].x + 1);

        loc[] typeE2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeE2[i] = new loc(typeB2[i].y, typeB2[i].x);
        }
        typeE2[0] = new loc(typeB2[0].y + 1, typeB2[0].x);

        loc[] typeE3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeE3[i] = new loc(typeB3[i].y, typeB3[i].x);
        }
        typeE3[4] = new loc(typeB3[4].y, typeB3[4].x - 1);

        loc[] typeE4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeE4[i] = new loc(typeB4[i].y, typeB4[i].x);
        }
        typeE4[5] = new loc(typeB4[5].y - 1, typeB4[5].x);
        loc[][] typeE = new loc[4][4];
        typeE[0] = typeE1;
        typeE[1] = typeE2;
        typeE[2] = typeE3;
        typeE[3] = typeE4;
        // F
        loc[] typeF1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeF1[i] = new loc(typeE1[i].y, typeE1[i].x);
        }
        typeF1[0] = new loc(typeE1[0].y, typeE1[0].x + 1);

        loc[] typeF2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeF2[i] = new loc(typeE2[i].y, typeE2[i].x);
        }
        typeF2[2] = new loc(typeE2[2].y + 1, typeE2[2].x);

        loc[] typeF3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeF3[i] = new loc(typeE3[i].y, typeE3[i].x);
        }
        typeF3[5] = new loc(typeE3[5].y, typeE3[5].x - 1);

        loc[] typeF4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeF4[i] = new loc(typeE4[i].y, typeE4[i].x);
        }
        typeF4[4] = new loc(typeE4[4].y - 1, typeE4[4].x);
        loc[][] typeF = new loc[4][4];
        typeF[0] = typeF1;
        typeF[1] = typeF2;
        typeF[2] = typeF3;
        typeF[3] = typeF4;

        // G
        loc[] typeG1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeG1[i] = new loc(typeF1[i].y, typeF1[i].x);
        }
        typeG1[1] = new loc(typeF1[1].y + 1, typeF1[1].x);
        typeG1[4] = new loc(typeF1[4].y - 1, typeF1[4].x);

        loc[] typeG2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeG2[i] = new loc(typeF2[i].y, typeF2[i].x);
        }
        typeG2[1] = new loc(typeF2[1].y, typeF2[1].x - 1);
        typeG2[5] = new loc(typeF2[5].y, typeF2[5].x + 1);

        loc[] typeG3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeG3[i] = new loc(typeG1[i].y, typeG1[i].x);
        }

        loc[] typeG4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeG4[i] = new loc(typeG2[i].y, typeG2[i].x);
        }
        loc[][] typeG = new loc[4][4];
        typeG[0] = typeG1;
        typeG[1] = typeG2;
        typeG[2] = typeG3;
        typeG[3] = typeG4;
        loc[] typeH1 = new loc[6];
        typeH1[0] = new loc(0, 2);
        typeH1[1] = new loc(0, 3);
        typeH1[2] = new loc(0, 4);
        typeH1[3] = new loc(1, 0);
        typeH1[4] = new loc(1, 1);
        typeH1[5] = new loc(1, 2);

        loc[] typeH2 = new loc[6];
        typeH2[0] = new loc(0, 0);
        typeH2[1] = new loc(1, 0);
        typeH2[2] = new loc(2, 0);
        typeH2[3] = new loc(2, 1);
        typeH2[4] = new loc(3, 1);
        typeH2[5] = new loc(4, 1);

        loc[] typeH3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeH3[i] = new loc(typeH1[i].y, typeH1[i].x);
        }

        loc[] typeH4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeH4[i] = new loc(typeH2[i].y, typeH2[i].x);
        }

        loc[][] typeH = new loc[4][4];
        typeH[0] = typeH1;
        typeH[1] = typeH2;
        typeH[2] = typeH3;
        typeH[3] = typeH4;

        loc[] typeI1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeI1[i] = new loc(typeC1[i].y, typeC1[i].x);
        }
        typeI1[4] = new loc(typeC1[4].y - 1, typeC1[4].x);

        loc[] typeI2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeI2[i] = new loc(typeC2[i].y, typeC2[i].x);
        }
        typeI2[5] = new loc(typeC2[5].y, typeC2[5].x + 1);

        loc[] typeI3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeI3[i] = new loc(typeC3[i].y, typeC3[i].x);
        }
        typeI3[0] = new loc(typeC3[0].y + 1, typeC3[0].x);

        loc[] typeI4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeI4[i] = new loc(typeC4[i].y, typeC4[i].x);
        }
        typeI4[0] = new loc(typeC4[0].y, typeC4[0].x - 1);
        loc[][] typeI = new loc[4][4];
        typeI[0] = typeI1;
        typeI[1] = typeI2;
        typeI[2] = typeI3;
        typeI[3] = typeI4;

        loc[] typeJ1 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeJ1[i] = new loc(typeE1[i].y, typeE1[i].x);
        }
        typeJ1[1] = new loc(typeE1[1].y - 1, typeE1[1].x);

        loc[] typeJ2 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeJ2[i] = new loc(typeE2[i].y, typeE2[i].x);
        }
        typeJ2[1] = new loc(typeE2[1].y, typeE2[1].x + 1);

        loc[] typeJ3 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeJ3[i] = new loc(typeE3[i].y, typeE3[i].x);
        }
        typeJ3[3] = new loc(typeE3[3].y + 1, typeE3[3].x);

        loc[] typeJ4 = new loc[6];
        for (int i = 0; i < 6; i++) {
            typeJ4[i] = new loc(typeE4[i].y, typeE4[i].x);
        }
        typeJ4[3] = new loc(typeE4[3].y, typeE4[3].x - 1);
        loc[][] typeJ = new loc[4][4];
        typeJ[0] = typeJ1;
        typeJ[1] = typeJ2;
        typeJ[2] = typeJ3;
        typeJ[3] = typeJ4;

        loc[] typeK1 = new loc[6];
        typeK1[0] = new loc(0, 1);
        typeK1[1] = new loc(1, 0);
        typeK1[2] = new loc(1, 1);
        typeK1[3] = new loc(1, 2);
        typeK1[4] = new loc(2, 2);
        typeK1[5] = new loc(2, 3);

        loc[] typeK2 = new loc[6];
        typeK2[0] = new loc(0, 1);
        typeK2[1] = new loc(1, 1);
        typeK2[2] = new loc(1, 2);
        typeK2[3] = new loc(2, 1);
        typeK2[4] = new loc(2, 0);
        typeK2[5] = new loc(3, 0);

        loc[] typeK3 = new loc[6];
        typeK3[0] = new loc(0, 0);
        typeK3[1] = new loc(0, 1);
        typeK3[2] = new loc(1, 1);
        typeK3[3] = new loc(1, 2);
        typeK3[4] = new loc(1, 3);
        typeK3[5] = new loc(2, 2);

        loc[] typeK4 = new loc[6];
        typeK4[0] = new loc(0, 2);
        typeK4[1] = new loc(1, 1);
        typeK4[2] = new loc(1, 2);
        typeK4[3] = new loc(2, 0);
        typeK4[4] = new loc(2, 1);
        typeK4[5] = new loc(3, 1);

        loc[][] typeK = new loc[4][4];
        typeK[0] = typeK1;
        typeK[1] = typeK2;
        typeK[2] = typeK3;
        typeK[3] = typeK4;
        // for (int a = 0; a < typeA.length; a++) {
        // for (int i = 0; i < 6; i++) {
        // for (int j = 0; j < 6; j++) {
        // int flag = 0;
        // for (loc loc : typeK[a]) {
        // if (loc.y == i && loc.x == j) {
        // flag = 1;
        // }
        // }
        // System.out.printf("%d ", flag);
        // }
        // System.out.println();
        // }
        // System.out.println();
        // }
        String in = null;
        int idx = 0;
        int[][] p = new int[6][6];
        int[][] rp = new int[6][6];

        int miny = 6;
        int minx = 6;

        int rminy = 6;
        int rminx = 6;

        loc[][][] temA = new loc[][][] { typeA, typeB, typeC, typeD, typeE, typeF, typeG, typeH, typeI, typeJ, typeK };
        int iidx = 0;
        while (iidx < 18) {
            in = br.readLine();
            iidx++;
            String[] tmp = in.split(" ");
            for (int i = 0; i < 6; i++) {
                p[idx][i] = Integer.parseInt(tmp[i]);
                rp[idx][5 - i] = Integer.parseInt(tmp[i]);
                if (p[idx][i] == 1) {
                    if (idx < miny)
                        miny = idx;
                    if (i < minx)
                        minx = i;
                }
                if (rp[idx][5 - i] == 1) {
                    if (idx < rminy)
                        rminy = idx;
                    if (5 - i < rminx)
                        rminx = 5 - i;
                }
            }
            if (idx == 5) {
                // System.out.println("s");
                // System.out.println(miny);
                // System.out.println(minx);
                // System.out.println(rminy);
                // System.out.println(rminx);

                int[][] cp = new int[6][6];
                int[][] cpr = new int[6][6];
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (p[i][j] == 1) {
                            // p[i][j] = 0;
                            cp[i - miny][j - minx] = 1;
                            // System.out.printf("i %d\n", i - miny);
                            // System.out.printf("j %d\n", j - minx);

                            // System.out.println(5 - (i - miny));
                            // System.out.println(5 - (j - minx));
                        }
                        if (rp[i][j] == 1) {
                            cpr[i - rminy][j - rminx] = 1;
                        }
                    }
                }
                // for (int a = 0; a < 6; a++) {
                // for (int b = 0; b < 6; b++) {
                // System.out.printf("%d", cpr[a][b]);
                // }
                // System.out.println();
                // }
                String flag = "no";
                for (int k = 0; k < temA.length; k++) {
                    for (int i = 0; i < 4; i++) {
                        int count = 0;
                        loc[] type = temA[k][i];
                        for (int j = 0; j < type.length; j++) {
                            loc l = type[j];
                            if (cp[l.y][l.x] == 1) {
                                count++;
                            }
                        }
                        if (count == 6) {
                            // System.out.println("k: " + k);
                            // System.out.println("i: " + i);

                            flag = "yes";
                            break;
                        }
                        count = 0;
                        for (int j = 0; j < type.length; j++) {
                            loc l = type[j];
                            if (cpr[l.y][l.x] == 1) {
                                count++;
                            }
                        }
                        if (count == 6) {
                            // System.out.println("k: " + k);
                            // System.out.println("i: " + i);
                            flag = "yes";
                            break;
                        }
                    }
                }

                System.out.println(flag);
                // for (int i = 0; i < 6; i++) {
                // for (int j = 0; j < 6; j++) {
                // System.out.printf("%d ", cp[i][j]);
                // }
                // System.out.println();
                // }
                idx = 0;
                minx = 6;
                miny = 6;
                rminx = 6;
                rminy = 6;

            } else
                idx++;
        }
    }

    static class loc {
        int y;
        int x;

        public loc(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}