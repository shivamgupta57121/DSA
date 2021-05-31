import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(maxSumNonAdj(arr));
    }
    // Tabulation - Inc / Exc Type DP
    public static int maxSumNonAdj(int arr[]){
        int n = arr.length;
        // Method - 1
        // int dp[][] = new int[2][n];
        // dp[0][0] = 0;
        // dp[1][0] = 0;
        // for(int i = 1 ; i < n ; i++){
        //     if(i == 0){
        //         dp[0][0] = 0;
        //         dp[1][0] = arr[0];
        //     } else {
        //         dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
        //         dp[1][i] = dp[0][i-1] + arr[i];
        //     }
        // }
        // return Math.max(dp[0][n-1], dp[1][n-1]);

        // Method -2 (Space Efficient)
        int exc = 0;
        int inc = 0;
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                exc = 0;
                inc = arr[0];
            } else {
                int newExc = Math.max(exc, inc);
                int newInc = exc + arr[i];
                exc = newExc;
                inc = newInc;
            }
        }
        return Math.max(exc, inc);
    }
}