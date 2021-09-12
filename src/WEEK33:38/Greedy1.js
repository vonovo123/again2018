function solution(name) {// 1 2 1 4 2
    //name = "ABAAABABAAABB" // 0, 4, 0, 0 0
    let answer = 0;
    //26
    let alpabet = "BCDEFGHIJKLMNOPQRSTUVWXYZ".split('');
    let alpabetB =  [...alpabet];
    alpabetB.reverse();
    alpabet.unshift('A');
    alpabetB.unshift('A');
    let tmpList = [];
    for( let i = 0; i < name.length; i ++){
        let c = name[i]
        answer += Math.min(alpabet.indexOf(c), alpabetB.indexOf(c))
        if(c !== 'A'){
          tmpList.push(i);  
        }
    }
    
    let pivot = 0;
    let count = 0;
    //최초방향
    while(tmpList.length > 0){
        let start = tmpList[0];
        let end = tmpList[tmpList.length - 1];
        let fLength = 0;
        let bLength = 0;
        if(pivot <= start){
            fLength = start - pivot
            bLength = name.length - end + pivot
        } else {
            fLength = name.length - pivot + start
            bLength = pivot - end;
        }
        if(fLength <= bLength){
            pivot = tmpList.shift();
            count +=fLength;
        } else {
            pivot = tmpList.pop();
            count +=bLength;
        }
    }    
    return answer + count;
}