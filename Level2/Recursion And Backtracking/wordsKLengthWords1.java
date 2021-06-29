import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int ts, int sfsf, Character spots[], int idx, String ustr){
    // ts - total spots
    // sfsf - spots filled so far
    // spots - placement of character
    // idx - character to choose index
    if(idx == ustr.length()){
        if(sfsf == ts){
            for(Character ch : spots){
                System.out.print(ch);
            }
            System.out.println();
        }
        return ;
    }
    for(int i = 0 ; i < spots.length ; i++){
        if(spots[i] == null){
            spots[i] = ustr.charAt(idx);
            generateWords(ts, sfsf+1, spots, idx+1, ustr);
            spots[i] = null;
        }
    }  
    generateWords(ts, sfsf, spots, idx+1, ustr);
  }
 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    
    generateWords(k, 0, new Character[k], 0, ustr);
    
  }

}