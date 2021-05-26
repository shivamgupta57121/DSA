import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // Long startTime = System.currentTimeMillis();

        // System.out.println(fibR(n));
        // System.out.println(fibM(n, new int[n+1]));
        System.out.println(fibT(n)); 

        // Long endTime = System.currentTimeMillis();
        // System.out.println("Duration : "+(endTime-startTime));
    }
    // Recursive
    public static int fibR(int n){
        if(n == 0){
            return 0;
        }
        if(n  == 1){
            return 1;
        }
        int fibNm1 = fibR(n-1);
        int fibNm2 = fibR(n-2);
        int fibN = fibNm1 + fibNm2;

        return fibN;
    }
    // Memoization
    public static int fibM(int n, int qb[]){
        if(n == 0){
            return qb[0] = 0;
        }
        if(n  == 1){
            return qb[1] = 1;
        }
        if(qb[n] != 0){
            return qb[n];
        }

        int fibNm1 = fibM(n-1, qb);
        int fibNm2 = fibM(n-2, qb);
        int fibN = fibNm1 + fibNm2;

        return qb[n] = fibN;
    }
    // Tabulaion
    public static int fibT(int n){
        int[] qb = new int[n+1];
        for(int i = 0; i <= n ; i++){
            if(i == 0){
                qb[i] = 0;
            } else if (i == 1){
                qb[i] = 1;
            } else {
                qb[i] = qb[i-1] + qb[i-2];
            }
        }
        return qb[n];
    }

}