package FASTCAMPUS.ALGO.D04;

public class Main {
  public static void main(String[] args) {
    NodeMgmt myTree = new NodeMgmt();    
    myTree.insertNode(10);
    myTree.insertNode(15);
    myTree.insertNode(13);
    myTree.insertNode(11);
    myTree.insertNode(14);
    myTree.insertNode(18);
    myTree.insertNode(16);
    myTree.insertNode(19);
    myTree.insertNode(17);
    myTree.insertNode(7);
    myTree.insertNode(8);
    myTree.insertNode(6);
    System.out.println(myTree.delete(15));
    System.out.println("HEAD: " + myTree.head.value);
    System.out.println("HEAD LEFT: " + myTree.head.left.value);
    System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
    System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

    System.out.println("HEAD RIGHT: " + myTree.head.right.value);
    System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
    System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

    System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
    System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);

  }
}


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