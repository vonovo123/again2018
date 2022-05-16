
N 개의 카드를 M개 만큼 나열하는법
중복 | 순서 | 시간 복잡도 | 공간 복잡도| case |
|---|----|-----------|---------|------|
| YES | YES| O(N^M)  |  O(M)   | 같은수를 여러번 골라도 된다. 순서가 다르면 다른 케이스
| NO | YES | O(N!/(N-M)!)| O(M)| 같은수를 반복해선 안된다. 순서가 다르면 다른 케이스
| YES | NO| under O(N^M) | O(M)| 같은수를 반복해도 된다 / 순서가 달라도 같은 케이스
| NO | NO | O(N!/M!(N-M)!)| O(M)| 같은수를 반복해선 안된다 / 순서가 달라도 같은 케이스

N과M 문제로 보는 완전탐색 케이스

중복 O 순서 O => 시간 복잡도 O(N^M)
```javascript
const fs = require('fs');
class Scanner {
  read
  stringToken
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().split('\n');
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


// 1 부터 N 까지의 자연수 중 M 개를 고른 수열
// 같은 수를  여러번 골라도 됨 : 중복가능
// 순서가 다르면 다른 수열 : 순서 YES 
// 시간 복잡도 N^M
// Max N : 7 | Max M : 7
// worst case 7^7
// 시간 제한 1초 
// brute force
let N;
let M;
let selected = [0,];
let stringBuilder = "";
const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  M = scanner.nextNumber();
}

const rec_func = function( k ){
  if(k === M + 1){
    for(let i = 1; i < k; i ++){
      stringBuilder += (selected[i] + " ");
    }
    stringBuilder += `\n`;
  } else {
    for(let i = 1; i <= N; i ++){
      selected.push(i);
      rec_func(k + 1);
      selected.pop();
    }
  }
}
input();

rec_func(1);
console.log(stringBuilder)

```

중복 X 순서 O => 시간 복잡도 O(N!/(N-M)!)
```javascript
const fs = require('fs');
class Scanner {
  read
  stringToken
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().split('\n');
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

let N, M;
const selected = [0,];
let stringBuilder = "";
//1에서 N 까지 자연수 중 M개를 고른 수열 
//중복불가 / 순서가 다르면 다른 케이스 
//시간복잡도 o(N!/(N-M)!)
const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  M = scanner.nextNumber();
}

const rec_func = function(k){
  if( k === M + 1){
    for(let i = 1; i < k; i ++){
      stringBuilder += (selected[i] + " ");
    }
    stringBuilder += `\n`;
  } else {
    for( let i = 1; i <= N; i ++ ){
      if(k > 1){
        if(selected.indexOf(i) !== -1){
          continue;
        }
      } 
      selected.push(i);
      rec_func(k + 1);
      selected.pop();
    }
  }
}
input();
rec_func(1);
console.log(stringBuilder);
```


중복 O 순서 X => 시간 복잡도 under O(N^M)
```javascript
const fs = require('fs');
class Scanner {
  read
  stringToken
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().split('\n');
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

let N, M;
const selected = [0,];
let stringBuilder = "";
//1에서 N 까지 자연수 중 M개를 고른 수열 
//중복가능 / 비내림차순이기 때문에 순서가 달라도 하나의 케이스임
//시간복잡도 N^M 보다 작음
const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  M = scanner.nextNumber();
}

const rec_func = function(k){
  if( k === M + 1){
    for(let i = 1; i < k; i ++){
      stringBuilder += (selected[i] + " ");
    }
    stringBuilder += `\n`;
  } else {
    for( let i = 1; i <= N; i ++ ){
      if(k > 1){
        if(selected[k - 1] > i){
          continue;
        }
      } 
      selected.push(i);
      rec_func(k + 1);
      selected.pop();
    }
  }
}
input();
rec_func(1);
console.log(stringBuilder);
```

중복 X 순서 X => 시간 복잡도 O(N!/M!(N-M)!
``` javascript
const fs = require('fs');
class Scanner {
  read
  stringToken
  constructor(fileName){
    this.read = fs.readFileSync(fileName).toString().split('\n');
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

let N, M;
const selected = [0,];
let stringBuilder = "";
//1에서 N 까지 자연수 중 M개를 고른 수열 
//중복불가 / 오름차순이기 때문에 순서가 달라도 하나의 케이스임
//시간복잡도 O(N!/M!(N-M)!)
const input = function(){
  const scanner = new Scanner('./stdin.txt');
  N = scanner.nextNumber();
  M = scanner.nextNumber();
}

const rec_func = function(k){
  if( k === M + 1){
    for(let i = 1; i < k; i ++){
      stringBuilder += (selected[i] + " ");
    }
    stringBuilder += `\n`;
  } else {
    for( let i = 1; i <= N; i ++ ){
      if(k > 1){
        if(selected[k - 1] >= i){
          continue;
        }
      } 
      selected.push(i);
      rec_func(k + 1);
      selected.pop();
    }
  }
}
input();
rec_func(1);
console.log(stringBuilder);
```


완전탐색
- 방문지점 체크 안하고 모두 방문하는 경우 N^M - 중복허용, 순서 다르면 다름
- 방문지점 체크해서 체크안한지점만 방문하는경우 - 중복x, 순서 다르면 다름 - 방문지점 체크를 통해 탐색수 낮아짐 
- 인덱스가 방문지점보다 같거나 큰 경우만 방문하는경우
- 인덱스