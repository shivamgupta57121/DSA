import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upHeapify(data.size()-1);
    }
    
    public void upHeapify(int idx){
        if(idx == 0){
            return ;
        }
        int pIdx = (idx - 1)/2;
        int pVal = data.get(pIdx);
        
        int cVal = data.get(idx);
        
        if(cVal < pVal){
            data.set(pIdx,cVal);
            data.set(idx, pVal);
            
            upHeapify(pIdx);
        }
    }

    public int remove() {
      // write your code here
      if(data.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      int val = data.get(0);
      data.set(0,data.get(data.size()-1));
      data.remove(data.size()-1);
      downHeapify(0);
      return val;
    }
    
    public void downHeapify(int idx){
        int lIdx = (2*idx) + 1;
        int rIdx = (2*idx) + 2;
        
        int minIdx = idx;
        
        if(lIdx < data.size() && data.get(lIdx) < data.get(minIdx)){
            minIdx = lIdx;
        }
        
        if(rIdx < data.size() && data.get(rIdx) < data.get(minIdx)){
            minIdx = rIdx;
        }
        
        if(minIdx != idx){
            int val = data.get(idx);
            int minVal = data.get(minIdx);
            
            data.set(idx,minVal);
            data.set(minIdx,val);
            
            downHeapify(minIdx);
        }
        
    }

    public int peek() {
      // write your code here
      if(data.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}