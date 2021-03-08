import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String exp = scn.nextLine();
        System.out.println(isDuplicate(exp));
    }
    
    public static boolean isDuplicate(String exp){
        Stack<Character> st = new Stack<>();
        
        for(int idx = 0 ; idx < exp.length() ; idx++){
            char ch = exp.charAt(idx);
            if( ch == ')' ){
                
                if( st.peek() == '(' ) {
                    return true; // duplicay detected
                }
                // valid bracket
                while( st.peek() != '(' ){
                    st.pop();
                }
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        return false;
    }

}