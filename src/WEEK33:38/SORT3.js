function solution(citations) { 
    //var citations = [3, 0, 6, 7, 1, 3]
    let cCitation = [...citations].sort((a, b) => {return b - a});
    var answer = 0;
    console.log(cCitation)
    let h = cCitation[0];
    for(let i = h; i > 0; i--){
        let count = 0;
        let less = 0;
        
        for(let j = 0; j < cCitation.length; j ++){
            if(cCitation[j] >= i){
                count ++;
            }
            // } else {
            //     less += cCitation[j];
            // }
        }
        // if(count >= i && less <= i){
        if(count >= i){
            return i
        }
        
    }

    
    return 0;
}