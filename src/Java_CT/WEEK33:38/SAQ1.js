function solution() {
    let progresses = [99, 99, 99];
    let speeds = [1, 30, 5];
    // let progresses = [95, 90, 99, 99, 80, 99];
    // let speeds = [1, 1, 1, 1, 1, 1];
    let answer = []

    let rProgresses = progresses.map((v, i) => {
        return (100 - v) % speeds[i] === 0 ? Math.floor((100 - v) / speeds[i]) : Math.floor((100 - v) / speeds[i]) + 1
    })
    console.log(JSON.stringify(rProgresses))
    let s = rProgresses[0];
    let c = 1;
    for (let i = 1; i < rProgresses.length; i++){
        if (s > rProgresses[i]) c++;
        else {
            answer.push(c);
            s = rProgresses[i];
            c = 1;
        }
    }
    answer.push(c);
    console.log(JSON.stringify(answer))
    return answer
}

solution();