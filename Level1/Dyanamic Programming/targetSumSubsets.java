import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for(int i = 0 ; i < n ; i++){
            coins[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(tarSumSubset(coins, target));
    }

    public static boolean tarSumSubset(int coins[], int tar){
        int n = coins.length;
        boolean dp[][] = new boolean[n+1][tar+1];
        for(int r = 0 ; r <= n ; r++){
            for(int c = 0 ; c <= tar ; c++){
                if(r == 0 && c == 0){
                    dp[r][c] = true;
                } else if(r == 0){
                    dp[r][c] = false;
                } else if(c == 0){
                    dp[r][c] = true;
                } else {
                    int coin = coins[r-1];
                    boolean exc = dp[r-1][c]; // exclude current coin
                    boolean inc = (c-coin >= 0) ? dp[r-1][c-coin] : false; // include current coin
                    dp[r][c] = exc || inc;
                }
            }
        }
        return dp[n][tar];
    }
}