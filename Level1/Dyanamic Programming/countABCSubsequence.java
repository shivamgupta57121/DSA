import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(countABC(str));
    }
    
    public static int countABC(String str){
        int countOfa = 0, countOfab = 0, countOfabc = 0;
        
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
                countOfa = (2 * countOfa) + 1;
            } else if (ch == 'b'){
                countOfab = (2 * countOfab) + countOfa;
            } else if (ch == 'c'){
                countOfabc = (2 * countOfabc) + countOfab;
            }
        }
        return countOfabc;
    }
}