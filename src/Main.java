import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int in = 0;

    static void add(int x) {
        in = in | 1 << x - 1;
    }

    static void remove(int x) {
        // System.out.println("t: " + Integer.toBinaryString( ~(1 << x - 1)));
        in = in & ~(1 << x - 1);
    }

    static int check(int x) {
        if ((in & (1 << x - 1)) > 0) {
            return 1;
        }
        return 0;
    }

    static void toggle(int x) {
        if (check(x) == 1) {// 있으면{
            remove(x);
        } else {
            add(x);
        }
    }

    static void all() {
        for (int i = 0; i < 20; i++) {
            in = in | 1 << i;
        }
    }

    static void empty() {
        in = in & 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int M = Integer.parseInt(br.readLine());
        String[] cmdA;
        String cmd;
        int x = 0;
        for (int i = 0; i < M; i++) {
            cmdA = br.readLine().split(" ");
            cmd = cmdA[0];
            if (cmdA.length == 2) {
                x = Integer.parseInt(cmdA[1]);
            }

            if ("add".equals(cmd)) {
                add(x);
            } else if ("remove".equals(cmd)) {
                remove(x);
            } else if ("check".equals(cmd)) {
                bw.write(check(x) + "\n");
            } else if ("toggle".equals(cmd)) {
                toggle(x);
            } else if ("all".equals(cmd)) {
                all();
            } else {
                empty();
            }
        }
        bw.flush();
    }
}
