"use strict";
//primitive 값을 담아서 사용하빈다.
//고유하고 수정불가능한 값으로 만들어줍니다.
//접근을 제어할때 주로 사용
console.log(Symbol('foo') === Symbol('foo'));
const sym = Symbol();
const obj = {
    [sym]: "value"
};
console.log(obj[sym]);
// '{ [sym]: string; }' 형식에 'sym' 속성이 없습니다
//console.log(obj['sym'])
