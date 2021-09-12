
function solution() {
    let v = [[1, 4], [3, 4], [3, 10]];
    console.log(v[0][0] ^ v[1][0])
    console.log(v[1][0] ^ v[2][0])
    console.log(v[0][0] ^ v[1][0] ^ v[2][0]);
    console.log(v[0][1] ^ v[1][1] ^ v[2][1]);
    
    let answer = {};
    return answer;
}

solution();