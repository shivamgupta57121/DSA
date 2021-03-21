import java.io.*;
import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      // write ur code here
      return size;
    }

    void display() {
      // write ur code here
      int len = data.length;
      for(int i = 0 ; i < size ; i++ ){
          System.out.print(data[(front+i)%len]+" ");
      }
      System.out.println();
    }

    void add(int val) {
      // write ur code here
      int len = data.length;
      if( size == len ) {
          int[] temp = new int[2*len];
          for(int i = 0 ; i < len ; i++){
              temp[i] = data[i];
          }
          data = temp;
          add(val);
          return ;
      }
      int idx = ( front + size ) % len;
      data[idx] = val;
      size++;
    }

    int remove() {
      // write ur code here
      int len = data.length;
      if( size == 0 ) {
          System.out.println("Queue underflow");
          return -1;
      }
      int val = data[front];
      data[front] = 0;
      front = (front + 1) % len;
      size--;
      return val;
    }

    int peek() {
       // write ur code here
       int len = data.length;
       if( size == 0 ) {
           System.out.println("Queue underflow");
           return -1;
       }
       int val = data[front];
       return val;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}