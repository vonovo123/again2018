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
const myLinkedList = new doubleLinkedList();

myLinkedList.addNode(1);
myLinkedList.addNode(2);
myLinkedList.addNode(3);

myLinkedList.insertToNext(3,4);
myLinkedList.insertToNext(2,5);
myLinkedList.insertToNext(1,6);

myLinkedList.insertToPrev(4,7);
myLinkedList.insertToPrev(5,8);
myLinkedList.insertToPrev(6,9);
myLinkedList.delNode(1);
myLinkedList.delNode(2);
myLinkedList.delNode(3);
myLinkedList.delNode(4);
myLinkedList.delNode(5);
myLinkedList.delNode(6);
myLinkedList.delNode(7);
myLinkedList.delNode(8);
myLinkedList.printAll();
