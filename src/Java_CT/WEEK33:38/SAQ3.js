function solution() {
    let bridge_length = 100;
    let weight = 100;
    let truck_weights = [10];
    let waiting = truck_weights.map((v) => {
        return [v, 0];//[무개 ,이동거리]
    })
    //console.log(JSON.stringify(waiting))
    let on = [];
    let off = [];
    let nWeight = 0;
    let time = 0;
    while (off.length != truck_weights.length) {        
        //맨앞 트럭 선택
  
        //시간 된 차 빼기
       if (on.length > 0) {
            if (on[0][1] === bridge_length) {
                let tmp = on.shift()
                off.push(tmp);
                nWeight -= tmp[0];
            }
        }
        
        if (waiting.length > 0) {
            let tmp = waiting[0];
            if (nWeight + tmp[0] <= weight) {//다리위로 올라올 수 있으면
                on.push(waiting.shift()); //다리위로 올리고
                nWeight += tmp[0]; //무개 갱신
            }
        }

              //다리위에 있는차들 시간 추가
        for (let i = 0; i < on.length; i++){
            on[i][1] ++;
        }
        time++;
        // console.log("time", time)
        // console.log("wating",JSON.stringify(waiting))
        // console.log("on", JSON.stringify(on))
        // console.log("off", JSON.stringify(off))
        // console.log("nWeight", JSON.stringify(nWeight))
        // console.log("");
        
     }
    let answer = time;

    return answer
}

solution();