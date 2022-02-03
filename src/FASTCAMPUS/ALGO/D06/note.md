
## 대표적인 정렬1: 버블 정렬 (bubble sort) 

### 0. 알고리즘 연습 방법
* 알고리즘을 잘 작성하기 위해서는 잘 작성된 알고리즘을 이해하고, 스스로 만들어봐야 함


<div class="alert alert-block" style="border: 1px solid #FFB300;background-color:#F9FBE7;font-size:1em;line-height:1.4em">
<font size="5em" style="font-weight:bold;color:#3f8dbf;">알고리즘 연습 방법</font><br><br>
1. 연습장과 펜을 준비합니다. <br><br>
2. 알고리즘 문제를 읽고 분석한 후에, <br><br>
3. 간단하게 테스트용으로 매우 간단한 경우부터 복잡한 경우 순서대로 생각해보면서, 연습장과 펜을 이용하여 알고리즘을 생각해봅니다. <br><br>
4. 가능한 알고리즘이 보인다면, 구현할 알고리즘을 세부 항목으로 나누고, 문장으로 세부 항목을 나누어서 적어봅니다. <br><br>
5. 코드화하기 위해, 데이터 구조 또는 사용할 변수를 정리하고, <br><br>
6. 각 문장을 코드 레벨로 적습니다. <br><br>
7. 변수가 코드에 따라 어떻게 변하는지를 손으로 적으면서, 임의 데이터로 코드가 정상 동작하는지를 연습장과 펜으로 검증합니다. <br>
    
</div>

### 2. 버블 정렬 (bubble sort) 란?
* 두 인접한 데이터를 비교해서, 앞에 있는 데이터가 뒤에 있는 데이터보다 크면, 자리를 바꾸는 정렬 알고리즘

### 3. 버블 정렬 구현하기
```java
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
```
```typescript
class BubbleSort {
  constructor(){

  }
  sort(arr:number[]){
    for(let i = 0; i < arr.length - 1; i ++){
      let flag = false;
      for(let j = 0; j < arr.length - 1 - i; j ++){
        if(arr[j] > arr[j + 1]){
          arr = swap(arr, j, j + 1);
          flag = true
        }
      }
      if(!flag) return arr;
    }

    return arr;
  }
}

```

## 대표적인 정렬2: 선택 정렬 (selection sort) 

### 1. 선택 정렬 (selection sort) 란?
* 다음과 같은 순서를 반복하며 정렬하는 알고리즘
  1. 주어진 데이터 중, 최소값을 찾음
  2. 해당 최소값을 데이터 맨 앞에 위치한 값과 교체함
  3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함

### 2. 선택 정렬 구현하기
```java
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
```
```typescript
class SelectionSort {
  constructor(){

  }
  sort(arr:number[]){
    for(let i = 0; i < arr.length - 1; i ++){
      let lowest = i;
      for(let j = i; j < arr.length; j ++){
        if(arr[lowest] > arr[j]){
          lowest = j;
        }
      }
      arr = swap(arr, lowest, i);
    }
    return arr;
  }
}
```

## 대표적인 정렬3: 삽입 정렬 (insertion sort) 

### 1. 삽입 정렬 (insertion sort) 란?
* 삽입 정렬은 두 번째 인덱스부터 시작
* 해당 인덱스(key 값) 앞에 있는 데이터(B)부터 비교해서 key 값이 더 작으면, B값을 뒤 인덱스로 복사
* 이를 key 값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key 값을 이동

### 2. 삽입 정렬의 구현
```java
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
```
```javascript
class InsertionSort {
  constructor(){

  }
  sort(arr : number[]){
    for(let i = 1; i < arr.length; i ++ ){
      for(let j = i; j > 0; j --){
        if(arr[j] < arr[j - 1]){
          arr = swap(arr, j, j - 1);
        } else {
          break;
        }
      }
    }
    return arr;
  }
}
```