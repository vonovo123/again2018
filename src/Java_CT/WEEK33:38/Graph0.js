
class node {

    constructor( idx ) {
        this.idx = idx;
        this.link = [];
        this.dist = 20001;
    }
}
function solution() {
    let n = 6;
    
    let vertex = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]];
    
    let graph = []
    vertex.forEach(v => {
        if (graph[v[0]] === undefined) {
                graph[v[0]] = new node(v[0]);
                graph[v[0]].link.push(v[1])
                if (graph[v[1]] === undefined) {
                    graph[v[1]] = new node(v[1]);
                    graph[v[1]].link.push(v[0])
                } else {
                    graph[v[1]].link.push(v[0])
                } 
         } else {
                graph[v[0]].link.push(v[1])
            if (graph[v[1]] === undefined) {
                graph[v[1]] = new node(v[1]);
                graph[v[1]].link.push(v[0])
            } else {
                graph[v[1]].link.push(v[0])
            } 
        }
        })

    let max = 0;
    graph[1].dist = 0;
    let nodes = [graph[1]]; //1번 노드
    while (nodes.length != 0) {
        let next = nodes.shift();
        let nLink = next.link;
        for (let i = 0; i < nLink.length; i++){
            let tmp = nLink[i];
            if (next.dist + 1 < graph[tmp].dist) {
                graph[tmp].dist = next.dist + 1;
                if (max < graph[tmp].dist) max = graph[tmp].dist;
                 nodes.push(graph[tmp]);
            }
        }
    }
    let answer = 0
    for (let i = 1; i < graph.length; i++){
        if (graph[i].dist === max) answer++;
    }
    
    return answer;
}

solution();