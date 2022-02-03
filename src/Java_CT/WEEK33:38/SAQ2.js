function solution() {
    let priorities = [1, 1, 9, 1, 1, 1];
    let location = 0;
    let pSet = priorities.map((v, i) => {
        return [i, v];
    })
    let answer = []
     
    while (pSet.length != 0) {
        //let w = pSet.splice(0, 1)[0];
        let w = pSet.shift();
        console.log(w)
        let find = pSet.find(v => {
            return v[1] > w[1];
        })
        if (find === undefined) {
            answer.push(w);
        } else {
            pSet.push(w);
        }
    }
    console.log(JSON.stringify(answer))
    for (let i = 0; i < answer.length; i++){
        if (answer[i][0] === location) {
            return i + 1;
        }
    }
    return answer
}

solution();