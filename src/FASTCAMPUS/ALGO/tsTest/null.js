"use strict";
//strict : true 안에 strictNullChecks 포함
//'null' 형식은 'string' 형식에 할당할 수 없습니다.
//let MyName : string = null;
//void type에 undefined만 넣을수 있음
let v = undefined;
//union type 
let union = null;
union = "Mark";
let n = null;
console.log(n); // null;
console.log(typeof n); //object;
let u = undefined;
console.log(u); //undefined
console.log(typeof u); //undefined
