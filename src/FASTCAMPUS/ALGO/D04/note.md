## 대표적인 데이터 구조7: 트리

### 1. 트리 (Tree) 구조
- 트리: Node와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조
- 실제로 어디에 많이 사용되나? 
  - 트리 중 이진 트리 (Binary Tree) 형태의 구조로, 탐색(검색) 알고리즘 구현을 위해 많이 사용됨

### 2. 알아둘 용어
- Node: 트리에서 데이터를 저장하는 기본 요소 (데이터와 다른 연결된 노드에 대한 Branch 정보 포함)
- Root Node: 트리 맨 위에 있는 노드
- Level: 최상위 노드를 Level 0으로 하였을 때, 하위 Branch로 연결된 노드의 깊이를 나타냄
- Parent Node: 어떤 노드의 다음 레벨에 연결된 노드
- Child Node: 어떤 노드의 상위 레벨에 연결된 노드
- Leaf Node (Terminal Node): Child Node가 하나도 없는 노드
- Sibling (Brother Node): 동일한 Parent Node를 가진 노드
- Depth: 트리에서 Node가 가질 수 있는 최대 Level

### 3. 이진 트리와 이진 탐색 트리 (Binary Search Tree)
- 이진 트리: 노드의 최대 Branch가 2인 트리
- 이진 탐색 트리 (Binary Search Tree, BST): 이진 트리에 다음과 같은 추가적인 조건이 있는 트리
  - 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음!

### 4. 이진트리 만들기 
```java
class NodeMgmt{
  Node head= null;
    public boolean insertNode(int data){
      if(head == null){
        head = new Node(data);
      } else {
        Node findNode = this.head;
        while(true){
          //case 2-1 현재 Node의 왼쪽에 Node 가 들어가야할때
          if(data < findNode.value){
            if(findNode.left != null){
              //한 level 내려가기
              findNode = findNode.left;
            } else {
              findNode.left = new Node(data);
              break;
            }
          //case2-2 현재 Nodel의 오른쪽에 Node가 들어가야할때  
          } else {
            if(findNode.right != null){
              findNode = findNode.right;
            } else {
              findNode.right = new Node(data);
              break;
            }
          }
        }
      }
      return true;
    }

    public Node search(int data){
      if(this.head == null){
        return null;
      } else {
        Node findNode = this.head;
        while(findNode != null){
          if(findNode.value == data){
            return findNode;
          } else if( data < findNode.value){
            findNode = findNode.left;
          } else {
            findNode = findNode.right;
          }
        }
        return null;
      }
    }
    public boolean delete(int value){
      boolean searched = false;
      //탐색 대상  노드
      Node curNode = this.head;
      //탐색 대상노드의  부모노드
      Node curParentNode = this.head;
      
      //노드가 존재하지않을때 탐색안함
      if(curNode == null){
        return false;
      //노드가 하나이상 존재할때 탐색
      } else { 
        //노드가 하나만 존재할때(헤드만 있을때) 헤드노드 삭제하고 리턴 
        if(curNode.value == value && curNode.left == null && curNode.right == null){
          this.head = null;
          return true;
        }
        //노드가 두개이상 존재할때 탐색
        while(curNode != null){
          //탐색 대상 노드가 삭제할 노드이면
          if(curNode.value == value){
            //삭제플레그 true로 바꾸고 탐색 종료
            searched = true;
            break;
          //탐색 대상 노드가 삭제할 노드가 아닐때
          //삭제해야하는 값이 탐색 대상노드의 값보다 작으면 왼쪽하위노드를 탐색대상으로 변경
          } else if(value < curNode.value){
            curParentNode = curNode;
            curNode = curNode.left;
          //삭제해야하는 값이 탐색 대상노드의 값보다 작으면 오른쪽하위노드를 탐색대상으로 변경
          } else {
            curParentNode = curNode;
            curNode = curNode.right;
          }
        }
        //노드중에 삭제할 값이 없으면 탐색 중지
        if(searched == false){
          return false;
        }
        //삭제 대상노드 탐색 완료 

        //삭제 대상 노드가 하위 노드가 없는 leaf 노드일때
          if(curNode.left == null && curNode.right == null){
            //삭제 대상의 값이 삭제 대상 노드의 부모노드의 값보다 작으면
            //삭제 대상 노드와 삭제 대상 노드의 부모노드의 왼쪽 하위 노드 삭제
            if(value < curParentNode.value) {
              curNode = null;
              curParentNode.left = null;
            //삭제 대상의 값이 삭제 대상 노드의 부모노드의 값보다 크면
            //삭제 대상 노드와 삭제 대상 노드의 부모노드의 오른쪽 하위 노드 삭제
            } else {
              curNode = null;
              curParentNode.right = null;
            }
            return true;
          //삭제 대상 노드가 하위 왼쪽 노드만 존재하면
          } else if(curNode.left != null && curNode.right == null){
            //삭제 대상의 값이 삭제 대상 노드의 부모노드의 값보다 작으면
            // 삭제 대상 노드의 부모노드의 왼쪽 하위노드는 삭제 대상 노드의 왼쪽 하위노드
            if(value < curParentNode.value){
              curParentNode.left = curNode.left;
            //삭제 대상의 값이 삭제 대상 노드의 부모노드의 값보다 크면
            // 삭제 대상 노드의 부모노드의 오른쪽 하위노드는 삭제 대상 노드의 왼쪽 하위노드  
            } else {
              curParentNode.right = curNode.left;
            }
            //삭제 대상 노드 삭제
            curNode = null;
            return true;
          //삭제 대상 노드가 하위 오른쪽 노드만 존재하면
          } else if(curNode.left == null && curNode.right != null){
            //삭제 대상의 값이 삭제 대상 노드의 부모노드의 값보다 작으면
            // 삭제 대상 노드의 부모노드의 왼쪽 하위노드는 삭제 대상 노드의 오른쪽 하위노드
            if(value < curParentNode.value){
              curParentNode.left = curNode.right;
            //삭제 대상의 값이 삭제 대상 노드의 부모노드의 값보다 크면
            // 삭제 대상 노드의 부모노드의 오른쪽 하위노드는 삭제 대상 노드의 오른쪽 하위노드  
            } else {
              curParentNode.right = curNode.right;
            }
            curNode = null;
            return true;
          //삭제 대상 노드의 하위노드가 양쪽 다 존재하면
          } else {
            Node changeNode = curNode.right;
            Node changeParentNode = curNode.right;
            //더이상 작은 값이 없어야하기때문에 left 중 하위 left 노드가 없는 깊이까지 까지 탐색
            while(changeNode.left != null){
              changeParentNode = changeNode;
              changeNode = changeNode.left;
            }
            //삭제대상 노드 자리로 와야하는 노드가 하위노드가 없으면
              if(changeNode.right == null){
                //삭제대상 노드의 자리로 와야하는 노드의 부모 노드의 왼쪽노드(삭제대상노드의 자리로 와아햐는 노드는 가장작은 값이어야하기때문에)는 이제 없음
                changeParentNode.left = null;
              //오른쪽 하위노드가 존재하면
              } else {
                //그 노드를 부모노드에 연결한다.
                changeParentNode.left = changeNode.right;
              }

            //삭제 대상의 값이 삭제 대상 노드의 부모노드의 값보다 작으면
            if(value < curParentNode.value){
              // 삭제할 노드의 오른쪽노드중 삭제 대상노드의 자리에 위치할 가장 작은 값을 가진 노드 탐색
  
               //삭제대상노드와 위치를 변경할 노드의 위치를 삭제대상 노드 위치로 변경
               curParentNode.left = changeNode;
               //위치변경한 노드의 하위노드를 삭제할 노드의 하위노드로 변경
               changeNode.right = curNode.right;
               changeNode.left = curNode.left;
            } else {
                //currParentNode의 오른쪽 child node에 삭제할 Node의 오른쪽 자식중 가장 작은 node
               curParentNode.right = changeNode;
               //chnageNode의 왼쪽/오른쪽 childNode를 모두 삭제할 노드의 좌우로 변경
                changeNode.right = curNode.right;
                changeNode.left = curNode.left;
            }
            curNode = null;
            return true;
          }
      
      }
    }
}
 class Node {
  Node left;
  Node right;
  int value;
  Node(int value){
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
```
```typescript
class NodeMgnt {
  head:myNode|null;
  constructor(){
    this.head = null;
  }

  insert(value:number):boolean{
    if(!this.head){
      this.head = new myNode(value);
    } else {
      let curNode:myNode|null = this.head;
      while(curNode){
        if(curNode.value > value){
          if(!curNode.left){
            curNode.left = new myNode(value);
            break;
          } else {
            curNode = curNode.left;
          }
        } else {
          if(!curNode.right){
            curNode.right = new myNode(value);
            break;
          } else {
            curNode = curNode.right;
          }
        }
      }
    }
    return true;
  };

  search(value:number):myNode|null {
    if(!this.head){
      return null;
    } else {
      let curNode:myNode | null = this.head;
      while(curNode){
        if(curNode.value === value){
          return curNode;
        } else {
          if(value < curNode.value){
            curNode = curNode.left;
          } else {
            curNode = curNode.right;
          }
        }
      }
    }
    return null;
  }
  delete(value:number):boolean {
    if(!this.head){
      return false;
    } else {
      if(this.head.value === value && !this.head.left && !this.head.right){
        this.head = null;
        return true;
      } else {
        let curNode: myNode | null = this.head;
        let curParentNode = this.head;
        while(curNode){
          if(curNode.value === value){
            break;
          } else {
            curParentNode = curNode;
            if( value < curNode.value ){
              curNode = curNode.left;
            } else {
              curNode = curNode.right;
            }
          }
        }
        if(curNode){
          //leap 노드일때
          if(!curNode.left && !curNode.right){
            if(curNode.value < curParentNode.value){
              curParentNode.left = null
            } else {
              curParentNode.right = null;
            }
          } else if(curNode.left && !curNode.right) {
            if(curNode.value < curParentNode.value){
              curParentNode.left = curNode.left;
            } else {
              curParentNode.right = curNode.left;
            }
          } else if(!curNode.left && curNode.right) {
            if(curNode.value < curParentNode.value){
              curParentNode.left = curNode.right;
            } else {
              curParentNode.right = curNode.right;
            }
          } else {
            let changeNode:myNode|null = curNode.right;
            let changeParentNode = curNode.right;
            while(changeNode && changeNode.left != null){
              changeParentNode = changeNode;  
              changeNode = changeNode.left;
            }
            //changeNode의 하위노드가 있으면
            if(changeNode && changeParentNode && changeNode.right){
                //changeNode는 항상changeParenNode의 왼쪽노드이다.
                changeParentNode.left = changeNode.right;
            //changeNode의 하위노드가 없으면   
            } else if(changeNode && changeParentNode && !changeNode.right) {
              changeParentNode.left = null;
            } else {
              return false;
            }
            if(curNode.value < curParentNode.value){
              curParentNode.left = changeNode;
            } else {
              curParentNode.right = changeNode;
            }
            changeNode.left = curNode.left;
            changeNode.right = curNode.right;
          }
          curNode = null;
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }
}

class myNode {
  value:number;
  left:myNode|null;
  right:myNode|null;

  constructor(value:number){
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

```
