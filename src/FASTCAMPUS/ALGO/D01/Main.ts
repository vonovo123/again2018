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

const stack = new myStack<number>();

stack.push(1);
console.log(stack.pop());
console.log(stack.isEmpty());
