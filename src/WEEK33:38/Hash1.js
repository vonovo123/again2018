
makeHash = (key) => {
        let hash = 0;
        for (let i = 0; i < key.length; i++) {
            hash += key.charCodeAt(i);
        }
        console.log(hash % 100)
        return hash % 100;
}

function solution() {
     const participant = ["mislav", "stanko", "mislav", "ana" ] 
     const completion = ["stanko", "ana", "mislav"];
    
    let hash = {};
    for (let i = 0; i < participant.length; i++){
        if (hash[participant[i]] === undefined) { hash[participant[i]] = 1 }
        else {hash[participant[i]]+=1}
        
    }

    for (let i = 0; i < completion.length; i++){
        hash[completion[i]]--;
        
    }
    for (let i = 0; i < completion.length; i++) {
        if (hash[completion[i]] === 1) {
            return completion[i];
        }
    }
    
    
};

solution();