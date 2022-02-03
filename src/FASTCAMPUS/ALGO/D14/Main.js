

const validate = function(candidate , currentCol){
  // currentRow : 퀸을 위치시킬 행
  // currentCol : 퀸을 위치시킬 열
  let currentRow = candidate.length;
  for(let i = 0; i < currentRow; i ++){
    //각행에 위치한 퀸의 열
    let queenCol = candidate[i];
    if((queenCol === currentCol) || Math.abs(currentRow - i) === Math.abs(currentCol - queenCol)){
      return false;
    }
  }
  return true;
}
const nqueen = function(N, depth, candidate,){
  if(depth === N){
    console.log(candidate);
    return;
  }
  for(let i = 0; i < N ; i ++){
    if(validate(candidate, i)){
      candidate.push(i);
      nqueen(N, depth + 1, candidate);
      candidate.pop();
    }
  }
}
nqueen(4,0,[]);