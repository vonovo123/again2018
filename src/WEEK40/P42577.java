import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
public class P42577 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] phone_book = br.readLine().split(",");

    // for (String phone : phone_book) {
    //   System.out.println(phone);
    // }
    //119,97674223,1195524421
    //123,456,789
    //12,123,1235,567,88
    solution(phone_book);
    //"TEST".startsWith(prefix)
    //System.out.println("11111111111111111111");
  }
  static void solution(String[] phone_book) {
    HashSet<String> hs = new HashSet<String>(); 
    for (String num : phone_book) {
      hs.add(num);
    }
    Iterator <String> itr = hs.iterator();
    while(itr.hasNext()){
      String num = itr.next();
      for(int i = 0; i < num.length(); i ++){
        if(hs.contains(num.substring(0, i))){
          System.out.println(false);
        }
      }
    }
    System.out.println(true);
  }
}
