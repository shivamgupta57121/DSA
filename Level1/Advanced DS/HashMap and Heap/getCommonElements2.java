import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    HashMap <Integer,Integer> hm = new HashMap<>();
    int n1 = scn.nextInt();
    int a1[] = new int[n1];
    for(int i = 0 ; i < n1 ; i++){
        a1[i] = scn.nextInt();
        if(hm.containsKey(a1[i])){
            hm.put(a1[i],hm.get(a1[i])+1);
        } else{
            hm.put(a1[i],1);
        }
    }
    int n2 = scn.nextInt();
    int a2[] = new int[n2];
    for(int i = 0 ; i < n2 ; i++){
        a2[i] = scn.nextInt();
    }
    for(int i = 0 ; i < n2 ; i++){
        if(hm.containsKey(a2[i]) && hm.get(a2[i]) > 0){
            System.out.println(a2[i]);
            hm.put(a2[i],hm.get(a2[i])-1);
        }
    }   
 }
}
