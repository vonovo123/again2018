## 대표적인 데이터 구조8: 힙

### 1. 힙 (Heap) 이란?

- 힙: 데이터에서 최대값과 최소값을 빠르게 찾기 위해 고안된 완전 이진 트리(Complete Binary Tree)
  - 완전 이진 트리: 노드를 삽입할 때 최하단 왼쪽 노드부터 차례대로 삽입하는 트리
  - 힙을 사용하는 이유
  - 배열에 데이터를 넣고, 최대값과 최소값을 찾으려면 O(n) 이 걸림
  - 이에 반해, 힙에 데이터를 넣고, 최대값과 최소값을 찾으면, $ O(log n) $ 이 걸림
  - 우선순위 큐와 같이 최대값 또는 최소값을 빠르게 찾아야 하는 자료구조 및 알고리즘 구현 등에 활용됨

### 2. 힙과 이진 탐색 트리의 공통점과 차이점
- 공통점: 힙과 이진 탐색 트리는 모두 이진 트리임
- 차이점: 
  - 힙은 각 노드의 값이 자식 노드보다 크거나 같음(Max Heap의 경우)
  - 이진 탐색 트리는 왼쪽 자식 노드의 값이 가장 작고, 그 다음 부모 노드, 그 다음 오른쪽 자식 노드 값이 가장 큼
  - 힙은 이진 탐색 트리의 조건인 자식 노드에서 작은 값은 왼쪽, 큰 값은 오른쪽이라는 조건은 없음
    - 힙의 왼쪽 및 오른쪽 자식 노드의 값은 오른쪽이 클 수도 있고, 왼쪽이 클 수도 있음
- 이진 탐색 트리는 탐색을 위한 구조, 힙은 최대/최소값 검색을 위한 구조 중 하나로 이해하면 됨 

### 3. 힙 구현
### 힙과 배열
- 일반적으로 힙 구현시 배열 자료구조를 활용함
- 배열은 인덱스가 0번부터 시작하지만, 힙 구현의 편의를 위해, root 노드 인덱스 번호를 1로 지정하면, 구현이 좀더 수월함
  - 부모 노드 인덱스 번호 (parent node's index) = 자식 노드 인덱스 번호 (child node's index) / 2
     - JAVA 에서는 / 연산자로 몫 을 구할 수 있음 
  - 왼쪽 자식 노드 인덱스 번호 (left child node's index) = 부모 노드 인덱스 번호 (parent node's index) * 2
  - 오른쪽 자식 노드 인덱스 번호 (right child node's index) = 부모 노드 인덱스 번호 (parent node's index) * 2 + 1

```java
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
```

```typescript
```

### 4. 힙 (Heap) 시간 복잡도
  - depth (트리의 높이) 를 h라고 표기한다면,
  - n개의 노드를 가지는 heap 에 데이터 삽입 또는 삭제시, 최악의 경우 root 노드에서 leaf 노드까지 비교해야 하므로 $h = log_2{n} $ 에 가까우므로, 시간 복잡도는 $ O(log{n}) $ 
     - 참고: 빅오 표기법에서 $log{n}$ 에서의 log의 밑은 10이 아니라, 2입니다.
     - 한번 실행시마다, 50%의 실행할 수도 있는 명령을 제거한다는 의미. 즉 50%의 실행시간을 단축시킬 수 있다는 것을 의미함
