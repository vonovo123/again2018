package FASTCAMPUS.ALGO.D02;
class Main {
  public static void main(String[] args) {
    DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();
    MyLinkedList.addNode(1);
    MyLinkedList.addNode(2);
    MyLinkedList.addNode(3);
    MyLinkedList.addNode(4);
    MyLinkedList.addNode(5);
    MyLinkedList.printAll();
    System.out.println("-------");
    MyLinkedList.insertToPrev(1,6);
    MyLinkedList.insertToPrev(1,7);
    MyLinkedList.insertToPrev(1,8);
    MyLinkedList.printAll();
    System.out.println("-------");
    MyLinkedList.insertToNext(8,9);
    MyLinkedList.insertToNext(9,10);
    MyLinkedList.insertToNext(5,11);
    MyLinkedList.printAll();
    System.out.println("-------");
    MyLinkedList.delNode(1);
    MyLinkedList.delNode(2);
    MyLinkedList.delNode(3);
    MyLinkedList.delNode(4);
    MyLinkedList.delNode(5);
    MyLinkedList.delNode(6);
    MyLinkedList.printAll();
    System.out.println("-------");
    System.out.println(MyLinkedList.head.data);
    System.out.println(MyLinkedList.tail.data);
  }
}

class SingleLinkedlist<T>{  
  private Node<T> head;
  SingleLinkedlist(){
  }

  public void addNode(T data){
    if(this.head == null){
      head = new Node<T>(data);
    } else {
      Node<T> node = this.head;
      while(node.next != null){
        node = node.next;
      }
      node.next = new Node<T>(data);
    }
  }
  private Node<T> search(T data){
    if(this.head != null){
      Node<T> node = head;
      while(node != null) {
        if(node.data == data){
          return node;
        }
        node = node.next;
      }
    }
    return null;
  }
  public void printAll(){
      Node<T> node = this.head;
      while(node!= null){
        System.out.println(node.data);
        node = node.next;
      }
  }
  public void addNodeInside(T data, T isData){
    Node <T> searchNode = this.search(isData);
    if(searchNode == null) {//없는 노드이면 list 맨끝에 추가하기
      this.addNode(data);
    } else {
      Node<T> nextNode = searchNode.next;
      searchNode.next = new Node<T>(data);
      searchNode.next.next = nextNode;
    }
  }

  public Integer delNode(T data){
    if(this.head == null){
      return 0;
    }  else {
      Node <T> node = this.head;
      if(node.data == data){
        this.head = node.next;
        return 1;
      } else {
        while(node.next != null){
          if(node.next.data == data){
            node.next = node.next.next;
            return 1;
          }
          node = node.next;
        }
        return 0;
      }
    }
  }
  class Node<T>{
    private T data;
    private Node<T> next;
    Node(T data){
      this.data = data;
      this.next = null;
    }
  }
}

class DoubleLinkedList<T> {
  public Node<T> head;
  public Node<T> tail;
  public DoubleLinkedList(){
    this.head = null;
    this.tail = null;
  }

  public void addNode(T data){
    if(this.head == null){
      this.head = new Node<T>(data);
      this.tail = this.head;
    } else {
      //리스트의 끝노드
      Node<T> node = this.tail;
      node.next = new Node<T>(data);
      node.next.prev = node;
      //node.next.next : null;
      this.tail = node.next;
    }
  }

  public Node<T> searchFromHead( T data){
    if(this.head == null){
      return null;
    } else {
      Node<T> node = this.head;
      while(node != null){
        if(node.data == data){
          return node;
        }
        node = node.next;
      }
      return null;
    }
  }

  public Node<T> searchFromTail(T data){
    if(this.tail == null){
      return null;
    } else {
      Node<T> node = this.tail;
      while(node != null){
        if(node.data == data){
          return node;
        }
        node = node.prev;
      }
      return null;
    }
  }

  public T insertToPrev(T target, T data){
    if(this.head == null){ 
      return null;
    } else {
      Node <T> node = this.head;
      while(node != null){
        if(node.data == target){
          Node<T> prev = node.prev;
          Node<T> newNode = new Node<T>(data);
          //target이 head일때
          if(prev == null){
            this.head = newNode;
          } else {
            prev.next = newNode;
            newNode.prev = prev;  
          }
          newNode.next = node;
          node.prev = newNode;
          return data;
        }
        node = node.next;
      }
      return null;
    }
  }

  public T insertToNext(T target, T data){
    if(this.head == null){
      return null;
    } else {
      Node<T> node = this.head;
      while(node != null){
        if(node.data == target){
          Node<T> next = node.next;
          Node<T> newNode = new Node<T>(data);
          //지금 노드가 마지막노드이면
          if(next == null){
            this.tail = newNode;
          } else {
            next.prev = newNode;
            newNode.next = next;
          }
          node.next = newNode;
          newNode.prev = node;
          return data;
        }
        node = node.next;
      }
      return null;
    }
  }
  public T delNode(T target){
    if(this.head == null){
      return null;
    } else {
      Node<T> node = this.head;
      while(node != null){
        if(node.data == target){
          if(node.prev == null) { //target이 head일때
            this.head = node.next;
            this.head.prev = null;
          } else if(node.next == null) { //target이 tail일때
            this.tail = node.prev;
            this.tail.next = null;
          } else {
            Node<T> prev = node.prev;
            Node<T> next = node.next;
            prev.next = next;
            next.prev = prev;
          }
          return target;
        }
        node = node.next;
      }
      return null;
    }
  }
  public void printAll(){
    Node<T> node = this.head;
    while(node != null){
      System.out.println(node.data);
      node = node.next;
    }
  }

  class Node<T>{
    T data;
    Node<T> prev;
    Node<T> next;
    public Node(T data){
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }
}