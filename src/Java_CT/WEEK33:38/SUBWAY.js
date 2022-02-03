class station {
    constructor() {
        //이동할수 있는 역 
        this.link = [];
        this.dist = 1000000;
    }
}
function solution() {
    let answer = "";
    // let subway = ["1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"];
    // let start = 1;
    // let end = 9;
    let subway = ["1 2 3 4 5 6 7 8 9 10","2 8"]
    let start = 1;
    let end = 10;
    let startStation = 0;
    let endStation = 0;
    let stations = [];
    subway.forEach((v, idx) => {
        let tmpStations = v.split(" "); //호선별 역
        let tmpLine = idx + 1; //호선
        for (let i = 0; i < tmpStations.length; i++){
            let id = parseInt(tmpStations[i]);
            if (stations[id] === undefined) {
                stations[id] = new station();
            }
            
            if (id === start) {
                startStation = tmpLine;
            }
            if (id === end) {
                endStation = tmpLine;
            }
            
            if (i > 0) {
                //이전역
                let preId =  parseInt(tmpStations[i - 1]);
                stations[id].link.push([tmpLine, preId]);
            }
            if (i < tmpStations.length - 1) {
                let nxtId =  parseInt(tmpStations[i + 1]);
                stations[id].link.push([tmpLine,nxtId]);
            }
        }
    })
    
    //출발지점 초기화
    stations[start].dist = 0;
    //[시작라인, 시작역]
    let itr = [[startStation, start]];
    while (itr.length !== 0) {
        let tmp = itr.shift();
        //현재있는 라인
        let nowLine = tmp[0];
        //현재있는 역 정보
        let tmpStation = stations[tmp[1]];
        //현재있는역에서 이동할 수 있는 역들
        let tmpLink = tmpStation.link;
        for (let i = 0; i < tmpLink.length; i++){
            //이동하는역의 라인
            let linkLine = tmpLink[i][0];
            // 이동하는역의 정보 
            let linkIdx = tmpLink[i][1];
            //이동하는역의 라인이 지금역의 라인과 다르면
            if (linkLine !== nowLine) {
                //지금역의 환승횟수에서 한회를 추가한 값이 이동하는 역의 최소환승수보다 작으면
                if (stations[linkIdx].dist > tmpStation.dist + 1) {
                    itr.push([linkLine,linkIdx]);
                    stations[linkIdx].dist = tmpStation.dist + 1;
                }
             //이동하는역의 라인이 지금역의 라인과 같다면   
            } else {

                if (stations[linkIdx].dist > tmpStation.dist) {
                    itr.push([linkLine,linkIdx]);
                    stations[linkIdx].dist = tmpStation.dist;
                }
            }
            
        }
    }
    //console.log(JSON.stringify(itr));
    console.log(JSON.stringify(stations[end]));
    return answer
}

solution();