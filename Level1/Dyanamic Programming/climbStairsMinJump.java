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
        int steps = countMinJump(moves);
        if(steps == Integer.MAX_VALUE){
            System.out.println("null");
        } else {
            System.out.println(steps);
        }
    }
    // Tabulation
    public static int countMinJump(int moves[]){
        int n = moves.length;
        int qb[] = new int[n+1];
        // base case qb[n] = 0, no need to put as by default 0 in aarray
        for(int i = n-1 ; i >= 0 ; i--){
            int maxJump = moves[i];
            if(maxJump == 0){
                qb[i] = Integer.MAX_VALUE;
            } else {
                int minSteps = Integer.MAX_VALUE;
                for(int jmp = 1 ; jmp <= maxJump && i+jmp <= n ; jmp++){
                    minSteps = Math.min(minSteps,qb[i+jmp]);
                }
                if(minSteps == Integer.MAX_VALUE){
                    qb[i] = Integer.MAX_VALUE;
                } else {
                    qb[i] = minSteps + 1;
                }
            }
        }
        return qb[0];
    }
}