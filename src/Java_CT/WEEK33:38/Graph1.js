function solution(n, results) {
    function player () {
        this.w = [];
        this.l = [];
        this.p = 0;
    }
    let players = [{}];
    for(let i = 1; i <= n ; i ++){
        players[i] = new player(0,0);
    }
    results.forEach(result => {
        let w = result[0];
        let l = result[1];
        
        players[w].w.push(l);
        players[l].l.push(w);
    })
    //console.log(players)
    players.forEach((player, i) => {
        if(i !== 0){
            let winA = player.w;//이긴리스트 
            let loseA = player.l;
            winA.forEach((p, j) =>{
                //현재팀이 이긴팀이 이긴팀을 현재팀의 이긴팀에 복사
                players[p].w.forEach(v => {
                    if(players[i].w.indexOf(v) === -1){
                      players[i].w.push(v);  
                    }
                })
                //players[i].w = players[i].w.concat(players[p].w);
                //현재팀을 이긴팀을 현재팀에 진팀의 진팀에 복사
                players[i].l.forEach(v => {
                    if(players[p].l.indexOf(v) === -1){
                        players[p].l.push(v);
                    }
                })
            })
            
            loseA.forEach((p, j) => {
                //현재팀을 이긴팀의 이긴팀에 현재팀이 이긴팀 복사
                players[i].w.forEach(v => {
                    if(players[p].w.indexOf(v) === -1){
                        players[p].w.push(v);
                    }
                })
                //현재팀을 이긴팀이 진팀을 현재팀의 진팀에 복사
                players[p].l.forEach(v => {
                    if(players[i].l.indexOf(v) === -1){
                        players[i].l.push(v);
                    }
                })
            })
        }
    })
    let answer = 0;
    players.forEach((player, i) => {
        //console.log(player);
        if(i !== 0){
            if((player.w.length + player.l.length) === n - 1){
                answer ++;
            }  
        }
    })
        //console.log(players)
        
    
    
       
    return answer;
}