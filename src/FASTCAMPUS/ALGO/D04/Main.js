"use strict";
class NodeMgnt {
    constructor() {
        this.head = null;
    }
    insert(value) {
        if (!this.head) {
            this.head = new myNode(value);
        }
        else {
            let curNode = this.head;
            while (curNode) {
                if (curNode.value > value) {
                    if (!curNode.left) {
                        curNode.left = new myNode(value);
                        break;
                    }
                    else {
                        curNode = curNode.left;
                    }
                }
                else {
                    if (!curNode.right) {
                        curNode.right = new myNode(value);
                        break;
                    }
                    else {
                        curNode = curNode.right;
                    }
                }
            }
        }
        return true;
    }
    ;
    search(value) {
        if (!this.head) {
            return null;
        }
        else {
            let curNode = this.head;
            while (curNode) {
                if (curNode.value === value) {
                    return curNode;
                }
                else {
                    if (value < curNode.value) {
                        curNode = curNode.left;
                    }
                    else {
                        curNode = curNode.right;
                    }
                }
            }
        }
        return null;
    }
    delete(value) {
        if (!this.head) {
            return false;
        }
        else {
            if (this.head.value === value && !this.head.left && !this.head.right) {
                this.head = null;
                return true;
            }
            else {
                let curNode = this.head;
                let curParentNode = this.head;
                while (curNode) {
                    if (curNode.value === value) {
                        break;
                    }
                    else {
                        curParentNode = curNode;
                        if (value < curNode.value) {
                            curNode = curNode.left;
                        }
                        else {
                            curNode = curNode.right;
                        }
                    }
                }
                if (curNode) {
                    //leap 노드일때
                    if (!curNode.left && !curNode.right) {
                        if (curNode.value < curParentNode.value) {
                            curParentNode.left = null;
                        }
                        else {
                            curParentNode.right = null;
                        }
                    }
                    else if (curNode.left && !curNode.right) {
                        if (curNode.value < curParentNode.value) {
                            curParentNode.left = curNode.left;
                        }
                        else {
                            curParentNode.right = curNode.left;
                        }
                    }
                    else if (!curNode.left && curNode.right) {
                        if (curNode.value < curParentNode.value) {
                            curParentNode.left = curNode.right;
                        }
                        else {
                            curParentNode.right = curNode.right;
                        }
                    }
                    else {
                        let changeNode = curNode.right;
                        let changeParentNode = curNode.right;
                        while (changeNode && changeNode.left != null) {
                            changeParentNode = changeNode;
                            changeNode = changeNode.left;
                        }
                        //changeNode의 하위노드가 있으면
                        if (changeNode && changeParentNode && changeNode.right) {
                            //changeNode는 항상changeParenNode의 왼쪽노드이다.
                            changeParentNode.left = changeNode.right;
                            //changeNode의 하위노드가 없으면   
                        }
                        else if (changeNode && changeParentNode && !changeNode.right) {
                            changeParentNode.left = null;
                        }
                        else {
                            return false;
                        }
                        if (curNode.value < curParentNode.value) {
                            curParentNode.left = changeNode;
                        }
                        else {
                            curParentNode.right = changeNode;
                        }
                        changeNode.left = curNode.left;
                        changeNode.right = curNode.right;
                    }
                    curNode = null;
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
}
class myNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
const mgnt = new NodeMgnt();
mgnt.insert(10);
mgnt.insert(15);
mgnt.insert(13);
mgnt.insert(11);
mgnt.insert(14);
mgnt.insert(18);
mgnt.insert(16);
mgnt.insert(19);
mgnt.insert(17);
mgnt.insert(7);
mgnt.insert(8);
mgnt.insert(6);
console.log(mgnt.delete(15));
console.log("HEAD: " + mgnt.head.value);
console.log("HEAD LEFT: " + mgnt.head.left.value);
console.log("HEAD LEFT LEFT: " + mgnt.head.left.left.value);
console.log("HEAD LEFT RIGHT: " + mgnt.head.left.right.value);
console.log("HEAD RIGHT: " + mgnt.head.right.value);
console.log("HEAD RIGHT LEFT: " + mgnt.head.right.left.value);
console.log("HEAD RIGHT RIGHT: " + mgnt.head.right.right.value);
console.log("HEAD RIGHT RIGHT LEFT: " + mgnt.head.right.right.left.value);
console.log("HEAD RIGHT RIGHT RIGHT: " + mgnt.head.right.right.right.value);
//   5
//4    6
//3
//2
//1
