package FASTCAMPUS.ALGO.D03;

class Main {
  public static void main(String[] args) {
    MyHash mainObject = new MyHash(20);
    mainObject.saveData("DaveLee", "01022223333");
    mainObject.saveData("fun-coding", "01033334444");
    mainObject.saveData("David", "01044445555");
    mainObject.saveData("Dave", "01055556666");
    System.out.println(mainObject.getData("DaveLee"));
    System.out.println(mainObject.getData("David"));
    System.out.println(mainObject.getData("Dave"));
    
  }
}
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