class CheckItem {
    static from(...args) {
        return new CheckItem(...args);
    }
    
    constructor(/* ... */checkItemData) {
        /* 
         * 아래 3개 멤버는 필수로 존재해야 합니다.
         *
         *  id: string;
         *  state: CheckState;
         *  children: CheckItem[];
         * ...
         */
        this.id = checkItemData.id;
        this.state = 'unChecked';
        this.children = checkItemData.children.map(child => {
                return new CheckItem(child);
        });

    }
	
    toggle() {
        /* ... */
    }
	
    check() {
        /* ... */
    }
    
	uncheck() {
        /* ... */
    }
}


/**
 * ————————————————————————————
 * 채점을 위한 코드입니다. 
 * 수정하면 정상적인 채점이 되지 않습니다.
 * 수정하지 말아주세요.
 * ————————————————————————————
 */
function solution() {
    let checkItemData = {
        id: '전체 약관',
        children: [
            {
                id: '필수 약관',
                children: [
                    {id : '토스뱅크 대출 설명서', children : []}
                ]
            },
            {
                id: '선택 약관',
                children: [
                    { id: '마케팅 푸시 알림 수신', children: []},
                    {id : '마케팅 SMS 수신', children : []}
                ]
            }
        ]
    }
    console.log(JSON.stringify(CheckItem.from(checkItemData)));
    //return { CheckItem };
}

solution();