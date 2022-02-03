package WEEK42;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Seg {
  static int [] tree;
  static int [] a;
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    solution();
    Vector v = new Vector<>();
    v.get
  } 
  static int init(int start, int end, int node){
    if(start == end){
      System.out.println("node" + node);
      System.out.println("start" + start);
      return tree[node] = a[start];
    }
    int mid = (start + end) / 2;
    return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
  }
  static void solution(){
    a = new int[]{1, 9, 3, 8, 4, 5, 5 ,9, 10, 3, 4, 5};
    tree = new int [4 * 12];
    //0, 11, 1
    init(0, 11, 1);

    for (int i : tree) {
      System.out.printf("%d ", i);
    }
    int a = 1;

    vv.
  }
}
