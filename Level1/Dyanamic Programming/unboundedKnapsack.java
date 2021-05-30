import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int vals[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            vals[i] = scn.nextInt();
            
        }
        int wts[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            wts[i] = scn.nextInt();
            
        }
        int cap = scn.nextInt();
        System.out.println(unboundedKnapsack(wts,vals,cap));
        
    }
    // Tabulation
    public static int unboundedKnapsack(int wts[],int vals[],int cap){
        int n = wts.length;
        int dp[] = new int[cap+1];
        // Introducing items one by one
        // Calculating dp array for current item than moving to next item
        for(int i = 0 ; i < n ; i++){
            int wt = wts[i];
            int val = vals[i];
            for(int j = wt ; j <= cap ; j++){
                dp[j] = Math.max(dp[j], val + dp[j-wt]);
            }
        }
        return dp[cap];
    }
}