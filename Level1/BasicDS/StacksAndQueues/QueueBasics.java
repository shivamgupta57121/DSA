import java.util.*;
public class Main{
    public static void main(String[] args){
        
        Queue<Integer> q = new ArrayDeque<>();
        
        System.out.println(q);
        
        q.add(10);
        System.out.println(q);
        
        q.add(20);
        System.out.println(q);
        
        q.add(30);
        System.out.println(q);
        
        System.out.println(q.size());
        
        System.out.println("Removed : "+q.remove());
        
        System.out.println(q);
        
        System.out.println("Front : "+q.peek());
        
        
    }
}