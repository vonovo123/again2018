class minHeap { 
    constructor() {
        this.heap = [null]; //index 계산을 편하게 하기위해 1부터 시작
    }
    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]] 
    }
    heapPush(v) {
        this.heap.push(v);
        let curIdx = this.heap.length - 1; // 5(0)
        let parIdx = (curIdx / 2) >> 0; // 2
        while (curIdx > 1 && (this.heap[parIdx] > this.heap[curIdx])) {
            this.swap(parIdx, curIdx);
            curIdx = parIdx;
            parIdx = (curIdx / 2) >> 0;
        }
    }
    heapPop() {
        const min = this.heap[1];
        if (this.heap.length <= 2) this.heap = [null];
        else
        this.heap[1] = this.heap.pop();//맨끝값을 최상단으로

        let curIdx = 1;
        let leftIdx = curIdx * 2;
        let rightIdx = leftIdx + 1;

        // 루트 노드의 오른쪽 왼쪽 자식노드 중 하나만 있는경우
        if (undefined === this.heap[leftIdx]) {
            return min // 왼쪽이없으면 루트노드만 있기때문에 루트노드값 반환
        }
        if (undefined === this.heap[rightIdx]) { //왼쪽만 있는경우
            if (this.heap[curIdx] > this.heap[leftIdx]) {
                this.swap(curIdx, leftIdx);
            }
            return min;
        }

        //둘다 있어서 자손노드까지 봐야할 경우
        while (this.heap[curIdx] > this.heap[leftIdx] || this.heap[curIdx] > this.heap[rightIdx]) {
            const minIdx = this.heap[leftIdx] < this.heap[rightIdx] ? leftIdx : rightIdx;
            this.swap(minIdx, curIdx);
            curIdx = minIdx;
            leftIdx = curIdx * 2;
            rightIdx = leftIdx + 1;
        }
        return min;
    }

}

class maxHeap {
    constructor() {
        this.heap = [null];
    }

    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]] 
    }
    heapPush(v) {
        this.heap.push(v);
        let curIdx = this.heap.length - 1;
        let parIdx = (curIdx / 2) >> 0;

        while (curIdx > 1 && this.heap[curIdx] > this.heap[parIdx]) {
            this.swap(curIdx, parIdx);
            curIdx = parIdx;
            parIdx = (curIdx / 2) >> 0;
        }
    }
    heapPop() {
        const max = this.heap[1];
        if (this.heap.length <= 2) {//루트노드값만 있으면
            this.heap = [null];
        } else {
            //맨끝값을 맨 앞으로
            this.heap[1] = this.heap.pop();
        }
        //큰값이 부모노드로 오도록 수정
        let curIdx = 1;
        let leftIdx = curIdx * 2;
        let rightIdx = leftIdx + 1;
        //루트노드의 하위 왼쪽 노드가 없으면 더이상 하위노드가 없는것이기때문에 pop value 리턴
        if (undefined === this.heap[leftIdx]) {
            return max
        }
        //루트노드의 하위 오른쪽 요소가 없으면 하위 왼쪽과 루트노드 값 비교 
        if (undefined === this.heap[rightIdx]) {
            if (this.heap[leftIdx] > this.heap[curIdx]) {
                this.swap(leftIdx, curIdx);
            }
            return max;
        }
        while (this.heap[curIdx] < this.heap[leftIdx] || this.heap[curIdx] < this.heap[rightIdx]){
            const maxIdx = this.heap[leftIdx] > this.heap[rightIdx] ? leftIdx : rightIdx;
            
            this.swap(curIdx, maxIdx);
            curIdx = maxIdx;
            leftIdx = curIdx * 2;
            rightIdx = leftIdx + 1;
        }
        return max;

    }
}
function solution() {
    let answer = ''
    let heap = new minHeap();
    
    return answer
}

solution();