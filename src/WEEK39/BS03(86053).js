function solution(a, b, g, s, w, t) {
// a,b 새로운도시를 건설하기위한 금과 은
// g[i], s[i] i 도시에 있는 금과 은
// w[i] i 도시에서 편도로 옮길 수 있는 광물의 양
// t[i] i 도시에서 새로운 도시까지 편도로 걸리는 시간.
// 새로운 도시에 필요한 광물을 모두 옮기는대 걸리는 최소 시간
// 이분탐색의 범위 start : 0 (필요한 광물이 0 일때)
// end max t * 2(왕복) *  (max g + max s)
    let start = 0;
    let end = 10e5 * 4 * 10e9;
    let answer = 10e5 * 4 * 10e9;
// 기준점 : 최소시간
    while (start <= end) {
        let mid = Math.floor((start + end) / 2);
        let max_g = 0;
        let max_s = 0;
        let max_w = 0;
        for (let i = 0; i < w.length; i++){
            //i국에 있는 금
            let now_g = g[i];
            //i국에 있는 은
            let now_s = s[i]
            //i 도시에서 새로운 도시까지 편도로 걸리는 시간.
            let now_t = t[i];
            //i 도시에서 새로운 도시까지 편도로 옮길 수 있는 광물의 양
            let now_w = w[i];
            //기준시간내 왕복가능한 횟수w
            let move = Math.floor(mid / (now_t * 2));
            //왕복후 남은시간이 편도시간보다 크면 운반한번 할 수 있음(돌아올순 없지만 상관없음)
            if (mid % (now_t * 2) >= now_t) move += 1;
            //기준시간동안 금만 옮겼을때 옮길 수 있는 양
            max_g += (move * now_w <= now_g) ? move * now_w : now_g;
            //기준시간동안 은만 옮겼을때 옮길 수 있는 양
            max_s += (move * now_w <= now_s) ? move * now_w : now_s;
            //기준시간동안 옮길수 있는 최대 광물의 양
            max_w += (move * now_w <= now_g + now_s) ? move * now_w : now_g + now_s;
        }
        //기준시간안에 광물이동량이 충족하면 더 짦은 기준시간을 구하기위해 범위 줄이기
        if (a <= max_g && b <= max_s && a + b <= max_w) {
            end = mid - 1;
            answer = Math.min(answer, mid);
        //기준시간안에 불가능하면 범위를 늘려서 다시 탐색
        } else {
            start = mid + 1;
        }
    }
    return answer;
}
 
console.log(solution(90, 500, [70, 70, 0], [0, 0, 500], [100, 100, 2], [4, 8, 1]));