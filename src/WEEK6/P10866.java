package WEEK6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] deck;
    static int p;

    static void push_front(int x) {
        int[] temp = Arrays.copyOfRange(deck, 0, p);
        deck[0] = x;
        for (int i = 0; i < p; i++) {
            deck[i + 1] = temp[i];
        }
        p++;
    }
    
    static void push_back(int x) {
        deck[p++] = x;
    }

    static int pop_front() {
        if (p == 0)
            return -1;

        int pop = deck[0];
        int[] temp = Arrays.copyOfRange(deck, 1, p);
        for (int i = 0; i < temp.length; i++) {
            deck[i] = temp[i];
        }
        p--;
        return pop;
    }
 
    static int pop_back() {
        if (p == 0)
            return -1;

        int pop = deck[p - 1];
        p--;
        return pop;
    }

    static int size() {
        return p;
    }
    
    static int empty() {
        return p == 0 ? 1 : 0;
    }
    
    static int front() {
        if (p == 0)
            return -1;
        return deck[0];
    }
    
    static int back() {
        if (p == 0)
            return -1;
        return deck[p - 1];
    }
    public static void main(String[] args) {
        deck = new int[20000];
        p = 0;
        push_back(1);
        push_front(2);
        System.out.println(front());
        System.out.println(back());
        System.out.println(size());
        System.out.println(empty());
        System.out.println(pop_front());
        System.out.println(pop_back());
        System.out.println(pop_front());
        System.out.println(size());
        System.out.println(empty());
        System.out.println(pop_back());
        push_front(3);
        System.out.println(empty()); 
        System.out.println(front()); 

    }
}
