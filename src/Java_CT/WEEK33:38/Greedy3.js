function solution(people, limit) {
    var answer = 0;
     //people.sort();//오름차순
    people.sort((a,b) => {return b - a});//내림차순
    let idx = 0;
     while( idx < people.length ){
        let left = limit - people[idx];
         idx ++;
        if(left >= people[people.length - 1]){ //작은거
            people.pop();
        }
        answer ++
     }
    return answer;
}