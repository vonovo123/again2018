"use strict";
class DijkstraPath {
    //우선순위큐 활용
    //한 노드에서 다른 노드로 최소비용으로 이동하는 경로를 구하는 알고리즘 
    search(edges, start) {
        const distances = new Map();
        const queue = [];
        [...edges.keys()].forEach(key => {
            distances.set(key, Number.MAX_SAFE_INTEGER);
        });
        distances.set(start, 0);
        queue.push(new Edge(0, start));
        while (queue.length != 0) {
            console.log(queue);
            queue.sort((v, u) => {
                return v.weight - u.weight;
            });
            const next = queue.shift();
            console.log(next);
            if (next) {
                const curVertex = next.vertex;
                const curWeight = next.weight;
                const minCurWeight = distances.get(curVertex);
                if (minCurWeight != undefined) {
                    console.log(minCurWeight);
                    if (minCurWeight < curWeight) {
                        continue;
                    }
                }
                else {
                    continue;
                }
                const nodeList = edges.get(curVertex);
                console.log(nodeList);
                if (nodeList) {
                    for (let i = 0; i < nodeList.length; i++) {
                        const adjacent = nodeList[i];
                        if (distances.get(adjacent.vertex)) {
                            let minWeight = distances.get(adjacent.vertex);
                            if (minWeight) {
                                const totalWeight = curWeight + adjacent.weight;
                                if (totalWeight < minWeight) {
                                    distances.set(adjacent.vertex, totalWeight);
                                    queue.push(new Edge(totalWeight, adjacent.vertex));
                                }
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            else {
                break;
            }
        }
        return distances;
    }
}
class Edge {
    constructor(weight, vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}
const edges = new Map();
edges.set("A", [new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D")]);
edges.set("B", []);
edges.set("C", [new Edge(5, "B"), new Edge(2, "D")]);
edges.set("D", [new Edge(3, "E"), new Edge(5, "F")]);
edges.set("E", [new Edge(1, "F")]);
edges.set("F", [new Edge(5, "A")]);
const dijkstraPath = new DijkstraPath();
console.log(dijkstraPath.search(edges, 'A'));
