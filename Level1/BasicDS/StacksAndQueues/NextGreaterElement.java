import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){

    // start traversing array from right
    // pop until stack not empty and array value greater equal to top of stack  
    // if stack empty then put -1 
    // else put stack top
    // push to stack

    int n = arr.length;
    int [] ans = new int[n];
    Stack<Integer> st = new Stack<>();
    
    for(int idx = n - 1; idx >= 0 ; idx--){
        while(st.size() > 0 && st.peek() <= arr[idx]){
            st.pop();
        }
        if(st.size() == 0) ans[idx] = -1;
        else ans[idx] = st.peek();
        st.push(arr[idx]);
    }
    return ans;
 }

}