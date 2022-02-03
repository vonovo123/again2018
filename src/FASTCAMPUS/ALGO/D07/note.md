## 대표적인 정렬4: 병합 정렬 (merge sort) 

### 1. 병합 정렬 (merge sort) 
* 재귀용법을 활용한 정렬 알고리즘
  1. 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
  2. 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
  3. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.

### 2. 알고리즘 이해
* 데이터가 네 개 일때 (데이터 갯수에 따라 복잡도가 떨어지는 것은 아니므로, 네 개로 바로 로직을 이해해보자.)
* 두 단계로 분리해서 이해할 수 있음
  - **1단계: 정렬되지 않은 배열을 끝까지 분리하는 단계**
  - **2단계: 분리한 데이터를 단계별로 합치는 단계**
<br><br>
* 예: dataList = [1, 9, 3, 2]
    - 먼저 [1, 9], [3, 2] 로 나누고
    - 다시 앞 부분은 [1], [9] 로 나누고 **(여기까지 1단계)**
    - 다시 정렬해서 합친다. [1, 9] **(이 부분부터 2단계)**
    - 다음 [3, 2] 는 [3], [2] 로 나누고
    - 다시 정렬해서 합친다 [2, 3]
    - 이제 [1, 9] 와 [2, 3]을 합친다.
      - 두 배열의 맨 앞에 위치한 데이터부터, 각각 비교하며, 정렬된 합쳐진 배열을 작성한다.
        - 1 < 2 이니 [1]
        - 9 > 2 이니 [1, 2]
        - 9 > 3 이니 [1, 2, 3]
        - 9 밖에 없으니, [1, 2, 3, 9]
        
 > 복잡한 알고리즘이므로, 가능한 선명하게 이해하기 위해, 강의 영상에서 마련한 그림들과 함께 이해하기

 ### 3. 알고리즘 구현

 ```java
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
 ```
 ```javascript
class MergeSort {
  merge(front:number[], back:number[]){
    let merged = [];
    while(front.length !== 0 && back.length !== 0){
      if(front[0] < back[0]){
        merged.push(front.shift());
      } else {
        merged.push(back.shift());
      }
    }
    while(front.length !== 0){
      merged.push(front.shift());
    }
    while(back.length !== 0){
      merged.push(back.shift());
    }
    return merged;
  }
  sort(arr:number[]):any{
    if(arr.length === 1){
      return arr;
    }
    let mid = Math.floor(arr.length / 2)
    return this.merge(this.sort(arr.slice(0, mid)),this.sort(arr.slice(mid)));
  }; 
}
 ```

 ## 대표적인 정렬5: 퀵 정렬 (quick sort) 

 ### 1. 퀵 정렬 (quick sort) 이란?
* <font color='#BF360C'>정렬 알고리즘의 꽃</font>
* 기준점(pivot 이라고 부름)을 정해서, 기준점보다 작은 데이터는 왼쪽(left), 큰 데이터는 오른쪽(right) 으로 모으는 함수를 작성함
* 각 왼쪽(left), 오른쪽(right)은 재귀용법을 사용해서 다시 동일 함수를 호출하여 위 작업을 반복함
* 함수는 왼쪽(left) + 기준점(pivot) + 오른쪽(right) 을 리턴함

 ### 3. 알고리즘 구현

```java
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

```

```javascript

//퀵솔트 - 배열 분해 
class QuickSortArr {
  // arr:number[];
  // constructor(arr:number[]) {
  //   this.arr = arr;
  // }
  sort(arr:number[]):number[]{
    if(arr.length <= 1){
      return arr;
    }
    let pivot = 0;
    let front:number[] = [];
    let back: number[] = [];
    for(let i = 1; i < arr.length; i ++){
      if(arr[i] < arr[pivot]){
        front.push(arr[i]);
      } else {
        back.push(arr[i]);
      }
    }
    console.log(`front : ${front}`)
    console.log(`pivot : ${pivot}`)
    console.log(`back : ${back}`)
    return [...this.sort(front),arr[pivot],...this.sort(back)];
  }
}
//퀵솔트 - 투포인트
class QuickSortTwoPoint{
 sort(arr:number[], start:number, end:number){
  if(end - start <= 1){
    return arr;
  }
  let pivot = start;
  let left = pivot + 1;
  let right = end;
  while(left <= right){
    while(left <= end && arr[left] <= arr[pivot]){
      left ++;
    }
    while(start < right && arr[pivot] <= arr[right]){
      right --;
    }
    if(left <= right){
      arr = this.swap(arr,left, right);
    } else {
      arr = this.swap(arr,pivot, right);
    }
  }
  this.sort(arr, start, right - 1);
  this.sort(arr, right + 1, end);
  return arr;
 }
 swap(arr:number[], a:number, b:number){
   let tmp:number = arr[a];
   arr[a] = arr[b];
   arr[b] = tmp;
   return arr;
 }
}
```