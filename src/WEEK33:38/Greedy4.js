function getParent(parent, x) {
  //4
  if (parent[x] === x) {
    return x;
  }
  return getParent(parent, parent[x]);
}

function unionParent(parent, a, b) {
  a = getParent(parent, a); //0
  b = getParent(parent, b); //4 1
  //console.log(`a: ${a} b : ${b}`);
  if (a < b) {
    for (let i = 0; i < parent.length; i++) {
      if (parent[i] === b) {
        parent[i] = a;
      }
    }
  } else {
    for (let i = 0; i < parent.length; i++) {
      if (parent[i] === a) {
        parent[i] = b;
      }
    }
  }
}

function solution(n, costs) {
  let parents = [];
  costs.sort((a, b) => {
    return a[2] - b[2];
  });
  costs.forEach(v => {
    if (parents[v[0]] === undefined) {
      parents[v[0]] = v[0];
    }
    if (parents[v[1]] === undefined) {
      parents[v[1]] = v[1];
    }
  });
  let price = 0;
  for (let i = 0; i < costs.length; i++) {
    let a = costs[i][0];
    let b = costs[i][1];
    if (parents[a] !== parents[b]) {
      price += costs[i][2];
      unionParent(parents, a, b);
    }
    let flag = true;
    for (let i = 0; i < parents.length - 1; i++) {
      if (parents[i] !== parents[i + 1]) {
        flag = false;
        break;
      }
    }
    if (flag) {
      break;
    }
  }


  return price;
}