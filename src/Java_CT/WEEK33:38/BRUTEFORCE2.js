function solution(brown, yellow) {
    var answer = [];
    let x = yellow, y = 1;
    while(x >= y){
        if(x * 2 + y * 2 + 4 == brown){
            return [x + 2, y + 2];
        };
        y ++;
        x = yellow / y;
    }
    
    return answer;
    
    //24 1
    //12 2
    //8  3
    //6. 4
}