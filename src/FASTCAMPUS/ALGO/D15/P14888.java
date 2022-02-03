package FASTCAMPUS.ALGO.D15;

import java.util.*;
import java.io.*;
public class P14888 {
    /**
     *  연산자 끼워넣기
     * 입력
     * 1. N : 수의 개수 (2<=N<=11)
     * 2. A1,A2...An-1 : 연산 할 N개의 수 ( 1<= Ai < 100 )
     * 3. 각 사칙연산의 수 ( N-1개)
     * 
     * 
     * 출력
     * int의 범위 : -21억 ~ 21억
     * 1. 주어진 조건으로 만들수 있는 최소값 (-10억<= min <= 10억)
     * 2. 주어진 조건으로 만들수 있는 최대값 (-10억<= max <= 10억)
     */
    static int N, max, min;
    static int[] nums, operators, order;
    static StringBuilder sb;
  static void input() {
      FastReader scan = new FastReader();
      sb = new StringBuilder();
      N = scan.nextInt();
      nums = new int [N + 1];
      max = -100000000;
      min = 100000000;
      //연산할 수
      for(int i = 1; i <= N; i ++){
          nums[i] = scan.nextInt();
      }
      //operators = [0, 1:+, 2:- , 3:*, 4:/]
      //각 연산자의 수
      operators = new int [5];
      for(int i = 1; i <= 4; i ++){
          operators[i] = scan.nextInt();
      }
      //연산자(1개부터 N-1개 까지)
      order = new int [N];
  }
  public static void main(String[] args) {
      input();
      rec_func(1, nums[1]);
      System.out.println(max);
      System.out.println(min);
  }

  static int calculator(int value, int k, int operator){
        int next = nums[k + 1];
        switch(operator) {
            case 1 : value += next; break;
            case 2 : value -= next; break;
            case 3 : value *= next; break;
            case 4 : value /= next; break;
        }
    return value;
  }
  static void rec_func(int k, int value){
    if(k == N){
        if(min > value) min = value;
        if(max < value) max = value;
    } else {
        //더하기 부터 나누기 까지 조건에 맞게 넣기
        for(int i= 1; i <= 4; i ++){
            //넣을 수 있는 연산자가 남아있으면
            if(operators[i] > 0){
                operators[i] --;
                rec_func(k + 1, calculator(value, k, i));
                operators[i] ++;
            }
        }
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