package FASTCAMPUS.ALGO.D01;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    customStack<Integer> stack = new customStack <Integer>();
    System.out.println(stack.push(1));
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
  }
}

class customQueue<T> {
  private ArrayList<T> queue;
  customQueue(){
    queue = new ArrayList<T>(); 
  }
  public void enqueue(T value){
    queue.add(value);
  }
  public T dequeue(){
    if(queue.isEmpty()){
      return null;
    }
    return queue.remove(0);
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

} 

class customStack <T> {
  private ArrayList<T> stack;
  customStack(){
    this.stack = new ArrayList<T>();
  }

  public T push(T value){
    if(this.stack.add(value)){
      return value;
    }
    return null;
  }

  public T pop(){
    if(this.isEmpty()){
      return null;
    } 
    return this.stack.remove(this.stack.size() - 1 );
  }

  public boolean isEmpty(){
    return this.stack.isEmpty();
  }

}
