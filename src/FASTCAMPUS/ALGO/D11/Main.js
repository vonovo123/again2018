var KruscalEdge = /** @class */ (function () {
    function KruscalEdge(weight, edgeV, edgeU) {
        this.weight = weight;
        this.edgeV = edgeV;
        this.edgeU = edgeU;
    }
    return KruscalEdge;
}());
var vertecies = ['A', 'B', 'C', 'D', 'E', 'F', 'G'];
var kruscalEdges = [];
var parents = new Map();
var ranks = new Map();
kruscalEdges.push(new KruscalEdge(7, "A", "B"));
kruscalEdges.push(new KruscalEdge(5, "A", "D"));
kruscalEdges.push(new KruscalEdge(9, "B", "D"));
kruscalEdges.push(new KruscalEdge(8, "B", "C"));
kruscalEdges.push(new KruscalEdge(6, "D", "F"));
kruscalEdges.push(new KruscalEdge(7, "D", "E"));
kruscalEdges.push(new KruscalEdge(5, "C", "E"));
kruscalEdges.push(new KruscalEdge(7, "B", "E"));
kruscalEdges.push(new KruscalEdge(8, "F", "E"));
kruscalEdges.push(new KruscalEdge(11, "F", "G"));
kruscalEdges.push(new KruscalEdge(9, "G", "E"));
kruscalEdges.sort(function (v, u) { return v.weight - u.weight; });
//초기화
vertecies.forEach(function (vertex) {
    parents.set(vertex, vertex);
    ranks.set(vertex, 0);
});
//루트노드 찾기
function find(vertex) {
    if (parents.get(vertex) !== vertex) {
        parents.set(vertex, find(parents.get(vertex) + ""));
    }
    return parents.get(vertex) + "";
}
//union-by-rank
function unionByRank(edgeV, edgeU) {
    var rootV = find(edgeV);
    var rootU = find(edgeU);
    if (rootV > rootU) {
        parents.set(rootU, rootV);
    }
    else {
        parents.set(rootV, rootU);
        if (rootV === rootU) {
            var vRank = ranks.get(rootV);
            if (vRank) {
                ranks.set(rootV, vRank + 1);
            }
        }
    }
}
var mst = [];
kruscalEdges.forEach(function (edge) {
    var v = parents.get(edge.edgeV);
    var u = parents.get(edge.edgeU);
    if (v && u) {
        var rootV = find(v);
        var rootU = find(u);
        console.log("v : ".concat(v, ", u : ").concat(u, ", rootV : ").concat(rootV, ", rootU : ").concat(rootU));
        if (rootV !== rootU) {
            unionByRank(v, u);
            mst.push(edge);
        }
    }
});
console.log(mst);
