//모르는 변수의 타입을 묘사해야할때가 있음
//any로 쓰게되면 다음 코드들이 any의 영향을 받기때문에 권장하지않음

declare const maybe : unknown;

if(typeof maybe === 'number'){
  const aNumber: number = maybe;
}
//'unknown' 형식은 'number' 형식에 할당할 수 없습니다.ts(2322)

//type guard

if(maybe === true){
  const aBoolean: boolean = maybe;
  //const aString:string = maybe;
}

if(typeof maybe === 'string'){
  const aString:string = maybe ;

  //const aBoolean:boolean = maybe;
}