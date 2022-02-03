function f5(a:number):number{
  if( a > 0){
    return a* 38;
  }
  return 0;
}


f5(-5);

type PersonTypeAlias = {
  name : string;
  age :number;
}




function f8(a :PersonTypeAlias):string {
  return `이름은 ${a.name} 이고, 연령대는 ${Math.floor(a.age/10) * 10}대 입니다.`;
}
//'string' 형식의 인수는 'PersonTypeAlias' 형식의 매개 변수에 할당될 수 없습니다.ts(2345)
//f8('Mark');


//--noImplicitAny
//타입스크립트가 추론을 실패한 경우 any가 맞으면 지정해라
//아무것도 안쓰면 에러

//--noImplicitThis
//함수의 첫번째 인자에 this에 대한 타입 지정하지않으면 에러

//--strictNullChecks
// 모든타입에 null 또는 undefined 가 포함되지않게

//--strictFunctionTypes
// 함수타입에 대한 bivariant 매개변수 검사를 비활성화
// 반공변적인것만 가능하도록

//--strictPropertyInitialization
//정의되지 않은 클래스의 속성이 생성자에서 초기화 되었는지 확인

//--strinctBindCallApply
//Functioin 내장함수인 bind/call/apply 사용시 엄격한 체크
//