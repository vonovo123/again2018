package WEEK41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P42628 {
public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String [] operations = {"I 16","D 1"};
    //String [] operations = {"I 7","I 5","I -5","D -1"};
    solution(operations);
  } 
  
  static int[] solution(String[] operations){
    Vector<Integer> v = new Vector<Integer>();
    int [] answer = {0,0};
    for (String operation : operations) {
      String[] s_operation = operation.split(" ");
      String command = s_operation[0];
      int value = Integer.parseInt(s_operation[1]);
      if(command.equals("I")){
        if(v.size() == 0){
          v.add(value);
        } else{
          for(int i = 0; i < v.size(); i ++){
            if(value <= v.get(i)){
               v.add(i, value);
               break; 
            }
          }
        }
      } else {
        if(value == -1){//최솟값 삭제
          v.remove(0);
        } else { //최댓값 삭제
          v.remove(v.size() - 1);
        }
      }
    }
    //v.add(0,1);
    //v.add(0,2);
    if(v.size() > 0){
      answer[0] = v.get(v.size() - 1);
      answer[1] = v.get(0);
    }
    System.out.println(v);
    return answer;
  }
}
