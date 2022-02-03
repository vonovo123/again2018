//병합정렬
//분할 정복 && 재귀
//요소가 하나가 될때 까지 나눈 후 오름 차순으로 합친다.
//둘 이상일대부터는 두 배열을 비교해서 크기순으로 합친다.
class MergeSort {
  merge(front:number[], back:number[]){
    let merged = [];
    while(front.length !== 0 && back.length !== 0){
      if(front[0] < back[0]){
        merged.push(front.shift());
      } else {
        merged.push(back.shift());
      }
    }
    while(front.length !== 0){
      merged.push(front.shift());
    }
    while(back.length !== 0){
      merged.push(back.shift());
    }
    return merged;
  }
  sort(arr:number[]):any{
    if(arr.length === 1){
      return arr;
    }
    let mid = Math.floor(arr.length / 2)
    return this.merge(this.sort(arr.slice(0, mid)),this.sort(arr.slice(mid)));
  }; 
}
//퀵솔트 - 배열 분해 
class QuickSortArr {
  // arr:number[];
  // constructor(arr:number[]) {
  //   this.arr = arr;
  // }
  sort(arr:number[]):number[]{
    if(arr.length <= 1){
      return arr;
    }
    let pivot = 0;
    let front:number[] = [];
    let back: number[] = [];
    for(let i = 1; i < arr.length; i ++){
      if(arr[i] < arr[pivot]){
        front.push(arr[i]);
      } else {
        back.push(arr[i]);
      }
    }
    console.log(`front : ${front}`)
    console.log(`pivot : ${pivot}`)
    console.log(`back : ${back}`)
    return [...this.sort(front),arr[pivot],...this.sort(back)];
  }
}
//퀵솔트 - 투포인트
class QuickSortTwoPoint{
 sort(arr:number[], start:number, end:number){
  if(end - start <= 1){
    return arr;
  }
  let pivot = start;
  let left = pivot + 1;
  let right = end;
  while(left <= right){
    while(left <= end && arr[left] <= arr[pivot]){
      left ++;
    }
    while(start < right && arr[pivot] <= arr[right]){
      right --;
    }
    if(left <= right){
      arr = this.swap(arr,left, right);
    } else {
      arr = this.swap(arr,pivot, right);
    }
  }
  this.sort(arr, start, right - 1);
  this.sort(arr, right + 1, end);
  return arr;
 }
 swap(arr:number[], a:number, b:number){
   let tmp:number = arr[a];
   arr[a] = arr[b];
   arr[b] = tmp;
   return arr;
 }
}
const mergeSort = new MergeSort();
const quickSortArr = new QuickSortArr();
const quickSortTwoPoint = new QuickSortTwoPoint();

let randomArr:number[] = [];
for(let i = 0; i < 10; i ++){
  randomArr.push(Math.floor(Math.random() * 100));
}
console.log(randomArr);
console.log(quickSortTwoPoint.sort(randomArr, 0, randomArr.length - 1));

