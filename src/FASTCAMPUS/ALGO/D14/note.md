## 백 트래킹 기법의 이해

### 1. 백 트래킹 (backtracking)
- 백트래킹 (backtracking) 또는 퇴각 검색 (backtrack)으로 부름
- 제약 조건 만족 문제 (Constraint Satisfaction Problem) 에서 해를 찾기 위한 전략
  - 해를 찾기 위해, 후보군에 제약 조건을 점진적으로 체크하다가, 해당 후보군이 제약 조건을 만족할 수 없다고 판단되는 즉시 backtrack (다시는 이 후보군을 체크하지 않을 것을 표기)하고, 바로 다른 후보군으로 넘어가며, 결국 최적의 해를 찾는 방법
- 실제 구현시, 고려할 수 있는 모든 경우의 수 (후보군)를 상태공간트리(State Space Tree)를 통해 표현
  - 각 후보군을 DFS 방식으로 확인
  - 상태 공간 트리를 탐색하면서, 제약이 맞지 않으면 해의 후보가 될만한 곳으로 바로 넘어가서 탐색
    - Promising: 해당 루트가 조건에 맞는지를 검사하는 기법
    - Pruning (가지치기): 조건에 맞지 않으면 포기하고 다른 루트로 바로 돌아서서, 탐색의 시간을 절약하는 기법

> 즉, 백트래킹은 트리 구조를 기반으로 DFS로 깊이 탐색을 진행하면서 각 루트에 대해 조건에 부합하는지 체크(Promising), 만약 해당 트리(나무)에서 조건에 맞지않는 노드는 더 이상 DFS로 깊이 탐색을 진행하지 않고, 가지를 쳐버림 (Pruning)

### 2. N Queen 문제코드 작성 (프로젝트: CH31_BACKTRACKING)

```java
class NQueen{
  boolean check(ArrayList<Integer>candidate,Integer currentColumn){
    int currentRow = candidate.size();
    for(int i = 0; i < currentRow; i ++){
      if(candidate.get(i) == currentColumn || (Math.abs(candidate.get(i) - currentColumn) == (currentRow - i))){
        return false;
      }
    }
    return true;
  }
  void search(Integer N, Integer currentRow, ArrayList<Integer>currentCandidate){
    if(N == currentRow){
      System.out.println(currentCandidate);
      return;
    }
    for( int i = 0; i < N; i ++){
      if(check(currentCandidate, i) == true){
        currentCandidate.add(i);
        this.search(N, currentRow + 1, currentCandidate);
        currentCandidate.remove(currentCandidate.size() - 1);
      }
    }
  }
}
```
```javascript


const validate = function(candidate , currentCol){
  // currentRow : 퀸을 위치시킬 행
  // currentCol : 퀸을 위치시킬 열
  let currentRow = candidate.length;
  for(let i = 0; i < currentRow; i ++){
    //각행에 위치한 퀸의 열
    let queenCol = candidate[i];
    if((queenCol === currentCol) || Math.abs(currentRow - i) === Math.abs(currentCol - queenCol)){
      return false;
    }
  }
  return true;
}
const nqueen = function(N, depth, candidate,){
  if(depth === N){
    console.log(candidate);
    return;
  }
  for(let i = 0; i < N ; i ++){
    if(validate(candidate, i)){
      candidate.push(i);
      nqueen(N, depth + 1, candidate);
      candidate.pop();
    }
  }
}
```

