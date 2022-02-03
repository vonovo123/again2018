package FASTCAMPUS.ALGO.D07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    //Factorial facto = new Factorial();
    //System.out.println(facto.reculsive(10));
    ArrayList<Integer> arr = new  ArrayList<Integer> ();
    for (int i = 0; i < 10; i++) {
      arr.add((int)(Math.random()*100));
    }

    // System.out.println(factoTest2(arr));
    //System.out.println(factoTest3(4));
    //System.out.println(dpTest1(10));
    // MergeSort mergeSort = new MergeSort();
    // arr = mergeSort.sort(arr);
    
    //QuickSort quickSort = new QuickSort();
    System.out.println(arr);
    QuickSortByPointer quickSortByPointer = new QuickSortByPointer(arr);
    quickSortByPointer.sort(0, arr.size() - 1);
    System.out.println(quickSortByPointer.arr);
    
  }
  static int factoTest2 (ArrayList<Integer> arr){
    if(arr.size() == 0){
      return 0;
    } else {
      return arr.get(0) + factoTest2(new ArrayList<Integer>(arr.subList(1, arr.size())));
    }
  }

  static int factoTest3 (int in){
    if (in == 1){
        return 1;
    } else if(in == 2){
      return 2;
    } else if( in == 3){
      return 4;
    } else {
      return factoTest3(in - 1) + factoTest3(in - 2) + factoTest3(in - 3); 
    }
  }

  static int dpTest1(int n){
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(0);
    arr.add(1);
    for(int i = 2; i <=n ; i ++){
      arr.add(arr.get(i - 2) + arr.get(i - 1));
    }
    return arr.get(n);
  }
}

class Factorial {
  public int reculsive (int in){
    System.out.println(in);
    if( in  > 1){
      return in * this.reculsive(in - 1);
    } else {
      return in;
    }
  }
}

class MergeSort{ 

  public ArrayList<Integer> mergeSplit(ArrayList<Integer> front, ArrayList<Integer> back ){
    ArrayList <Integer> arr = new ArrayList<Integer>();
    int frontPoint = 0;
    int backPoint = 0;
    while(front.size() > frontPoint && back.size() >  backPoint){
      if(front.get(frontPoint) < back.get(backPoint)){
        arr.add(front.get(frontPoint));
        frontPoint ++;
      } else {
        arr.add(back.get(backPoint));
        backPoint ++;
      }
    }

    while(front.size() > frontPoint){
      arr.add(front.get(frontPoint));
      frontPoint ++;
    }

    while(back.size() > backPoint){
      arr.add(back.get(backPoint));
      backPoint ++; 
    }

    return arr;
  }

  public ArrayList<Integer> sort(ArrayList<Integer> arr){
    if(arr.size() <= 1){
      return arr;
    }
    int start = 0, end = arr.size(), mid = (start + end) / 2;
    ArrayList <Integer> front = sort(new ArrayList<Integer>(arr.subList(start, mid)));
    ArrayList<Integer> back = sort(new ArrayList<Integer>(arr.subList(mid, end)));

    return this.mergeSplit(front, back);
  }
}

class QuickSort {
  public ArrayList<Integer> sortByArray(ArrayList<Integer> arr){
    System.out.println(arr);
    if(arr.size() <= 1){
      return arr;
    }
    int pivot = 0;
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    for(int i = 1; i < arr.size(); i ++){
      if(arr.get(i) <= arr.get(pivot)){
        left.add(arr.get(i));
      } else {
        right.add(arr.get(i));
      }
    }
    ArrayList<Integer> mergedArray = new ArrayList<Integer>();
    mergedArray.addAll(sortByArray(left));
    mergedArray.addAll(Arrays.asList(arr.get(pivot)));
    mergedArray.addAll(sortByArray(right));
    return mergedArray;
  }
}

class QuickSortByPointer {
  ArrayList <Integer> arr;
  QuickSortByPointer(ArrayList<Integer> arr){
    this.arr = arr;
  }
  public void sort(int start, int end){
    if(end - start <= 0){
      return;
    }
    int pivot = start;
    int left = start + 1;
    int right = end;
    while( left <= right ){
      while(left <= end && this.arr.get(left) <= this.arr.get(pivot)){
        left ++;
      }
      while(right > start && this.arr.get(right) >= this.arr.get(pivot)){
        right --;
      }
      //엇갈리지 않으면
      if(left <= right) {
        Collections.swap(this.arr, left, right);
      // 엇갈리면 
      } else {
        Collections.swap(this.arr, right, pivot);
      }
    }

    sort(start, right - 1);
    sort(right + 1, end);
  }
}
