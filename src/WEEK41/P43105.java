package WEEK41;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class P43105 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
    //System.out.println(solution(jobs));
    int [][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    System.out.println(solution(triangle));
  }

  static int solution(int[][] triangle){
    if(triangle.length == 1) return triangle[0][0];
    for(int i = 1; i < triangle.length; i ++){
      triangle[i][0]  +=  triangle[i - 1][0];
      triangle[i][triangle[i].length - 1]  +=  triangle[i - 1][triangle[i - 1].length - 1];
      for(int j = 1; j < triangle[i].length - 1; j ++){
        //System.out.println("i : " + i);
        //System.out.println("j : " + j);
        triangle[i][j] +=  Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
      }
    }
    int max = 0;
    for(int i = 0; i < triangle[triangle.length - 1].length; i ++){
      //System.out.println(triangle[triangle.length - 1][i]);
      if(max < triangle[triangle.length - 1][i]) max = triangle[triangle.length - 1][i];
    }
    return max;
  }
}