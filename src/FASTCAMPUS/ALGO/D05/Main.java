package FASTCAMPUS.ALGO.D05;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    Heap heapTest = new Heap(15);
    heapTest.insert(10);
    heapTest.insert(8);
    heapTest.insert(5);
    heapTest.insert(4);
    heapTest.insert(20);
    heapTest.printAll();
    heapTest.pop();
    heapTest.printAll();
  
  }
}

class Heap{
  private ArrayList<Integer> heapArray = null;
  public void printAll(){
      System.out.println(this.heapArray); 
  }
  Heap(Integer data){
    heapArray = new ArrayList<Integer>();
    heapArray.add(null); //0번 인덱스는 null;
    //헤더
    heapArray.add(data);
  }
  public boolean move_up (Integer inserted_id){
    //rootNode
    if(inserted_id == 1){
      return false;
    }
    Integer parent_idx = inserted_id / 2;
    //최대힙
    if(this.heapArray.get(inserted_id) > this.heapArray.get(parent_idx)){
      return true;
    } else {
      return false;
    }
  }
  public boolean move_down(Integer poped_id){
    Integer left_child_poped_idx,  right_child_poped_idx;
    left_child_poped_idx = poped_id * 2;
    right_child_poped_idx = poped_id * 2 + 1;
    //완전이진트리이기때문에 오른쪽만 있을 수는 없음
    //왼쪽도 없을때(아예없을때)
    if(left_child_poped_idx >= this.heapArray.size()){
      return false;
    }
    //왼쪽만 있을때
    if(right_child_poped_idx >= this.heapArray.size()){
      if(this.heapArray.get(poped_id) < this.heapArray.get(left_child_poped_idx)){
        return true;
      } else {
        return false;
      }
    } else {
      if(this.heapArray.get(left_child_poped_idx) > this.heapArray.get(right_child_poped_idx)){
        if(this.heapArray.get(left_child_poped_idx) > this.heapArray.get(poped_id)){
          return true;
        } else {
          return false;
        }
      } else {
        if(this.heapArray.get(right_child_poped_idx) > this.heapArray.get(poped_id)){
          return true;
        } else {
          return false;
        }
      }
    }


    //둘다 있을때
  }
  public boolean insert(Integer data){
    Integer inserted_idx, parent_idx;
    if(this.heapArray == null){
      this.heapArray = new ArrayList<Integer>();
      heapArray.add(null);
      heapArray.add(data);
      return true;
    }
    this.heapArray.add(data);
    inserted_idx = this.heapArray.size() - 1 ;
    while(this.move_up(inserted_idx)){//move_up 함수를 통해 스왑이 필요한 상황인지 판단한다.
      parent_idx = inserted_idx / 2;
      Collections.swap(this.heapArray, inserted_idx, parent_idx);
      inserted_idx = parent_idx;
    }
    return true;
  }
  public Integer pop(){
    Integer return_data, popped_idx,left_child_popped_idx, right_child_popped_idx;
    if(this.heapArray == null){
      return null;
    } else {
      return_data = this.heapArray.get(1);
      this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
      this.heapArray.remove(this.heapArray.size() - 1);
      popped_idx = 1;
      while(this.move_down(popped_idx)){
        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;
        //오른쪽 자식만 없을때
        if(right_child_popped_idx >= this.heapArray.size()){
          if(this.heapArray.get(popped_idx)<this.heapArray.get(left_child_popped_idx)){
            Collections.swap(heapArray, popped_idx, left_child_popped_idx);
            popped_idx = left_child_popped_idx;
          }
        } else { //모두 있을때
            if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)){
              if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)){
                Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                popped_idx = left_child_popped_idx;
              }
            } else {
              if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)){
                Collections.swap(heapArray, popped_idx, right_child_popped_idx);
                popped_idx = right_child_popped_idx;
              }
            }
        }
      }
      return return_data;
    }
    
  }
}
