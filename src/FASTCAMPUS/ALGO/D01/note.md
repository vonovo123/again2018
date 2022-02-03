## 배열 (Array)

### JAVA 에서는 기본 문법으로 배열 지원 
- 1차원 배열은 [ ] 를 통해 선언할 수 있음 
- 각 아이템은 { } 내에 콤마로 작성

### JAVA 에서 배열을 보다 손쉽게 다루기 위한 클래스등을 제공
- 예: Arrays 클래스 활용하여, 전체 데이터 출력하기

```java
  import  java.util.Arrays;
  System.out.println( Arrays.toString(data_list2) ); // 배열의 내용을 출력하려면, Arrays.toString(배열변수) 메서드를 사용하면 됨
```

### JAVA 에서 배열을 보다 손쉽게 다루기 위한 ArrayList 클래스 예
- ArrayList 클래스는 가변 길이의 배열 자료구조를 다룰 수 있는 기능을 제공함

### 3. 프로그래밍 연습 

```java
package FASTCAMPUS.ALGO.JAVA.D01;

import java.util.ArrayList;

class D01 {
  public static void main(String[] args) {
    String dataset[] = {
      "Braund, Mr. Owen Harris",
      "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
      "Heikkinen, Miss. Laina",
      "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
      "Allen, Mr. William Henry",
      "Moran, Mr. James",
      "McCarthy, Mr. Timothy J",
      "Palsson, Master. Gosta Leonard",
      "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
      "Nasser, Mrs. Nicholas (Adele Achem)",
      "Sandstrom, Miss. Marguerite Rut",
      "Bonnell, Miss. Elizabeth",
      "Saundercock, Mr. William Henry",
      "Andersson, Mr. Anders Johan",
      "Vestrom, Miss. Hulda Amanda Adolfina",
      "Hewlett, Mrs. (Mary D Kingcome) ",
      "Rice, Master. Eugene",
      "Williams, Mr. Charles Eugene",
      "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
      "Masselmani, Mrs. Fatima",
      "Fynney, Mr. Joseph J",
      "Beesley, Mr. Lawrence",
      "McGowan, Miss. Anna",
      "Sloper, Mr. William Thompson",
      "Palsson, Miss. Torborg Danira",
      "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
      "Emir, Mr. Farred Chehab",
      "Fortune, Mr. Charles Alexander",
      "Dwyer, Miss. Ellen",
      "Todoroff, Mr. Lalio"
  };
  int count = 0;
    for (String data : dataset) {
      if(data.indexOf("M") != -1){
        count ++;
        System.out.println(data);
      }
    }
    System.out.println(count);
  }
  
}

```

```javascript
let dataset = [
  "Braund, Mr. Owen Harris",
  "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
  "Heikkinen, Miss. Laina",
  "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
  "Allen, Mr. William Henry",
  "Moran, Mr. James",
  "McCarthy, Mr. Timothy J",
  "Palsson, Master. Gosta Leonard",
  "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
  "Nasser, Mrs. Nicholas (Adele Achem)",
  "Sandstrom, Miss. Marguerite Rut",
  "Bonnell, Miss. Elizabeth",
  "Saundercock, Mr. William Henry",
  "Andersson, Mr. Anders Johan",
  "Vestrom, Miss. Hulda Amanda Adolfina",
  "Hewlett, Mrs. (Mary D Kingcome) ",
  "Rice, Master. Eugene",
  "Williams, Mr. Charles Eugene",
  "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
  "Masselmani, Mrs. Fatima",
  "Fynney, Mr. Joseph J",
  "Beesley, Mr. Lawrence",
  "McGowan, Miss. Anna",
  "Sloper, Mr. William Thompson",
  "Palsson, Miss. Torborg Danira",
  "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
  "Emir, Mr. Farred Chehab",
  "Fortune, Mr. Charles Alexander",
  "Dwyer, Miss. Ellen",
  "Todoroff, Mr. Lalio"
];
let count = 0;
dataset.forEach(data => {
  if(data.indexOf('M') !== -1){
    console.log(data);
    count ++;
  }
})

console.log(count);
```

## 데이터 구조: 큐 (Queue)

### 1. 큐 구조
* 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조

### 2. 알아둘 용어
* Enqueue: 큐에 데이터를 넣는 기능
* Dequeue: 큐에서 데이터를 꺼내는 기능

### JAVA에서의 queue
* Enqueue에 해당하는 메서드로 Queue클래스에서 add 혹은 offer 메서드 제공
* Dequeue에 해당하는 메서드로 Queue 클래스에서 poll 혹은 remove 메서드 제공
* Queue 인터페이스를 구현한 대표적인 클래스로는 LinkedList가 있음

```java
    Queue<Integer> queue_int = new LinkedList<Integer>(); // Integer 형 queue 선언
    queue_int.add(1);
    queue_int.offer(1);
    queue_int.poll();
    queue_int.remove();
    System.out.println(queue_int);
    //[]
```

### 프로그래밍 연습 
``` java
import java.util.ArrayList;
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

```

``` typescript
class myQueue<T> {
  queue: T[];
  constructor(){
    this.queue = [];
  }
  enqueue(value:T){
    this.queue.push(value);
  }

  dequeue():T|null|undefined{
    if(this.isEmpty()){
      return null;
    } else {
      return this.queue.shift();
    }
  }

  isEmpty():boolean{
    return this.queue.length === 0;
  }
}

```

## 꼭 알아둬야 할 자료 구조: 스택 (Stack)
* 데이터를 제한적으로 접근할 수 있는 구조
  - 한쪽 끝에서만 자료를 넣거나 뺄 수 있는 구조
* 가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조
  - 큐: FIFO 정책
  - 스택: LIFO 정책
* 주요 기능
  - push(): 데이터를 스택에 넣기
  - pop(): 데이터를 스택에서 꺼내기


### 프로그래밍 연습 
```java
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

```

```typescript
  class myStack<T>{
    stack:T[];
    constructor(){
      this.stack = [];
    }
    push(value:T):T{
      this.stack.push(value);
      return value;
    };
    pop():T|undefined{
      return this.stack.pop();
    };
    isEmpty():boolean{
      return this.stack.length === 0;
    }
  }
```