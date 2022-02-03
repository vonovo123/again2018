"use strict";
class MyHashTableChaing {
    constructor(size) {
        this.hashTable = [];
        this.size = size;
    }
    hashFunc(key) {
        return Number(key.charCodeAt(0)) % this.size;
    }
    saveData(key, value) {
        let address = this.hashFunc(key);
        if (!this.hashTable[address]) {
            this.hashTable[address] = new ChaningSlot(key, value);
            return true;
        }
        else {
            let findSlot = this.hashTable[address];
            let prevSlot = this.hashTable[address];
            while (findSlot !== null) {
                if (findSlot.key === key) {
                    findSlot.value = value;
                    return true;
                }
                else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new ChaningSlot(key, value);
        }
        return true;
    }
    getData(key) {
        const address = this.hashFunc(key);
        if (!this.hashTable[address]) {
            return null;
        }
        else {
            let findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key === key) {
                    return findSlot.value;
                }
                findSlot = findSlot.next;
            }
            return null;
        }
        return null;
    }
}
class ChaningSlot {
    constructor(key, value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
class MyHashTableLinerProbing {
    constructor(size) {
        this.size = size;
        this.hashTable = [];
    }
    hashFunc(key) {
        return Number(key.charCodeAt(0)) % this.size;
    }
    saveData(key, value) {
        let address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key === key) {
                this.hashTable[address].value = value;
                return true;
            }
            else {
                let curAddress = address + 1;
                while (this.hashTable[curAddress] != null) {
                    if (this.hashTable[curAddress].key === key) {
                        this.hashTable[curAddress].value = value;
                        return true;
                    }
                    else {
                        curAddress++;
                        if (curAddress >= this.size) {
                            curAddress = 0;
                        }
                        else if (curAddress == address) {
                            return false;
                        }
                    }
                }
                this.hashTable[curAddress] = new ProbingSlot(key, value);
                return true;
            }
        }
        else {
            this.hashTable[address] = new ProbingSlot(key, value);
            return true;
        }
    }
    getData(key) {
        let address = this.hashFunc(key);
        if (this.hashTable[address] !== null) {
            if (this.hashTable[address].key === key) {
                return this.hashTable[address].value;
            }
            else {
                let curAddress = address;
                while (this.hashTable[curAddress] != null) {
                    if (this.hashTable[curAddress].key === key) {
                        return this.hashTable[curAddress].value;
                    }
                    else {
                        curAddress++;
                        if (curAddress >= this.size) {
                            curAddress = 0;
                        }
                        else if (curAddress === address) {
                            return null;
                        }
                    }
                }
                return null;
            }
        }
        else {
            return null;
        }
    }
}
class ProbingSlot {
    constructor(key, value) {
        this.key = key;
        this.value = value;
    }
}
let mainObject = new MyHashTableLinerProbing(26);
// mainObject.saveData("DaveLee", "01022223333");
// mainObject.saveData("fun-coding", "01033334444");
// mainObject.saveData("David", "01044445555");
// mainObject.saveData("Dave", "01055556666");
// console.log(mainObject.getData("DaveLee"));
// console.log(mainObject.getData("David"));
// console.log(mainObject.getData("Dave"));
const text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
[...text].forEach(t => {
    mainObject.saveData(`A${t}`, `${t}`);
});
[...text].forEach(t => {
    console.log(mainObject.getData(`A${t}`));
});
