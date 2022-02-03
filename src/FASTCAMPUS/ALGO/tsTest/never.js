"use strict";
//never를 리턴 : 아무것도 리턴하지않는다.
function error(message) {
    throw new Error(message);
    //어떤것도 리턴하지 않음
}
//function fail(): never 로 추론됨
function fail() {
    return error('failed');
}
function infiniteLoop() {
    while (true) { }
    ;
    //return을 할수없음 never
}
if (typeof a !== 'string') {
    //number
    a;
}
//'string' 형식은 'never' 형식에 할당할 수 없습니다.ts(2322)
//const b: Indexable<{}> = '';
