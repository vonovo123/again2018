//지정한 type과 순서/타입 모두 맞아야함
//길이가 있음
let x : [string, number];
x = ["hello", 39];
//'"world"' 형식은 'undefined' 형식에 할당할 수 없습니다.
//튜플 2자리 이후는 모두 undefined로 할당
//x[3] = "world";
//길이가 '2'인 튜플 형식 '[string, number]'의 인덱스 '2'에 요소가 없습니다.
//x[2];

const person:[string,number] = ["Mark", 39];
//튜플이면 구조분해할당시 자동으로 할당
//const first: string
//const second: number
const [first, second] = person;
//길이가 '2'인 튜플 형식 '[string, number]'의 인덱스 '2'에 요소가 없습니다.ts(2493)\
//const [first, second,third] = person;

//const test:number = undefined;
