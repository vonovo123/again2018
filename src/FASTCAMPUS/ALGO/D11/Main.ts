class KruscalEdge {
  weight:number;
  edgeV:string;
  edgeU:string;
  constructor(weight:number, edgeV:string, edgeU:string){
    this.weight = weight;
    this.edgeV = edgeV;
    this.edgeU = edgeU;
  }
}


const vertecies:string[] = ['A','B','C','D','E','F','G'];
const kruscalEdges:KruscalEdge[] = [];

const parents:Map<string, string> = new Map<string,string>();
const ranks:Map<string, number> = new Map<string,number>();

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
kruscalEdges.sort((v,u) => v.weight - u.weight)
//초기화
vertecies.forEach(vertex => {
  parents.set(vertex,vertex);
  ranks.set(vertex, 0);
});
//루트노드 찾기
function find(vertex:string):string{
  if(parents.get(vertex) !== vertex){
    parents.set(vertex, find(parents.get(vertex) + ""));
  }
  return  parents.get(vertex) +"";
}

//union-by-rank
function unionByRank(edgeV:string, edgeU:string) {
  const rootV = find(edgeV);
  const rootU = find(edgeU);
  if(rootV > rootU){
    parents.set(rootU, rootV);
  } else {
    parents.set(rootV, rootU);
    if(rootV === rootU){
      const vRank = ranks.get(rootV);
      if(vRank){
        ranks.set(rootV, vRank + 1);
      } 
    }
  }
}
const mst:KruscalEdge[] = [];
kruscalEdges.forEach(edge => {
  const v = parents.get(edge.edgeV);
  const u = parents.get(edge.edgeU);
  if(v && u){
    const rootV = find(v);
    const rootU = find(u);
    console.log(`v : ${v}, u : ${u}, rootV : ${rootV}, rootU : ${rootU}`);
    if(rootV !== rootU){
      unionByRank(v, u);
      mst.push(edge);
    }
  }
})

console.log(mst);