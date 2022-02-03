let numbersA = [];
let v = [];
let visited = [];
let result = [];
function dfs() {
    if (v.length > 0) {
        if (v[0] !== '0') {
            let tmp = v.join('');
            if (result.indexOf(tmp) === -1) {
               result.push(v.join(''));     
            }
               
        }
     
    }
    if (v.length > numbersA.length) {
        return;
    }
    for (let i = 0; i < numbersA.length; i++){
        if (!visited[i]) {
            v.push(numbersA[i]);
            visited[i] = true;
            dfs();
            v.pop();
            visited[i] = false;
        }
    }
}
function solution() {
    let numbers = "011"
    numbersA = numbers.split('');
    dfs(0);
    console.log(result);

    let max = parseInt(numbers.split('').sort((a, b) => { return b - a }).join(''));
    let che = new Array(max + 1).fill(true);
    che[0] = false;
    che[1] = false;
    let maxIdx = Math.floor(Math.sqrt(max));
    //최대값 까지 체만들기 
    for (let i = 2; i <= maxIdx; i++){
        let idx = 2;
        let tmp = 0
        while (i * idx <= max) {
            che[i * idx] = false;
            idx++;
        }
    }
    let count = 0;
    for (let i = 0; i < result.length; i++){
        if (che[result[i]]) count++;
    }
    return count;

}

solution();