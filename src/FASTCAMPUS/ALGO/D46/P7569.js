const fs = require('fs');
class Scanner {
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().trim().split('\n');
    this.stringToken = [];
  }
  next(){
    if(this.stringToken.length === 0){
      if(this.read.length > 0){
        this.stringToken = this.read.shift().split(" ");
      } else {
        return null;
      }
    } 
    return this.stringToken.shift();
  }

  nextNumber(){
    const next = this.next();
    if(next){
      return Number(next);
    } else {
      return null;
    }
    
  }

  nextLine(){
    if(this.read.length > 0){
      return this.read.shift();
    } else {
      return null;
    }
    
  }
}
const scanner = new Scanner('stdin.txt');
let M, N, H;
let table,visited;
//Z, Y, X
//상 하 좌 우 위 아래
let dirTable = [[0, -1, 0], [0, 1, 0], [0, 0, -1], [0, 0, 1], [-1, 0, 0], [1, 0, 0]];
const input = function (){
  [M, N, H] = scanner.nextLine().split(" ").map(Number);
  table = Array.from({length : H}, () => Array.from({length : N}, () => Array.from({length : M}, () => 0)));
  visited = Array.from({length : H}, () => Array.from({length : N}, () => Array.from({length : M}, () => -1)));
  for(let i = 0; i < H; i ++){
    let infos = scanner.read.splice(0, N);
    table[i] = infos.map(info => info.split(" ").map(Number));
  }
}
const bfs = function (h, n, m, d){
  let Q = [[h,n,m,d]];
  while(Q.length !== 0){
    let [h, n, m, d] = Q.shift();
    dirTable.forEach(([nh, nn, nm]) => {
      if(nh + h < 0 || nh + h >= H) return;
      if(nn + n < 0 || nn + n >= N) return;
      if(nm + m < 0 || nm + m >= M) return;
      if(visited[nh + h][nn + n][nm + m] !== -1) return;
      visited[nh + h][nn + n][nm + m] = d + 1;
      Q.push([nh + h, nn + n,nm + m, d + 1]);
    })
  }
  
}

const pro = function (){
  for(let h = 0; h < H; h ++){
    for(let n = 0; n < N; n ++){
      for(let m = 0; m < M; m ++){
        if(table[h][n][m] === 1){
          visited[h][n][m] = 0;
          bfs(h,n,m,0);
        } else if(table[h][n][m] === -1){
          visited[h][n][m] = 0;
        }
      }
    }
  }
  // console.log(visited);
  let max = 0;
  for(let h = 0; h < H; h ++){
    for(let n = 0; n < N; n ++ ){
      for(let m = 0; m < M; m ++){
        if(visited[h][n][m] === -1){
          console.log(-1);
          return;
        }
        max = Math.max(max , visited[h][n][m]);
      }
    }
  }
  console.log(max);
}


const solve = function(){
  input();
  pro();
}

solve();