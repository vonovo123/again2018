package WEEK41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P42579 {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String [] genres = {"classic", "pop", "classic", "classic", "pop"};
    int [] plays = {500, 600, 150, 800, 2500};
    solution(genres, plays);
  } 
  
  static int[] solution(String [] genres, int [] plays){
      //각 노래의 장르를 담은 벡터
      Vector <String> vGenres = new Vector<String>();
      for(int i = 0; i < genres.length; i ++){
        vGenres.add(genres[i]);
      }
      //장르별로 구분
      Hashtable <Integer, Vector<Integer>> genresT = new Hashtable<Integer, Vector<Integer>>();
     
      for(int i = 0; i < genres.length; i ++){
        if(!genresT.containsKey(vGenres.indexOf(genres[i]))){//첫입력
          genresT.put(vGenres.indexOf(genres[i]), new Vector<Integer>());
        }
          genresT.get(vGenres.indexOf(genres[i])).add(i);
      }
      Iterator <Integer> itr =  genresT.keySet().iterator();
      //총재생수를 구해서 순서대로 정렬을 위해
      Vector<Integer> sum = new Vector<Integer>();
      while(itr.hasNext()){
        int idx = itr.next();
        sum.add(idx);
        genresT.get(idx).sort(new Comparator<Integer>(){
          @Override
          public int compare(Integer a, Integer b) {
            return plays[b] - plays[a];
          }
        });
        System.out.println(idx);
        System.out.println(genresT.get(idx));
      }
      sum.sort(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
          int aSum = 0;
          int bSum = 0;
          Vector<Integer> aV = genresT.get(a);
          Vector<Integer> bV = genresT.get(b);
          for(int i = 0; i < aV.size(); i ++){
            aSum += plays[aV.get(i)];
          }
          for(int i = 0; i < bV.size(); i ++){
            bSum += plays[bV.get(i)];
          }
          return bSum - aSum;
        }
      });
      Vector<Integer> answerV = new Vector<Integer>();
      for(int i = 0; i < sum.size(); i ++){
        int idx = sum.get(i);
        Vector<Integer> v = genresT.get(idx);
        if(v.size() == 1){
          answerV.add(v.get(0));
        } else {
          answerV.add(v.get(0));
          answerV.add(v.get(1));
        }
      }
      int[] answer = new int [answerV.size()];
      for(int i = 0; i < sum.size(); i ++){
        answer[i] = sum.get(i);
      }
      return answer;
    }
}
