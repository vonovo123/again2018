class Heap {
  constructor(){
    this.arr = [NaN];
  }
  _swap(a, b){
    let tmp = this.arr[a];
    this.arr[a] = this.arr[b];
    this.arr[b] = tmp;
  }
  parintAll(){
    console.log(this.arr);
  }
  add(value){
    this.arr.push(value); 
    let idx = this.arr.length - 1;
    let parentIdx = this._moveUp(idx);
    while(parentIdx != -1){
      this._swap(idx, parentIdx);
      idx = parentIdx;
      parentIdx = this._moveUp(idx);
    }
    this.parintAll();
    return true;
  }
  _moveUp(idx){
    if(idx === 1){
      return -1;
    }
    let parentIdx = Math.floor(idx / 2);
    //check
    if(this.arr[parentIdx] > this.arr[idx]){
      return parentIdx;
    }
    return -1;
  }
  _moveDown(idx){
    let result = [idx * 2, idx * 2 + 1];
    if (result[0] >= this.arr.length) {
        result[0] = -1;
    }
    if (result[1] >= this.arr.length) {
        result[1] = -1;
    }
    return result;
  }
  pop(){
    if(!this.arr[1]) return null;
    const pop = this.arr[1];
    let idx = 1;
    this._swap(idx, this.arr.length - 1);
    this.arr.pop();
    let hasChild = this._moveDown(idx);
    while(hasChild[0] !== -1 || hasChild[1] !== -1){
      const left = hasChild[0];
      const right = hasChild[1]
      if(left != -1 && right !== -1){
        //check
        if(this.arr[left] < this.arr[right]){
            if(this.arr[left] < this.arr[idx]){
              this._swap(left, idx);
              idx = left;
            }
        } else{
          if(this.arr[right] < this.arr[idx]){
            this._swap(right, idx);
            idx = right;
          }
        }
      } else {
        if(this.arr[left] < this.arr[idx]){
          this._swap(left, idx);
          idx = left;
        } else {
          break;
        }
      }
      hasChild = this._moveDown(idx);
    }
    return pop;
  }

}

const heap = new Heap();

heap.add(6);
heap.add(5);
heap.add(4);
heap.add(3);
heap.add(2);
heap.add(1);

console.log(heap.pop());
console.log(heap.pop());
console.log(heap.pop());
console.log(heap.pop());
console.log(heap.pop());
console.log(heap.pop());
