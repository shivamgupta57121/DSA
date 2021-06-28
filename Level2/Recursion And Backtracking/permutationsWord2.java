import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence) {
    // cc - current count
    // str - actual string
    // spots - actual placement
    // lastOccurence - map of last occurence of character, if unused -1

    if(cc == str.length()){
        for(Character ch : spots){
            System.out.print(ch);
        }
        System.out.println();
        return ;
    }

    char ch = str.charAt(cc);
    int lo = lastOccurence.get(ch);

    for(int i = lo + 1 ; i < str.length() ; i++){
        if(spots[i] == null){
            spots[i] = ch;
            lastOccurence.put(ch, i);
            generateWords(cc+1, str, spots, lastOccurence);
            lastOccurence.put(ch, lo);
            spots[i] = null;
        }
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}