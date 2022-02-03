"use strict";
// tsc --init -- ts compiler 설정파일
// tsc -w watch 모드 - 파일수정시마다 컴파일
//ls -al node_modules/.bin 하위디렉토리 검색
//로컬설치시 node_modules/.bin/tsc
// 단축어로 실행 npx tsc
// 설정파일 설치 npx tsc --init
// Type Casing : 핵심 primitive types는 모두 소문자
let isDone = false;
isDone = true;
console.log(typeof isDone);
// boolean'은(는) 기본 개체이지만 'Boolean'은(는) 래퍼 개체입니다. 가능한 경우 'boolean'을(를) 사용하세요.
//let isNotOk: boolean = new Boolean(true);
