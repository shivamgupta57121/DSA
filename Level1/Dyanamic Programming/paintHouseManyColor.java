import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int mat[][] = new int[n][k];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < k ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        System.out.println(paintHouseMinCost(mat));
    }
    
    public static int paintHouseMinCost(int mat[][]){
        int n = mat.length;
        int k = mat[0].length;
        
        int dp[][] = new int[n][k];
        
        // Method - 1 (N^3)
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < k ; j++){
        //         if(i == 0){
        //             dp[i][j] = mat[i][j];
        //         } else {
        //             int minCost = Integer.MAX_VALUE;
        //             for(int idx = 0 ; idx < k ; idx++){
        //                 if(idx != j)
        //                     minCost = Math.min(minCost,dp[i-1][idx]);
        //             }
        //             dp[i][j] = minCost + mat[i][j];
        //         }
        //     }
        // }
        // int minCost = Integer.MAX_VALUE;
        // for(int j = 0 ; j < k ; j++){
        //     minCost = Math.min(minCost,dp[n-1][j]);
        // }
        // return minCost;
        
        // Method - 2 (N^2)
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int newleast = Integer.MAX_VALUE;
            int newsleast = Integer.MAX_VALUE;
            for(int j = 0 ; j < k ; j++){
                if(i == 0){
                    dp[i][j] = mat[i][j];
                } else {
                    if(least == dp[i-1][j]){
                        dp[i][j] = sleast + mat[i][j];
                    } else {
                        dp[i][j] = least + mat[i][j];
                    }
                }   
                if(dp[i][j] < newleast){
                    newsleast = newleast;
                    newleast = dp[i][j];
                } else if(dp[i][j] < newsleast){
                    newsleast = dp[i][j];
                }
            }
            least = newleast;
            sleast = newsleast;
        }
        return least;
    }
}