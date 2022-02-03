package FASTCAMPUS.ALGO.D14;

import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    NQueen nQueen = new NQueen();
    nQueen.search(4, 0, new ArrayList<Integer>());

  }
}

class NQueen{
  boolean check(ArrayList<Integer>candidate,Integer currentColumn){
    int currentRow = candidate.size();
    for(int i = 0; i < currentRow; i ++){
      if(candidate.get(i) == currentColumn || (Math.abs(candidate.get(i) - currentColumn) == (currentRow - i))){
        return false;
      }
    }
    return true;
  }
  void search(Integer N, Integer currentRow, ArrayList<Integer>currentCandidate){
    if(N == currentRow){
      System.out.println(currentCandidate);
      return;
    }
    for( int i = 0; i < N; i ++){
      if(check(currentCandidate, i) == true){
        currentCandidate.add(i);
        this.search(N, currentRow + 1, currentCandidate);
        currentCandidate.remove(currentCandidate.size() - 1);
      }
    }
  }
}