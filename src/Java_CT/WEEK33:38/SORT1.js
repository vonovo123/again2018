function solution() {
  let numbers = [0, 0, 0, 0];
  let zCount = 0;
  numbers.forEach(v => {
    if (v == 0) zCount++;
  });
  if (zCount == numbers.length) {
    return 0;
  }
  //let numbers = [6, 10, 2];
  numbers.sort((a, b) => {
    let sumA = a.toString() + b.toString();
    let sumB = b.toString() + a.toString();
    console.log(sumA);
    console.log(sumB);

    return sumB - sumA;
  });
  console.log(numbers.join(''));
  return numbers.join('');
  // let cnumbers = [];
  // numbers.forEach(v => {
  //     let tmp = v.toString().split('');
  //     tmp.forEach(v => { cnumbers.push(v) })
  // })
  // console.log(cnumbers.sort((a, b) => { return b - a }).join(""))
  // return console.log(cnumbers.sort((a, b) => { return b - a }).join(""))
}

solution();
