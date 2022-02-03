function solution(numbers, target) {
  let queue = [];
  let len = numbers.length;
  let answer = 0;
  function dfs() {
    if (queue.length === len) {
      let result = 0;
      for (let i = 0; i < len; i++) {
        if (queue[i] === 0) {
          result -= numbers[i];
        } else {
          result += numbers[i];
        }
      }
      if (target === result) {
        answer++;
      }

      return;
    }
    for (let i = 0; i < 2; i++) {
      queue.push(i);
      dfs();
      queue.pop();
    }
  }
  dfs();
  return answer;
}

solution([1, 1, 1, 1, 1], 3);
