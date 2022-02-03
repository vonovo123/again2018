class SORT {
  array;
  swap(a, b){
    const tmp = this.array[b];
    this.array[b] = this.array[a];
    this.array[a] = tmp;
  }
  innerSort(arr, start, end){
    if(start >= end){
      return;
    }
    //기준점
    let pivot = start;
    //좌측 시작점
    let left = start;

    //우측 시작점
    let right  = end;
    //console.log(`left ${left} right ${right} pivot ${pivot}`);
    let turn = 0;
    //작은 값의 인덱스가 큰값의 인덱스보다 크면
    while(left < right){
      // turn ++;
      // if(turn === 5){
      //   break;
      // }
          // 큰값의 인덱스
      for( let i = left; i < arr.length; i ++){
        //좌측부터 순회해서 기준점보다 큰 값 위치 찾기
        if(arr[pivot] <= arr[i]){
          left = i;
          break;
        }
      }
      //작은값의 인덱스
      for( let i = right; i >= 0; i --){
        //우측부터 순회해서  기준점 보다 작은 값 위치 찾기
        if(arr[pivot] >= arr[i]){
          right = i;
          break;
        }
      }
    console.log(`${left} ${right}`)
      if(left > right){
        this.swap(right, pivot);
      } else {
        this.swap(left, right);
      }
    }
    
    //피벗 오른쪽엔 피벗보다 큰값 왼쪽엔 피벗보다 작은값으로 정렬됨
    console.log(arr)
    this.innerSort(arr, start, pivot);
    this.innerSort(arr, pivot + 1, end);
    
  }
  quickSort(arr, compare){
    const cArray = arr.map(v => v);
    this.array = cArray;
    let pivot = cArray[0];
    this.innerSort(cArray, 0, cArray.length - 1)
    console.log(cArray);
  }


  insertionSort(arr, compare){
    const cArray = arr.map(v => v);
    this.array = cArray;
    let j = 0;
    let temp = 0;
    for(let i = 0; i < cArray.length; i ++){
      j = i;
      if(compare === -1){
        while(j >= 0 && cArray[j] < cArray[j + 1]){
          this.swap(j, j + 1)
          j --;
        }
      } else {
        while(j >= 0 && cArray[j] > cArray[j + 1]){
          this.swap(j, j + 1)
          j --;
        }
      }
    }
    return cArray;
  }
  bubleSort(arr, compare){
    const cArray = arr.map(v => v);
    this.array = cArray;
    for(let i = 0; i < cArray.length; i ++){
      for(let j = 0; j < cArray.length - 1 - i; j ++){
        if(compare === -1){ //역순
          if(cArray[j] < cArray[j + 1]){
            this.swap(j, j + 1);
          }
        } else {
          if(cArray[j] > cArray[j + 1]){
            this.swap(j, j + 1);
          }
        }
        
      }
    }
    return this.array;
  }
  selectionSort(arr, compare){
    const cArray = arr.map(v => v); 
    this.array = cArray;
    this.index = 0;
    
    if(compare === -1){// 내림차순
      for( let i = 0; i < cArray.length - 1; i ++){
        let max = 0;
        for( let j = i; j < cArray.length; j ++){
          if(max < cArray[j]){
            max = cArray[j];
            this.idx = j;
          }
        }
        this.swap(i, this.idx);
      }
    } else { // 오름차순
      for( let i = 0; i < cArray.length - 1; i ++){
        let min = Number.MAX_SAFE_INTEGER;
        for( let j = i; j < cArray.length; j ++){
          if(min > cArray[j]){
            min = cArray[j];
            this.idx = j;
          }
        }
        this.swap(i, this.idx);
      }
    }
    return this.array;
  }
}

const sort = new SORT();
export default sort;