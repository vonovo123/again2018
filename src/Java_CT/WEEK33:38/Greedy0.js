function solution() {
    let n = 5;
    let lost = [2,4];
    let reverse = [1, 3, 5];

    let t = lost.filter(l => {
        //여벌을 가진 주변에 있는사람과 나(잃어버린 사람도 여벌이 있을 수 있음) 
        let rs = reverse.filter(r => {
            return Math.abs(l - r) <= 1
        })
        console.log(l)
        console.log(rs)
        
        console.log(" ");
    })
    console.log(t)
}
solution();