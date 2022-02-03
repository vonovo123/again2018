"use strict";
class Heap {
    constructor(head) {
        this.array = [];
        this.array.push(NaN);
        this.array.push(head);
        console.log(this.array);
    }
    swap(a, b) {
        let tmp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = tmp;
    }
    printAll() {
        console.log(this.array);
    }
    insert(data) {
        this.array.push(data);
        let idx = this.array.length - 1;
        let parentIdx = this.moveUp(idx);
        while (parentIdx !== -1) {
            this.swap(parentIdx, idx);
            idx = parentIdx;
            parentIdx = this.moveUp(idx);
        }
        this.printAll();
        return true;
    }
    pop() {
        if (!this.array[1]) {
            return null;
        }
        const poppedData = this.array[1];
        let idx = 1;
        this.swap(idx, this.array.length - 1);
        this.array.pop();
        let hasChild = this.moveDown(idx);
        while (hasChild[0] !== -1 || hasChild[1] !== -1) {
            console.log(hasChild);
            let left = hasChild[0];
            let right = hasChild[1];
            if (left !== -1 && right !== -1) { //자식 노드가 둘다 존재하면
                if (this.array[left] > this.array[right]) {
                    if (this.array[left] > this.array[idx]) {
                        this.swap(left, idx);
                        idx = left;
                    }
                }
                else {
                    if (this.array[right] > this.array[idx]) {
                        this.swap(right, idx);
                        idx = right;
                    }
                }
            }
            else if (left != -1) { //왼쪽만 존재하면
                if (this.array[left] > this.array[idx]) {
                    this.swap(left, idx);
                    idx = left;
                }
            }
            //오른쪽만 존재할 순 없다.
            hasChild = this.moveDown(idx);
        }
        return poppedData;
    }
    moveUp(idx) {
        if (idx === 1) {
            return -1;
        }
        let parent_idx = Math.floor(idx / 2);
        if (this.array[parent_idx] < this.array[idx]) {
            return parent_idx;
        }
        return -1;
    }
    moveDown(idx) {
        let result = [idx * 2, idx * 2 + 1];
        if (idx * 2 >= this.array.length) {
            result[0] = -1;
        }
        if (idx * 2 + 1 >= this.array.length) {
            result[1] = -1;
        }
        return result;
    }
}
const heap = new Heap(15);
heap.insert(10);
heap.insert(8);
heap.insert(5);
heap.insert(4);
heap.insert(20);
heap.pop();
heap.printAll();
