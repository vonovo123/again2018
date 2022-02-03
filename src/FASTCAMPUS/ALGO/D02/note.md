## 데이터 구조: 링크드 리스트 (Linked List)

### 1. 링크드 리스트 (Linked List) 구조
* 연결 리스트라고도 함
* 배열은 순차적으로 연결된 공간에 데이터를 나열하는 데이터 구조
* 링크드 리스트는 떨어진 곳에 존재하는 데이터를 화살표로 연결해서 관리하는 데이터 구조
* 링크드 리스트 기본 구조와 용어
  - 노드(Node): 데이터 저장 단위 (데이터값, 포인터) 로 구성
  - 포인터(pointer): 각 노드 안에서, 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간

### 2. 간단한 링크드 리스트 예
- 최대한 간단한 형태로 코드로 작성해보며 링크드 리스트를 이해해보기

```java
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
    if(this.head != null){
      Node<T> node = this.head;
      System.out.println(node.data);
      while(node.next != null){
        node = node.next;
        System.out.println(node.data);
      }
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
```

```typescript
class singleLinkedList<T> {
  head : singleNode<T> | undefined;
  
  constructor(){

  }
  
  addNode(data:T) :T{
    if(!this.head){
      this.head = new singleNode(data);
      return data;
    } else {
      let node = this.head;
      while(node.next){
        node = node.next;
      }
      node.next = new singleNode(data);
      return data;
    }
  }
  search(prev:T):singleNode<T>|null{
    if(!this.head){
      return null;
    } else {
      let node : singleNode<T>|undefined = this.head;
      while(node){
        if(node.data === prev){
          return node;
        }
        node = node.next;
      }
      return null;
    }
  }

  printAll(){
    if(!this.head){
      return;
    } else {
      let node : singleNode<T>|undefined = this.head;
      while(node){
        console.log(node.data);
        node = node.next;
      }
    }
    
  }

  addNodeInside(data:T, prev:T):T{
    let node = this.search(prev);
    if(node){
      let newNode = new singleNode<T>(data);
      newNode.next = node.next;
      node.next = newNode;
      return data;
    } else {
      this.addNode(data);
      return data;
    }
    
  }

  delNode(data:T):number{
    if(!this.head){
      return -1;
    } else {
      let node : singleNode<T> = this.head;
      if(node.data === data){
        this.head = node.next;
        return 1;
      } else {
        if(!node.next){
          return -1;
        } else {
          while(node.next){
              if(node.next.data === data){
                node.next = node.next.next;
                return 1;
              }
              node = node.next;            
          }
          return -1;
        }
        
      }
    }
  }
}

class singleNode<T>{
  next!:singleNode<T>;
  data:T|undefined
  constructor(data:T){
    this.data = data;
  }
}
```

### 다양한 링크드 리스트 구조: 더블 링크드 리스트(Doubly linked list)
* 더블 링크드 리스트(Doubly linked list) 기본 구조 
  - 이중 연결 리스트라고도 함
  - 장점: 양방향으로 연결되어 있어서 노드 탐색이 양쪽으로 모두 가능

### 더블링크드 리스트의 간단한 예

```java
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
```

```typescript
class doubleLinkedList<T> {
  head:doubleNode<T>|null;
  tail:doubleNode<T>|null;
  constructor(){
    this.head = null;
    this.tail = null
  }
  addNode(data:T){
    if(!this.head){
      this.head = new doubleNode(data);
      this.tail = this.head;
    } else {
      let node =this.tail;
      let newNode = new doubleNode(data);
      if(!node){
        this.tail = this.head;
        this.tail.prev = null;
        this.tail.next = null;
      } else {
        node.next = newNode;
        newNode.prev = node;
        this.tail = newNode;
      }
    }
  };
  insertToPrev(target:T, data:T){
    if(!this.head){
      return;
    } else {
      let node:doubleNode<T>|null = this.head;
      let newNode = new doubleNode(data);
      while(node){
        if(node.data === target){
          //헤드
          if(!node.prev){
            newNode.next = node;
            node.prev = newNode;
            this.head = newNode;
            //사이 | 테일
            } else {
              let prev = node.prev;
              prev.next = newNode;
              newNode.prev = prev;
              newNode.next = node;
              node.prev = newNode;
            }
            return;
        }
        node = node.next;
      }
    }
  };
  insertToNext(target:T, data:T){
    if(!this.head){
      return;
    } else {
      let node:doubleNode<T>|null = this.head;
      let newNode = new doubleNode(data);
      while(node){
        if(node.data === target){
          //테일
          if(!node.next){
            newNode.prev = node;
            node.next = newNode;
            this.tail = newNode;
            //사이 | 헤드
            } else {
              //기존 다음노드
              let next = node.next;
              // 타겟 노드 > 새 노드 > 기존 다음노드
              next.prev = newNode;
              newNode.next = next;
              newNode.prev = node;
              node.next = newNode;
            }
            break;
        }
        node = node.next;
      }
    }
  
  };
  delNode(target:T){
    if(this.head === null){
      return -1;
    } else {
      let node:doubleNode<T> | null = this.head;
      while(node){
        if(node.data === target){
          //헤드이자 테일 즉 하나만 있는경우
          if(!node.prev && !node.next){
            this.head = null;
            this.tail = null;
            return 1
          } else if(!node.prev && node.next){//헤드
            this.head = node.next;
            this.head.prev = null;
            return 1;
          } else if(!node.next && node.prev){//테일
            this.tail = node.prev;
            this.tail.next = null;
            return 1;
          } else if(node.next && node.prev) { //사잇값
            let prev = node.prev;
            let next = node.next;
            prev.next = next;
            next.prev = prev;
            return 1;
          } else {
            return -1;
          }
        }
        node = node.next;
      }
      return -1;
    }
  };
  printAll(){
    if(this.head){
      let node:doubleNode<T>|null = this.head;
      while(node){
        console.log(node.data);
        node = node.next;
        
      }
    }
  }
}

class doubleNode<T>{
  prev:doubleNode<T>|null;
  next:doubleNode<T>|null;
  data:T;
  constructor(data:T){
    this.data = data;
    this.prev = null;
    this.next = null;
  };
}
```
## 알고리즘 복잡도 표현 방법

### 알고리즘 시간 복잡도의 주요 요소

> 반복문이 지배합니다.

### 알고리즘 성능 표기법
- Big O (빅-오) 표기법: O(N)
  - 알고리즘 최악의 실행 시간을 표기
  - **가장 많이/일반적으로 사용함**
  - **아무리 최악의 상황이라도, 이정도의 성능은 보장한다는 의미이기 때문**

* 빅 오 입력값 표기 방법
  - 예: 
    - 만약 시간 복잡도 함수가 2$n^2$ + 3n 이라면
      - 가장 높은 차수는 2$n^2$ 
      - 상수는 실제 큰 영향이 없음 
      - 결국 빅 오 표기법으로는 O($n^2$) (서울부터 부산까지 가는 자동차의 예를 상기)

      