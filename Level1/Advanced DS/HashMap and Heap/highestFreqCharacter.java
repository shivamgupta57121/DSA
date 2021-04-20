import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String inp = scn.next();
        
        HashMap <Character, Integer> hm = new HashMap<>();
        
        for(int idx = 0 ; idx < inp.length(); idx++){
            char ch = inp.charAt(idx);
            if(hm.containsKey(ch)){
                // update
                hm.put(ch, hm.get(ch)+1);
            } else {
                // insert
                hm.put(ch, 1);
            }
        }
        
        char maxFreqCh = ' ';
        int maxFreq = 0;
        
        for(char key : hm.keySet()){
            int freq = hm.get(key);
            
            if(freq > maxFreq){
                maxFreq = hm.get(key);
                maxFreqCh = key;
            }
        }
        
        System.out.println(maxFreqCh);
    }

}