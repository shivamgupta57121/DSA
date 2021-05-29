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
        System.out.println(coinChangePermutation(coins, target));
    }

    public static int coinChangePermutation(int coins[], int tar){
        int dp[] = new int[tar+1];
        dp[0] = 1;
        for(int t = 1 ; t <= tar ; t++){
            for(int coin : coins){
                if(t >= coin){
                    dp[t] += dp[t - coin];
                } 
            }
        }
        return dp[tar];
    }
}