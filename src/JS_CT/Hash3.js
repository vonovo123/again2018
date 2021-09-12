function solution() {
    const genres = ["classic", "pop", "classic", "classic", "pop"]
    const plays = [500, 600, 150, 800, 2500]
    let idx = 0;
    let tmp = Object.values(genres.reduce((o, t) => {
        let tmp = [idx, plays[idx]];
        idx++;
        if (o[t]) {
            o[t].push(tmp)
        } else {
            o[t] = [tmp]
        }
        return o
    }, {}))

    tmp.sort(function (a, b) {
        let asum = 0;
        let bsum = 0;
        for (let i = 0; i < a.length; i++){
            asum += a[i][1];
        }
        for (let i = 0; i < a.length; i++){
            bsum += b[i][1];
        }
        return bsum - asum;
    })

    for (let i = 0; i < tmp.length; i++){
        tmp[i].sort(function (a, b) {
            if (a[1] > b[1]) return -1;
            if (a[1] === b[1]) {
                return a[0] - b[0];
            }
            if (a[1] < b[1]) return 1;
            
        });
    }
    let answer = [];
    for (let i = 0; i < tmp.length; i++){
        for (let j = 0; j < tmp[i].length; j++){
            if (j < 2) {
                answer.push(tmp[i][j][0])    
            }
        }
    }
    return answer
    
};

solution();