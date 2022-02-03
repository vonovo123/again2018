

let visited = [];
let v = [];

let keys = [];
let sum = 0;
dfs = (idx) => {
    if (v.length > keys.length) {
        return;
    } else {
        if (v.length > 0) {
            let tmp = 1;
            for (let i = 0; i < v.length; i++){
                 tmp *= hash[v[i]];
            }
            sum += tmp
        }   
    }
    for (let i = idx; i < keys.length; i++) {
        if (v.indexOf(keys[i]) == -1){
            v.push(keys[i])
            dfs(i + 1);
            v.pop()
        }
    }
}

function solution() {
    const clothes = [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
    //Reduce로 배열 키벨류 만드는법
    let tmp = clothes.reduce((obj, t) => {
        console.log(obj)
        obj[t[1]] = obj[t[1]] ? obj[t[1]] + 1 : 1;
        return obj
    }, {}) //초깃값 {}
    console.log("tmp", JSON.stringify(tmp))
    // console.log(tmp.reduce((a, b) => {
    //     console.log(a)
    //     console.log(b)
    //     return  a * ( b + 1)
    // }, 1) - 1)
    // // tmp.reduce((a, b) => {
    //     console.log(a)
    //     console.log(b)
    // })

    // Object.values(clothes.reduce((obj, t)=> {
    //     obj[t[1]] = obj[t[1]] ? obj[t[1]] + 1 : 1;
    //     return obj;
    // } , {})).reduce((a,b)=> a*(b+1), 1)-1;    
    
};


solution();