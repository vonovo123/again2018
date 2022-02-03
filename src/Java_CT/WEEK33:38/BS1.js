
function findEmptyBooth() {
    
}
function solution() {
    let n = 6;
    let times = [7, 10];
    let fastest_booth = times.reduce((prev, cur) => {
        return prev < cur ? prev : cur;
    });

    let min_checkTime = fastest_booth;
    let max_checkTime = fastest_booth * n;
    let start = min_checkTime;
    let end = max_checkTime;
    
    while (start <= end) {
        let pivot = Math.floor((start + end) / 2);
        let chkCount = 0;
        
        for (let i = 0; i < times.length; i++){
            chkCount += Math.floor(pivot / times[i]);
            if (chkCount >= n) {
                min_checkTime = pivot;
                end = pivot - 1;
                break;
            }
        }
        //console.log(`start ${start} end ${end} pivot ${pivot} chkCount ${chkCount}`);
        if (chkCount < n) {
            start = pivot + 1;
        }
    }
    //console.log(min_checkTime)
    return min_checkTime;

    
    
}

solution();