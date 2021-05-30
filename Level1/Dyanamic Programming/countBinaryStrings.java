import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // Method - 1
        // int dp[][] = new int[2][n+1];
        // for(int len = 1 ; len <= n ; len++){
        //     if(len == 1){
        //         dp[0][1] = dp[1][1] = 1;
        //     } else {
        //         dp[0][len] = dp[1][len-1];
        //         dp[1][len] = dp[0][len-1] + dp[1][len-1];
        //     }
        // }
        // System.out.println(dp[0][n]+dp[1][n]);

        // Method - 2 (Space Efficient)
        int countEnd0 = 1;
        int countEnd1 = 1;
        for(int i = 2; i <= n ; i++){
            int temp0 = countEnd1;
            int temp1 = countEnd0 + countEnd1;
            countEnd0 = temp0;
            countEnd1 = temp1;
        }
        System.out.println(countEnd0+countEnd1);

    }

}