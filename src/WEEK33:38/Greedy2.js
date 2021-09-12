function solution(number, k) {
    let a = k;
    let answer = '';
    let idx = 0;
    let max = 0;
    let maxIdx = 0;
    while(true){
             if(idx <= k) {
                if(max < Number(number[idx])){
                    max = Number(number[idx]);
                    maxIdx = idx;
                }
                 if(max === 9){
                     idx = k + 1;
                 } else {
                    idx ++;     
                 }
                    
            } else {
                answer += max;
                idx = maxIdx + 1;
                max = 0;
                k = k + 1;
            }
         if(answer.length === number.length - a){
            break;
        }
    }

    return answer;
}