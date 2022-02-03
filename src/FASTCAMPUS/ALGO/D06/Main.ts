function swap(arr:number[], a:number ,b:number):number[]{
  const tmp = arr[a];
  arr[a] = arr[b];
  arr[b] = tmp;
  return arr;
}

class BubbleSort {
  constructor(){

  }
  sort(arr:number[]){
    for(let i = 0; i < arr.length - 1; i ++){
      let flag = false;
      for(let j = 0; j < arr.length - 1 - i; j ++){
        if(arr[j] > arr[j + 1]){
          arr = swap(arr, j, j + 1);
          flag = true
        }
      }
      if(!flag) return arr;
    }

    return arr;
  }
}

class SelectionSort {
  constructor(){

  }
  sort(arr:number[]){
    for(let i = 0; i < arr.length - 1; i ++){
      let lowest = i;
      for(let j = i; j < arr.length; j ++){
        if(arr[lowest] > arr[j]){
          lowest = j;
        }
      }
      arr = swap(arr, lowest, i);
    }
    return arr;
  }
}

class InsertionSort {
  constructor(){

  }
  sort(arr : number[]){
    for(let i = 1; i < arr.length; i ++ ){
      for(let j = i; j > 0; j --){
        if(arr[j] < arr[j - 1]){
          arr = swap(arr, j, j - 1);
        } else {
          break;
        }
      }
    }
    return arr;
  }
}

let arr = new Array();

for(let i = 0 ; i < 10; i ++){
  arr.push(Math.floor(Math.random() * 100));
}
const bubbleSort = new BubbleSort();
const selectionSort = new SelectionSort();
const insertionSort = new InsertionSort();
arr = insertionSort.sort(arr);
console.log(arr);