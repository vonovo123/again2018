function solution(type, id, listener) {
 
    return {
        type,
        id,
        onEvent(event) {
            listener(event);
        },
        addChild(node) {
            if (this.childNodes === undefined) {
                this.childNodes = [];
            } 
            //추가조건 1
            if (node === this.parentNode) {
                 throw new Error(`${node.id} 는 ${this.id}의 부모임`);
            }
            //추가조건 2
            if (node.parentNode === undefined) {
                node.parentNode = this;
                this.childNodes.push(node);
            } else {
                throw new Error(`${node.id} 는 이미 ${node.parentNode.id}을 부모로 가지고있음`);
            }
        },
        removeChild(node) {
            
         }
    }

}
try {
    const first = solution("div", "first", (e) => console.log(e));
    const button = solution("button", "button", (e) => console.log(e));
    first.addChild(button);
    button.addChild(first);
} catch (e) {
    console.log(e);
}






