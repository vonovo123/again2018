function solution(n, computers) {
    let links = [];
    let networks = [];
    computers.forEach((com,i) => {
        links[i] = [];
        com.forEach((net, j) => {
            if(i!==j) {
                if(net === 1){
                    links[i].push(j)    
                }
            }
        });
    });
    
    links.forEach( (link , i) => {
        let flag = -1;
        networks.forEach((net, j) => {
            if(net.includes(i)){
                flag = j;
            }
        })
      

        if(flag === -1){
            //new network
            let newNet = [i];
            let bfs = [i];
            while(bfs.length !== 0){
                let next = bfs.pop();
                let link = links[next];
                for(let j = 0; j < link.length; j ++){
                    if(!newNet.includes(link[j])){
                          newNet.push(link[j]);
                          bfs.push(link[j]);
                    }
                }
            }
            networks.push(newNet);
        }
    })
    // console.log(links)
    // console.log(networks)
    var answer = networks.length;
    return answer;
}