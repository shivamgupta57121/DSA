import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(noOfWays(n));
    }
    // Similar to fibonacci f(n) = f(n-1) + (n-1) * f(n-2)
    public static int noOfWays(int n){
        int dp[] = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            if(i == 0 || i == 1){
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + (i-1) * dp[i-2];
            }
        }
        return dp[n];
    }
}