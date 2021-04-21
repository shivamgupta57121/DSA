import java.util.PriorityQueue;
import java.util.Collections;
public class Main{
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Default Min priority
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max priority - Reverse polarity
        
        pq.add(10);
        pq.add(-10);
        pq.add(1);
        pq.add(0);
        pq.add(105);
        pq.add(-100);
        pq.add(26);
        pq.add(45);
        pq.add(-310);
        System.out.println(pq);
        System.out.println(pq.size());
        System.out.println(pq.peek());
        
        while(pq.size() > 0){
            System.out.print(pq.remove() +"  ");
        }
    }
}
