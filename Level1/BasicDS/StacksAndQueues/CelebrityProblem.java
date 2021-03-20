import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        int n = arr.length;
        Stack <Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            st.push(i);
        }
        while(st.size()>1){
            int p1 = st.pop();
            int p2 = st.pop();
            if(arr[p1][p2] == 1){
                // p2 can be celebrity
                st.push(p2);
            } else {
                // p1 can be celebrity
                st.push(p1);
            }
        }
        int possibleCeleb = st.pop();
        // check the row for 0 
        for(int c = 0 ; c < n ; c++){
            if(arr[possibleCeleb][c] == 1) {
                System.out.println("none");
                return ;
            }
        }
        // check the col for 1 
        for(int r = 0 ; r < n ; r++){
            if(arr[r][possibleCeleb] == 0 && r != possibleCeleb) {
                System.out.println("none");
                return ;
            }
        }
        
        System.out.println(possibleCeleb);
        
    }

}