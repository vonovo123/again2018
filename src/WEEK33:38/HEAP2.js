function solution(operations) {
  let q = [];
  for (let opr of operations) {
    opr = opr.split(' ');
    if (opr[0] === 'I') {
      q.push(Number(opr[1]));
      let idx = q.length - 1;
      while (idx > 0 && q[idx - 1] < q[idx]) {
        let tmp = q[idx - 1];
        q[idx - 1] = q[idx];
        q[idx] = tmp;
        idx--;
      }
    } else if (opr[0] === 'D') {
      if (q.length !== 0) {
        if (opr[1] === '1') {
          q.shift();
        } else {
          q.pop();
        }
      }
    }
  }
  if (q.length === 0) {
    return [0, 0];
  } else {
    return [q[0], q[q.length - 1]];
  }
}
solution(['I 7', 'I 5', 'I -5', 'D -1']);
