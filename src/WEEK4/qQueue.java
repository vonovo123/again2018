package WEEK4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class qQueue {
    int f_p = -1; // 맨 앞 요소의 위치
    int b_p = -1; // 맨 뒤 요소의 위치
    int[] arr;

    public qQueue(Integer size) {
        this.arr = new int[size];
    }

    public void push(Integer X) {
        arr[++b_p] = X;
    }

    public int pop() {
        if (f_p != b_p) {
            f_p++;
            return arr[f_p];
        }
        return -1;
    }

    public int size() {
        return b_p - f_p;
    }

    public int empty() {
        if (f_p != b_p) {
            return 0;
        }
        return 1;
    }

    public int front() {
        if (f_p != b_p) {
            return arr[f_p + 1];
        }
        return -1;
    }

    public int back() {
        if (f_p != b_p) {
            return arr[b_p];
        }
        return -1;
    }

    static qQueue q;
    static Method mt;
    static void Command(String[] com) throws Exception {
        if(com[0].equals("push")){
            mt = q.getClass().getMethod(com[0], Integer.class);
            mt.invoke(q, Integer.parseInt(com[1]));
        } else {
            mt = q.getClass().getMethod(com[0]);
            System.out.println(mt.invoke(q)); 
        }
    }

   
   

    public static void main(String[] args)
            throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Class<?> cls = Class.forName("WEEK4.qQueue");
        Constructor constructor = cls.getConstructor(Integer.class);
        q = (qQueue) constructor.newInstance(200000);
        
        for (int i = 0; i < N; i++) {
            String[] com = br.readLine().split(" ");
            Command(com);
        }
    }
}
