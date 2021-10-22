function solution(distance, rocks, n) {
    //n개의 돌의 제거했을때 나올 수 있는 거리의 최솟값 중 최대값
    rocks.sort((a,b) => a - b);
    //최솟값을 구하기 위해 이분탐색
    let start = 1;
    let end = distance;
    let answer = 0;
    while (start <= end) {
        //기준값
        let mid = Math.floor((start + end) / 2);
        console.log(mid)
        let prev = 0;
        let min_distance = Number.MAX_SAFE_INTEGER;
        let remove_count = 0;
        for (let i = 0; i < rocks.length; i++){
            let now = rocks[i];
            //기준값 보다 작을수 없기때문에 돌을 제거해서 거리를 늘인다
            if (now - prev < mid) {
                remove_count+=1;
            } else {//기존값 보다 같거나 크면 같은값이 없을 수도 있기 때문에 최소값 별도로 저장
                min_distance = Math.min(min_distance, now - prev);
                prev = rocks[i];
            }
        }
        
        //탐색을 완료한 후, 제거한 바위가 n보다 많으면 기준값을 낮춰 제거한 바위를 줄인다.
        if (remove_count > n) {
            end = mid - 1;
        }
        //제거한 바위보다 적으면 기준값을 높여 바위를 늘려야하고 같으면 최대값을 구해야하기때문에 기준값을 낮추어 재탐색
        else {
            start = mid + 1;
            answer = min_distance;
            console.log(answer)
        }
    }   
    return answer;
}
console.log(solution(25, [2, 14, 11, 21, 17], 2));