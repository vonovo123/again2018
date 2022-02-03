function returnAny(message:any): any {
    console.log(message)
}

const any1 = returnAny("리턴은 아무거나");

any1.toString();
//any 이후 안정성을 잃는 경우
let looselyTyped : any = {};
const b = looselyTyped.a.b.c.d;


function leakingAny(obj: any){
  const a :number = obj.num; //any; -> number
  const b = a + 1;// //any
  return b;
}

const c = leakingAny({num : 0});//any -> number
//c.indexOf("0"); 