package FASTCAMPUS.ALGO.D06;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<Integer>();

    for(int i = 0; i < 100; i ++){
      array.add((int)(Math.random() * 100));
    }
    BubbleSort bubbleSort = new BubbleSort();
    SelectionSort selectionSort = new SelectionSort();
    InsertionSort insertionSort = new InsertionSort();
    //array = bubbleSort.sort(array);
    //array = selectionSort.sort(array);
    array = insertionSort.sort(array);
    System.out.println(array);
  }
}
class BubbleSort {
  public ArrayList<Integer> sort (ArrayList<Integer> arr){
    for(int i = 0; i < arr.size() -1; i ++){
      boolean flag = false;
      for(int j = 0; j < arr.size() - 1 - i; j ++){
        if(arr.get(j) > arr.get(j + 1)){
            Collections.swap(arr, j, j + 1);
            flag = true;
        }
      }
      if(!flag) break;
    }
    return arr;
  }
}

class SelectionSort {
  public ArrayList<Integer> sort (ArrayList<Integer> arr){
    for(int i = 0; i < arr.size() - 1; i ++){
      int lowest = i;
      for(int j = i + 1; j < arr.size(); j ++){
        if(arr.get(lowest) > arr.get(j)){
          lowest = j;
        }
      }
      Collections.swap(arr, i, lowest);
    }
    return arr;
  }
}

class InsertionSort {
  public ArrayList<Integer> sort (ArrayList<Integer> arr){
    for(int i = 1; i < arr.size(); i ++){
      for(int j = i; j > 0; j --){
        if(arr.get(j) < arr.get(j - 1)){
          Collections.swap(arr, j, j - 1);
        } else {
          break;
        }
      }
    }
    return arr;
  }
}