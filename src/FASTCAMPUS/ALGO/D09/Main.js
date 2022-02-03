"use strict";
class BFS {
    search(graph, start) {
        let visited = [];
        let needVisit = [];
        needVisit.push(start);
        while (needVisit.length !== 0) {
            const node = needVisit.shift();
            if (node) {
                if (visited.indexOf(node) == -1) {
                    visited.push(node);
                    const child = graph.get(node);
                    if (child) {
                        child.forEach(v => {
                            needVisit.push(v);
                        });
                    }
                }
            }
            else {
                continue;
            }
        }
        console.log(visited);
    }
}
class DFS {
    search(graph, start) {
        const visited = [];
        const needVisit = [];
        needVisit.push(start);
        while (needVisit.length !== 0) {
            if (needVisit[0]) {
                const node = needVisit.pop();
                if (node) {
                    if (visited.indexOf(node) === -1) {
                        visited.push(node);
                        const child = graph.get(node);
                        if (child) {
                            child.forEach(v => {
                                needVisit.push(v);
                            });
                        }
                    }
                }
                else {
                    break;
                }
            }
        }
        console.log(visited);
    }
}
const graph = new Map();
graph.set("A", ["B", "C"]);
graph.set("A", ["B", "C"]);
graph.set("B", ["A", "D"]);
graph.set("C", ["A", "G", "H", "I"]);
graph.set("D", ["B", "E", "F"]);
graph.set("E", ["D"]);
graph.set("F", ["D"]);
graph.set("G", ["C"]);
graph.set("H", ["C"]);
graph.set("I", ["C", "J"]);
graph.set("J", ["I"]);
const dfs = new DFS();
dfs.search(graph, "A");
