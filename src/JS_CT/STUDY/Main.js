import sort from './SORT.js';

//const data = [7, 6, 5, 4, 3 ,2, 1];
//const data = [1,2,3,4,5,6,7];
//기준값보다 값이 작은 최초 위치
//기준값보다 값이 큰 최초 위치
const data = [10, 9, 8, 7, 6,5,4,3, 2,1];
//3 8
//8 7
console.log(JSON.stringify(data));
console.log(JSON.stringify(sort.quickSort(data, 0, data.length - 1)));

