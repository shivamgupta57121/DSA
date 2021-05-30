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
        System.out.println(zeroOneKnapsack(wts,vals,cap));
        
    }
    // Tabulation
    public static int zeroOneKnapsack(int wts[],int vals[],int cap){
        int n = wts.length;
        int dp[][] = new int[n+1][cap+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= cap ; j++){
                int wt = wts[i-1];
                int val = vals[i-1];
                int exc = dp[i-1][j];                                   // exclude item
                int inc = (j - wt >= 0) ? (val + dp[i-1][j-wt]) : 0;    // include item
                dp[i][j] = Math.max(exc,inc);
            }
        }
        return dp[n][cap];
    }
}