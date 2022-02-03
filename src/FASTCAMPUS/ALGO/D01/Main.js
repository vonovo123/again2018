"use strict";
class myQueue {
    constructor() {
        this.queue = [];
    }
    enqueue(value) {
        this.queue.push(value);
    }
    dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            return this.queue.shift();
        }
    }
    isEmpty() {
        return this.queue.length === 0;
    }
}
class myStack {
    constructor() {
        this.stack = [];
    }
    push(value) {
        this.stack.push(value);
        return value;
    }
    ;
    pop() {
        return this.stack.pop();
    }
    ;
    isEmpty() {
        return this.stack.length === 0;
    }
}
const stack = new myStack();
stack.push(1);
console.log(stack.pop());
console.log(stack.isEmpty());
