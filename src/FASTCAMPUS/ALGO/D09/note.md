## 너비 우선 탐색 (Breadth-First Search)
  - 너비 우선 탐색 (Breadth First Search): 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
  - BFS 방식: A - B - C - D - G - H - I - E - F - J 
  - 한 단계씩 내려가면서, 해당 노드와 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 순회함


### BFS 코드 구현 (프로젝트: CH25_BFS)
- 각각의 알고리즘에서 자료구조가 사용됨을 이해할 수 있음 (BFS 에서는 큐 자료구조를 사용함)
- 각 자료구조는 자료구조 시간에, 변수/조건문/반복문을 기반으로 밑바닥부터 구현하는 코드도 익혔음

```java
class BFS {
  public void search(HashMap<String, ArrayList<String>> graph, String start){
    ArrayList<String> visited = new ArrayList<String>();
    ArrayList<String> needVisited = new ArrayList<String>();
  
    needVisited.add(start);
    while(needVisited.size() != 0){
      String next = needVisited.remove(0);
      if(!visited.contains(next)){ 
        visited.add(next);
        needVisited.addAll(graph.get(next));
      } 
    }
    System.out.println(visited);
  }
}
```

```javascript

class BFS {
  search(graph:Map<string,string[]>, start:string){
    let visited:string[] = [];
    let needVisit:string[] = [];
    needVisit.push(start);
    while(needVisit.length !== 0){
      const node:string|undefined = needVisit.shift();
      if(node){
        if(visited.indexOf(node) == -1){
          visited.push(node);
          const child:string[] | undefined = graph.get(node);
          if(child){
            child.forEach(v => {
              needVisit.push(v);
            })
          }
        }
      } else {
        continue;
      }
    }
  }
}

```

### BFS 시간 복잡도
- 일반적인 BFS 시간 복잡도
  - 노드 수: V
  - 간선 수: E
    - 위 코드에서 while need_visit 은 V + E 번 만큼 수행함
  - 시간 복잡도: O(V + E)
  

## 깊이 우선 탐색 (Depth-First Search)

  - 깊이 우선 탐색 (Depth First Search): 정점의 자식들을 먼저 탐색하는 방식
  - DFS 방식: A - B - D - E - F - C - G - H - I - J 
  - 한 노드의 자식을 타고 끝까지 순회한 후, 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순회함

### DFS 알고리즘 구현 (프로젝트: CH26_DFS)

- 자료구조 스택과 큐를 활용함
  - needVisit 스택과 visited 큐, 두 개의 자료 구조를 생성

> BFS 자료구조는 두 개의 큐를 활용하는데 반해, DFS 는 스택과 큐를 활용한다는 차이가 있음을 인지해야 함

```java
class DFS {
  public void search(HashMap<String, ArrayList<String>> graph,String start){
    ArrayList<String> visited = new ArrayList<String>();
    ArrayList<String> needVisited = new ArrayList<String>();

    needVisited.add(start);
    while(needVisited.size() != 0){
      String next = needVisited.remove(needVisited.size() - 1);
      if(!visited.contains(next)){
        visited.add(next);
        needVisited.addAll(graph.get(next));
      }
    }
    System.out.println(visited);
  }
}
```

```javascript
class DFS {
  search( graph:Map<string, string[]>, start:string ){
    const visited:string[] = [];
    const needVisit:string[] = [];
    needVisit.push(start);
    while(needVisit.length !== 0 ){
      if(needVisit[0]){
        const node = needVisit.pop();
        if(node){
          if(visited.indexOf(node) === -1){
            visited.push(node);
            const child:string[]|undefined = graph.get(node);
            if(child){
              child.forEach(v => {
                needVisit.push(v);
              })
            }
          }
        } else {
          break;
        }
      }
    }
  }
}
```

### DFS 시간 복잡도
- 일반적인 DFS 시간 복잡도
  - 노드 수: V
  - 간선 수: E
    - 위 코드에서 while need_visit 은 V + E 번 만큼 수행함
  - 시간 복잡도: O(V + E)
  
## 탐욕 알고리즘의 이해

### 1. 탐욕 알고리즘 이란?
- Greedy algorithm 또는 탐욕 알고리즘 이라고 불리움
- 최적의 해에 가까운 값을 구하기 위해 사용됨
- 여러 경우 중 하나를 결정해야할 때마다, **매순간 최적이라고 생각되는 경우를 선택**하는 방식으로 진행해서, 최종적인 값을 구하는 방식

### 2. 부분 배낭 문제 (Fractional Knapsack Problem) (프로젝트: CH27_KNAPSACK)
```javascript
const objList:number[][] = [ [10, 10], [15, 12], [20, 10], [25, 8], [30, 5] ];

objList.sort((a:number[], b:number[]) => {
  return b[1] / b[0] - a[1] / a[0];
})

let capacity = 30;
let totalValue = 0;
console.log(objList);
for(let i = 0; i < objList.length; i ++){
  let obj = objList[i];
  console.log(obj[0])
  if(capacity > obj[0]){
    capacity -= obj[0];
    totalValue += obj[1];
    console.log(`weight ${capacity} totalValue ${totalValue}`);
  } else {
    let flaction = obj[1] / obj[0];
    totalValue += capacity * flaction;
    console.log(`totalValue ${totalValue} flaction ${capacity * flaction}`);
    break;
  }
}

```

* Integer가 아닌 요소의 정렬(compareTo 방식)

``` java
class Edge implements Comparable<Edge>{
  public Integer distance; // 가중치
  public String vertex; //노드명

  public Edge(Integer distance, String vertex){
    this.distance = distance;
    this.vertex = vertex;
  }
  @Override
  public int compareTo(Edge o) {
    return this.distance - o.distance;
  }
}
```

### 3. 탐욕 알고리즘의 한계
- 탐욕 알고리즘은 근사치 추정에 활용
- 반드시 최적의 해를 구할 수 있는 것은 아니기 때문
- 최적의 해에 가까운 값을 구하는 방법 중의 하나임