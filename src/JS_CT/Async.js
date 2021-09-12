function getMember() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("get")
            resolve(["ABC", "DEF", "GHI"]);
        }, 2000)
    })
    //console.log('get');
}

function isOnline(mem) {
    return new Promise((resolve, reject) => {
        
        setTimeout(() => {
            console.log(mem);
            resolve("true");
        }, 2000)
    })
}
async function solution(get) {
    let memlist = await get();
    
    let promises = memlist.map(async mem => {
        let isOn = await isOnline(mem);
        return isOn;
    })


    let answer = await Promise.all(promises);
    console.log(JSON.stringify(answer))
    return memlist
}

solution(getMember);