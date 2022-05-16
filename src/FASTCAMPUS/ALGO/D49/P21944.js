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
let N, infos;
let gArr;
let lArr;
let pObj;
let M;
const input = function (){
  N = scanner.nextNumber();
  infos = scanner.read.splice(0, N);
  //분류 -> 난이도 -> 번호
  gArr = Array.from({length : 101}, () => Array.from({length : 101}, () => []));
  lArr = Array.from({length : 101}, () => []);
  pObj = {};
  infos.forEach(info => {
    let [P, L, G] = info.split(" ").map(Number);
    gArr[G][L].push(P);
    lArr[L].push(P);
    pObj[P] = [L, G];
  })
  M = scanner.nextNumber();
}
const findIdx = function(arr, P){
  let l = 0, r = arr.length - 1;
  while(l <= r){
    let mid = Math.floor((l + r) / 2);
    if(P < arr[mid]){
      r = mid - 1;
    } else if(P > arr[mid]){
      l = mid + 1;
    } else {
      return mid;
    }
  }
}
const findMinMax = function(arr, P){
  if(arr.length === 1){
    if(arr[0] < P) return 1
    else return 0;
  }
  let l = 0, r = arr.length - 1;
  let find = 0;
  while(l <= r){
    let mid = Math.floor((l + r) / 2);
    if(P < arr[mid]){
      find = mid;
      r = mid - 1;
    } else {
      l = mid + 1
    }
  }
  return find;
}
const pro = function (){
  for(let i = 1; i <= 100; i ++){
    lArr[i].sort((a,b)=> a - b);
    for(let j = 1; j <= 100; j ++){
      if(gArr[i][j].length > 0)  gArr[i][j].sort((a,b) => a - b);
    }
  }
  infos = scanner.read.splice(0, M);
  let answer = '';
  let P, G, L, x;
  infos.forEach(info => {
  info = info.split(" ");
    switch (info[0]) {
      case 'recommend' : {
        G = Number(info[1]);
        x = Number(info[2]);
        if(x === 1){
          let start = 100;
          while(gArr[G][start].length === 0){
            start --;
          }
          answer += gArr[G][start][gArr[G][start].length - 1] + '\n';
        } else {
          let end = 1;
          while(gArr[G][end].length === 0){
            end ++
          }
          answer += gArr[G][end][0] + '\n';
        }
        break;
      }
      case 'recommend2' : {
        x = Number(info[1]);
        if(x === 1){
          let start = 100;
          while(lArr[start].length === 0){
            start --;
          }
          answer += lArr[start][lArr[start].length - 1] + '\n';
        } else {
          let end = 1;
          while(lArr[end].length === 0){
            end ++;
          }
          answer += lArr[end][0] + '\n';
        }
        break;
      }
      case 'recommend3' : {
        x = Number(info[1]);
        L = Number(info[2]);
        if(x === 1){
          while(lArr[L].length === 0){
            L ++;
            if(L > 100){
              break;
            }
          }
          if(L > 100){
            answer += '-1' + '\n';
          } else {
            answer += lArr[L][0] + '\n';
          }
        } else {
          L -= 1;
          while(lArr[L].length === 0){
            L --;
            if(L < 1){
              break;
            }
          }
          if( L < 1){
            answer += '-1' + '\n';
          } else {
            answer += lArr[L][lArr[L].length - 1] + '\n';
          }
        }
        break;
      }
      case 'add' : {
        P = Number(info[1]);
        L = Number(info[2]);
        G = Number(info[3]);
        let find = findMinMax(gArr[G][L], P);
        gArr[G][L].splice(find,0,P)
        find = findMinMax(lArr[L], P);
        lArr[L].splice(find,0, P);
        pObj[P] = [L, G];
        break;
      }
      case 'solved': {
        P = Number(info[1]);
        let [L, G] = pObj[P];
        let find = findIdx(gArr[G][L], P);
        gArr[G][L].splice(find,1);
        find = findIdx(lArr[L], P);
        lArr[L].splice(find, 1);
        pObj[P] = null;
        break;
      }
    }
  })
  console.log(answer.trim());
}

const solve = function(){
  input();
  pro();
}

solve();