import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(climbStairsR(n));
        // System.out.println(climbStairsM(n, new int[n+1]));
        System.out.println(climbStairsT(n));
    }
    // Recursive
    public static int climbStairsR(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        return climbStairsR(n-1) + climbStairsR(n-2) + climbStairsR(n-3);
    }
    // Memoization
    public static int climbStairsM(int n, int qb[]){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return qb[0] = 1;
        }
        if(qb[n] != 0){
            return qb[n];
        }
        return climbStairsM(n-1, qb) + climbStairsM(n-2, qb) + climbStairsM(n-3, qb);
    }
    // Tabulation
    public static int climbStairsT(int n){
        int qb[] = new int[n+1];

        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                qb[0] = 1;
            }
            else if(i == 1){
                qb[i] = qb[i-1];
            }
            else if(i == 2){
                qb[i] = qb[i-1] + qb[i-2];
            }
            else {
                qb[i] = qb[i-1] + qb[i-2] + qb[i-3];
            }
        }
        return qb[n];
    }   
}