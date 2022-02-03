//never를 리턴 : 아무것도 리턴하지않는다.
function error (message : string): never{
  throw new Error(message)
  //어떤것도 리턴하지 않음
}
//function fail(): never 로 추론됨
function fail() {
  return error('failed');
}

function infiniteLoop():never {
  while(true){};
  //return을 할수없음 never
}
//never의 활용
// let a : string = "hello";

// if(typeof a !== 'string'){
//   //never
//   a;
// }

declare const a : string | number;

if(typeof a !== 'string'){
 //number
  a;
}
//type 생성
type Indexable<T> = T extends string ? T & {[index:string]: any} :never;

type ObjectIndexable = Indexable<{}>;
//'string' 형식은 'never' 형식에 할당할 수 없습니다.ts(2322)
//const b: Indexable<{}> = '';
