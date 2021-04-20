import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    HashMap <Integer,Boolean> hm = new HashMap<>();
    int n1 = scn.nextInt();
    int a1[] = new int[n1];
    for(int i = 0 ; i < n1 ; i++){
        a1[i] = scn.nextInt();
        hm.put(a1[i],true);
    }
    
    int n2 = scn.nextInt();
    int a2[] = new int[n2];
    for(int i = 0 ; i < n2 ; i++){
        a2[i] = scn.nextInt();
    }
    
    // Method - 1
    for(int i = 0 ; i < n2 ; i++){
        if(hm.remove(a2[i]) != null){
            System.out.println(a2[i]);
        }
    }   

    // Method - 2
    // for(int i = 0 ; i < n2 ; i++){
    //     if(hm.containsKey(a2[i])){
    //         System.out.println(a2[i]);
    //         hm.remove(a2[i]);
    //     }
    // }

 }

}
