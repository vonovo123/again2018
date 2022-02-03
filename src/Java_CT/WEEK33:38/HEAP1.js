

class minHeap{
    constructor(){
        this.heap = []
    }
    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]]
    }
    popheap() {
        return this.heap.shift();
    }
    pushHeap(v) {
        this.heap.push(v);
        let curIdx = this.heap.length - 1;
        let parIdx = curIdx - 1;
        while (curIdx > 0 && this.heap[curIdx][1] < this.heap[parIdx][1]) {
            this.swap(curIdx, parIdx);
            curIdx = parIdx;
            parIdx = curIdx - 1;
        }
    }
}
function solution() { //최소힙
    //[요청시작시간 , 작업소요시간]
    let jobs = [[0, 3], [1, 9], [2, 6]]	; // 9
    //let jobs = [[0, 10], [5, 9], [6, 6], [7, 9], [8, 6], [9, 9], [10, 6], [15, 5] ];
    let heap = new minHeap();
    // -1 0 0 10 10 16
    //[6, 6]
    let start = -1;
    let now = 0;
    let i = 0;
    let answer = 0;
    while (i < jobs.length) {
        for (let j = 0; j < jobs.length; j++){
          if (start < jobs[j][0] && jobs[j][0] <= now) {
           heap.pushHeap(jobs[j]) 
            }
        }
        if (heap.heap.length == 0) {
            now++;
        } else {
            let current = heap.popheap();
            start = now;
            now += current[1];
            answer += (now - current[0]);
            //console.log("start", start);
            //console.log("now", now);
            //console.log("current", current);
            i++;
        }
    }
    return Math.floor(answer / jobs.length);   
}

solution();