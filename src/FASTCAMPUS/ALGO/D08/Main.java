package FASTCAMPUS.ALGO.D08;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    
    for(int i = 0 ; i < 100; i ++){ 
      arr.add((int)(Math.random() * 100));
    }
    Collections.sort(arr);
    BinarySearch binarySearch = new BinarySearch();
    for(int i = 0 ; i < 100; i ++){ 
      System.out.println(binarySearch.search(arr, 0, arr.size() - 1, arr.get(i)));
    }
    

    
  }
}
class BinarySearch{
  public boolean search(ArrayList<Integer> arr, int start, int end,  int find){
    if(end - start == 0 ){
        if(arr.get(start) == find){
          return true;
        }
        return false;
    }
    int mid = (start + end) / 2;
    if(arr.get(mid) == find){
      return true;
    } else if(find < arr.get(mid)){
      return search(arr, start, mid - 1, find);
    } else {
      return search(arr, mid + 1, end, find);
    }    
  }
}