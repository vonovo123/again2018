## 대표적인 데이터 구조6: 해쉬 테이블 (Hash Table)

### 1. 해쉬 테이블
  - 키(Key)에 데이터(Value)를 매핑할 수 있는 데이터 구조
  - 해쉬 함수를 통해, 배열에 키에 대한 데이터를 저장할 수 있는 주소(인덱스 번호)를 계산
  - Key를 통해 바로 데이터가 저장되어 있는 주소를 알 수 있으므로, 저장 및 탐색 속도가 획기적으로 빨라짐
  - 미리 해쉬 함수가 생성할 수 있는 주소(인덱스 번호)에 대한 공간을 배열로 할당한 후, 키에 따른 데이터 저장 및 탐색 지원


### 2. 알아둘 용어
* 해쉬 함수(Hash Function): 임의의 데이터를 고정된 길이의 값으로 리턴해주는 함수
  - 해쉬 (Hash), 해쉬 값(Hash Value), 또는 해쉬 주소(Hash Address): 해싱 함수를 통해 리턴된 고정된 길이의 값
* 해쉬 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
  - 슬롯(Slot): 해쉬 테이블에서 한 개의 데이터를 저장할 수 있는 공간


### 3. 간단한 해쉬 예
```java
```

```javascript
```

### 4. 자료 구조 해쉬 테이블의 장단점과 주요 용도
- 장점
  - 데이터 저장/읽기 속도가 빠르다. (검색 속도가 빠르다.)
  - 해쉬는 키에 대한 데이터가 있는지(중복) 확인이 쉬움
- 단점 
  - 일반적으로 저장공간이 좀더 많이 필요하다.
  - **여러 키에 해당하는 주소가 동일할 경우 충돌을 해결하기 위한 별도 자료구조가 필요함**
- 주요 용도
  - 검색이 많이 필요한 경우
  - 저장, 삭제, 읽기가 빈번한 경우
  - 캐쉬 구현시 (중복 확인이 쉽기 때문)


### 5. 충돌(Collision) 해결 알고리즘 (좋은 해쉬 함수 사용하기)
> 해쉬 테이블의 가장 큰 문제는 충돌(Collision)의 경우입니다. 이 문제를 충돌(Collision) 또는 해쉬 충돌(Hash Collision)이라고 부릅니다.

### 5.1. Chaining 기법
- **개방 해슁 또는 Open Hashing 기법** 중 하나: 해쉬 테이블 저장공간 외의 공간을 활용하는 기법
- 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, **링크드 리스트**로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법

```java
class MyHash {
  public Slot[] hashTable;

  public MyHash (Integer size){
    this.hashTable = new Slot[size];
  }
  //Divison 기법
  public int hashFunction(String key){
    return (int)key.charAt(0) % this.hashTable.length;
  }

  public boolean saveData(String key, String value){
    Integer address = this.hashFunction(key);
    //슬롯이 있으면 해당하는 슬롯 링크 안에 key가 존재하는지 확인한다.
    //key가 있으면 update
    //key가 없으면 추가
    if(this.hashTable[address] != null){
      Slot findSlot = this.hashTable[address];
      Slot prevSlot = this.hashTable[address];
      while(findSlot != null){
        if(findSlot.key == key){
          findSlot.value = value;
          return true;
        }
        prevSlot = findSlot;
        findSlot = findSlot.next; 
      }
      findSlot = new Slot(key, value);
      prevSlot.next = findSlot;
    } else {
      this.hashTable[address] = new Slot(key,value);
    }
    return true;
  }

  public String getData(String key){
    Integer address = this.hashFunction(key);
    if(this.hashTable[address] != null) {
      Slot findSlot = this.hashTable[address];
      while(findSlot != null){
        if(findSlot.key == key){
          return findSlot.value;
        }
        findSlot = findSlot.next;
      }
      return null;
    } else {
      return null;
    }
    
  }

  public class Slot {
    String key;
    String value;
    Slot next;
    Slot(String key, String value){
      this.key = key;
      this.value = value;
    }
  }
}

```

```javascript
class MyHashTableChaing {
  hashTable:ChaningSlot[]; 
  size:number;
  constructor(size:number){
    this.hashTable = [];
    this.size = size;
  }
  hashFunc(key:string):number{ 
    return Number(key.charCodeAt(0)) % this.size;
  }

  saveData(key:string, value:string):boolean{
    let address = this.hashFunc(key);
    if(!this.hashTable[address]){
      this.hashTable[address] = new ChaningSlot(key, value);
      return true;
    } else {
      let findSlot : ChaningSlot | null = this.hashTable[address];
      let prevSlot = this.hashTable[address];
      while(findSlot !== null){
        if(findSlot.key === key){
          findSlot.value = value;
          return true;
        } else {
          prevSlot = findSlot;
          findSlot = findSlot.next;
        }
      }
      prevSlot.next = new ChaningSlot(key,value);
    }
    return true;
  }

  getData(key:string):string|null{
    const address = this.hashFunc(key);
    if(!this.hashTable[address]){
      return null;
    } else {
      let findSlot: ChaningSlot| null = this.hashTable[address];
      while(findSlot != null){
        if(findSlot.key === key){
          return findSlot.value
        }
        findSlot = findSlot.next;
      }
      return null;
    }
    return null;
  }
}

class ChaningSlot {
  key:string;
  value:string;
  next:ChaningSlot| null;
  constructor(key:string, value:string){
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

```

### 5.2. Linear Probing 기법
- **폐쇄 해슁 또는 Close Hashing 기법** 중 하나: 해쉬 테이블 저장공간 안에서 충돌 문제를 해결하는 기법
- 충돌이 일어나면, 해당 hash address의 다음 address부터 맨 처음 나오는 빈공간에 저장하는 기법
  - 저장공간 활용도를 높이기 위한 기법

```java
    class MyHashLinerProbing {
      public Slot[] hashTable;

      public MyHashLinerProbing (Integer size){
        this.hashTable = new Slot[size];
      }
      //Divison 기법
      public int hashFunction(String key){
        return (int)key.charAt(0) % this.hashTable.length;
      }

      public boolean saveData(String key, String value){
        int address = this.hashFunction(key);
        //해당 주소의 칼럼이 비어있으면
        if(this.hashTable[address] == null){
          //추가
          this.hashTable[address] = new Slot(key,value);
        } else {
          //기존에 존재하는 키값이면
          if(this.hashTable[address].key == key){
            //업데이트
            this.hashTable[address].value = value;
            return true;
          //다른 키값이 들어있으면
          } else {
            int curAddress = address + 1;
            //현재 주소 밑으로 순회하면서 값은 key를 가진 칼럼이 있는지 확인
            while(this.hashTable[curAddress] != null){
              //같은 키값을 가진 칼럼이 있으면 값 업데이트
              if(this.hashTable[curAddress].key == key){
                this.hashTable[curAddress].value = value;
                return true;
              } else {
                curAddress++;
                if(curAddress >= this.hashTable.length){
                  return false;
                }
              }
            }
            //인덱스를 초과하지않고 같은 키값을 가진 칼럼이 없으면  
            this.hashTable[curAddress] = new Slot(key,value);
            return true;
          }
        }
        return false;
      }

      public String getData(String key){
        int address = this.hashFunction(key);
        if(this.hashTable[address] == null){
          return null;
        } else {
          if(this.hashTable[address].key == key){
            return this.hashTable[address].value;
          } else {
            int curAddress = address;
            while(this.hashTable[curAddress] != null){
              if(this.hashTable[curAddress].key == key){
                return this.hashTable[curAddress].value;
              } else {
                curAddress ++;
                if(curAddress >= this.hashTable.length){
                  return null;
                }
              }
            }
            return null;
          }
        }
      }

      public class Slot {
        String key;
        String value;
        Slot(String key, String value){
          this.key = key;
          this.value = value;
        }
      }
    }
```

```javascript
class MyHashTableLinerProbing {
  hashTable:ProbingSlot[];
  size:number;
  constructor(size:number){
    this.size = size;
    this.hashTable = [];
  }
  hashFunc(key:string){
    return Number(key.charCodeAt(0)) % this.size;
  }

  saveData(key:string,value:string):boolean{
    let address = this.hashFunc(key);
    if(this.hashTable[address] != null){
      if(this.hashTable[address].key === key){
        this.hashTable[address].value = value;
        return true;
      } else {
        let curAddress = address + 1;
        while(this.hashTable[curAddress] != null){
          if(this.hashTable[curAddress].key === key){
            this.hashTable[curAddress].value = value;
            return true;
          } else {
            curAddress ++;
            if(curAddress >= this.size){
              curAddress = 0;
            } else if(curAddress == address){
              return false;
            }
          }
        }
        this.hashTable[curAddress] = new ProbingSlot(key,value);
        return true;
      }
    } else {
      this.hashTable[address] = new ProbingSlot(key, value);
      return true;
    }
  }

  getData(key:string):string|null{
    let address = this.hashFunc(key);
    if(this.hashTable[address] !== null){
      if(this.hashTable[address].key === key){
        return this.hashTable[address].value;
      } else {
        let curAddress = address;
        while(this.hashTable[curAddress] != null){
          if(this.hashTable[curAddress].key === key){
            return this.hashTable[curAddress].value;
          } else {
            curAddress ++;
            if(curAddress >= this.size){
              curAddress = 0;
            } else if(curAddress === address){
              return null;
            }
          }
        }
        return null;
      }
    } else {
      return null;
    }
  }
}

class ProbingSlot {
  key:string;
  value:string;
  constructor(key:string, value:string){
    this.key = key;
    this.value = value;
  }
}
```