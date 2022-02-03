function solution(N, number) {
  let arr = [''];
  for (let i = 1; i <= 8; i++) {
    let tmp = '';
    for (let j = 0; j < i; j++) {
      tmp += N;
    }
    arr.push([parseInt(tmp)]);
  }

  if (number === N) {
    return 1;
  }
  let answer = -1;
  for (let i = 2; i <= 8; i++) {
    for (let j = 1; j < i; j++) {
      let aArray = arr[j];
      let bArray = arr[i - j];
      for (let a = 0; a < aArray.length; a++) {
        for (let b = 0; b < bArray.length; b++) {
          arr[i].push(aArray[a] + bArray[b]);
          arr[i].push(aArray[a] - bArray[b]);
          arr[i].push(aArray[a] * bArray[b]);
          if (aArray[a] !== 0 && bArray[b] !== 0) {
            arr[i].push(Math.floor(aArray[a] / bArray[b]));
          }
          // else {
          //   arr[i].push(0);
          // }
        }
      }
    }
    arr[i].find(v => {
      if (v === number) {
        answer = i;
      }
    });
    if (answer != -1) {
      break;
    }
  }
  //console.log(arr);
  return answer;
}
// 5 가 1개
// 5
// 5가 2개
// 55, 5*5, 5/5, 5+5, 5-5
//5가 3개
// 555, 55 * 5, 55/5 , 55+5, 55-5
// 5*5*5, 5*5/5, 5*5+5, 5*5-5
// 5/5*5, 5/5/5, 5/5+5, 5/5-5
//(5+5)*5, (5+5)/5, (5+5)+5, (5+5)-5
//(5-5)*5, (5-5)/5, (5-5)+5, (5-5)-5

console.log(solution(8, 53));
