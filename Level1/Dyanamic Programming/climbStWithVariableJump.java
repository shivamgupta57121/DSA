import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int moves[] = new int[n];
        for(int i = 0; i < n; i++){
            moves[i] = scn.nextInt();
        }
        System.out.println(countPathVariableJump(moves));
    }
    // Tabulation
    public static int countPathVariableJump(int moves[]){
        int n = moves.length;
        int qb[] = new int[n+1];
        for(int i = n ; i >= 0 ; i--){
            if(i == n){
                qb[n] = 1; // base case
            } else {
                int maxJump = moves[i];
                if(maxJump == 0){
                    qb[i] = 0;
                } else {
                    for(int jmp = 1 ; jmp <= maxJump && i + jmp <= n ; jmp++){
                        qb[i] += qb[i+jmp];
                    }
                }
            }  
        }
        return qb[0];
    }
}