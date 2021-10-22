package WEEK41;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class P42898 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
    //System.out.println(solution(jobs));
    int m = 4;
    int n = 3;
    int [][] puddles = {{2,2}};
    System.out.println(solution(m, n, puddles));
    
  }

  static int solution(int m, int n, int[][] puddles){
    int [][] load = new int [n][m];
    for(int i = 0; i < puddles.length; i ++){
      //물에 잠긴 지역 표시
      load[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
    }
    load[0][0] = 1;
    for(int i = 0; i < n; i ++){
      for(int j = 0; j < m; j ++){
         if(!(i == 0 && j == 0)){
        if(load[i][j] != -1){//침수지역이 아니면
            if(i > 0){
                if(load[i - 1][j] != -1){
                    load[i][j] += (load[i - 1][j]);
                    load[i][j] %= 1000000007;
                }
            }
            if(j > 0){
                if(load[i][j - 1] != -1){
                    load[i][j] += (load[i][j - 1] );
                    load[i][j] %= 1000000007;
                    }
                }   
            }

         }
      }
    }
    return load[n - 1][m - 1];
  }
}