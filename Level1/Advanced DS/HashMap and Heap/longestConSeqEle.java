import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int a[] = new int[n];
    for(int i = 0 ; i < n ; i++){
        a[i] = scn.nextInt();
    }
    
    HashMap <Integer,Boolean> hm = new HashMap<>();
    for(int num : a){
        hm.put(num,true);
    }
    
    for(Integer key : hm.keySet()){
        if(hm.containsKey(key-1)){
            hm.put(key,false);
        }
    }
    
    int maxSeqSize = 0;
    int maxSeqSP = -1;
    for(int i = 0 ; i < n ; i++){
        int key = a[i];

        if(hm.get(key)){
            int sp = key, size = 1;

            while(hm.containsKey(sp+size)){
                size++;
            }
            
            if(maxSeqSize < size){
                maxSeqSize = size;
                maxSeqSP = sp;
            }   
        }   
    }
    for(int i = maxSeqSP ; i < maxSeqSP + maxSeqSize ; i++){
        System.out.println(i);
    }  
 }
}