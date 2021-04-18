package WEEK4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;

public class P10845 {
    static qQueue q;
    static Method mt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        q = new qQueue(10000);
        for (int i = 0; i < N; i++) {
            Command(br.readLine().split(" "));
        }
        bw.flush();

    }

    static void Command(String[] com) throws Exception {
        if (com[0].equals("push")) {
            mt = q.getClass().getMethod(com[0], Integer.class);
            mt.invoke(q, Integer.parseInt(com[1]));
        } else {
            mt = q.getClass().getMethod(com[0]);
            // System.out.println(mt.invoke(q));
            bw.write(mt.invoke(q).toString() + "\n");

        }
    }
}

class qQueue {
    int f_p = -1; // 앞 포인터
    int b_p = -1; // 뒷 포인터
    int[] arr; // queue 내부 배열
    // 크기와 함께 초기화

    public qQueue(Integer size) {
        this.arr = new int[size];
    }

    // 넣기 뒷 포인터를 하나 올리고 뒷포인터 자리에 수를 넣는다.
    public void push(Integer X) {
        arr[++b_p] = X;
    }

    // 큐의 가장앞에있는 수를 뺀다.
    public int pop() {
        // 큐 안에 수가 있으면
        if (f_p != b_p) {
            // 포인터를 하나 높이고 포인터 앞에 잇는 수를 반환한다.
            f_p++;
            return arr[f_p];
        }
        // 큐에 수가 없는경우 -1
        return -1;
    }

    // 뒷 포인터와 앞포인터 사이의 거리를 출력한다
    public int size() {
        return b_p - f_p;
    }

    // 앞 포인터와 뒷 포인터의 거리가 같으면 (수가 없으면) 0 출력
    public int empty() {
        if (f_p != b_p) {
            return 0;
        }
        return 1;
    }

    // 수가 존재하면 앞 포인터 뒤에 있는 수를 출력한다
    public int front() {
        if (f_p != b_p) {
            return arr[f_p + 1];
        }
        return -1;
    }

    // 수가 존재하면 뒷 포인터 자리의 수를 반환한다.
    public int back() {
        if (f_p != b_p) {
            return arr[b_p];
        }
        return -1;
    }
}
