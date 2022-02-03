package FASTCAMPUS.ALGO.D16;

import java.io.*;
import java.util.*;

public class P10825 {

  //N 명에 학생에 대한 국어,영어,수학점수가 주어진다.
  // 국어점수가 감소하는 순서
  // 국어점수가 같으면 영어점수가 증가하는 순서
  // 국어,영어점수가 같으면 수학점수가 증가하는 순서
  // 모두 같으면 이름이 사전순으로 증가하는 순서
  // 1 < N < 100000 Person [];
  // 1 < 점수 < 100 -> int
  // 1 < 이름길이 < 10 -> String
  // 정렬 시 100000 * log2 100000 = 1,600,000
    static int N, k, e, m;
    static String n;
    static Person[] persons;
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        persons = new Person[N];
        for(int i = 0; i < N; i ++){
          n = scan.next();
          k = scan.nextInt();
          e = scan.nextInt();
          m = scan.nextInt();
          persons[i] = new Person(n,k,e,m);
        }
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(persons);
        for (Person person : persons) {
          System.out.println(person.n);
        }
    }
    static class Person implements Comparable<Person>{
      String n;
      int k, e, m;
      Person(String n, int k, int e, int m ){
        this.n = n;
        this.k = k;
        this.e = e;
        this.m = m;
      }
      @Override
      public int compareTo(Person o) {
        if(this.k != o.k){
          return o.k - this.k;
        }
         if(this.e != o.e){
             return this.e - o.e;
        }
        if(this.m != o.m){
               return o.m - this.m;
        } 
        // int maxLength = this.n.length() < o.n.length() ? this.n.length(): o.n.length();
        // for(int i = 0; i < maxLength; i ++){
        //          if(this.n.charAt(i) != o.n.charAt(i)){
        //            return this.n.charAt(i) - o.n.charAt(i);
        //         }
        //     }
        return this.n.compareTo(o.n);
    }
    @Override
    public String toString() {
      System.out.println("toString");
      return "name : " + this.n + " korean : " + this.k + " math : " + this.m + " english : " + this.e + "\n";
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