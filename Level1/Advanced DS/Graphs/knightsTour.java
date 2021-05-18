import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int r = scn.nextInt();
        int c = scn.nextInt();
        
        printKnightsTour(new int[n][n], r, c, 1);
        
    }
    // Reactive Approach
    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        int n = chess.length;
        if(r < 0 || c < 0 || r >= n || c >= n || chess[r][c] != 0){
            // invalid pos or alrready visited block
            return ;
        } else if (upcomingMove == n*n){
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return ;
        }
        chess[r][c] = upcomingMove;
        printKnightsTour(chess, r-2, c+1, upcomingMove+1);
        printKnightsTour(chess, r-1, c+2, upcomingMove+1);
        printKnightsTour(chess, r+1, c+2, upcomingMove+1);
        printKnightsTour(chess, r+2, c+1, upcomingMove+1);
        printKnightsTour(chess, r+2, c-1, upcomingMove+1);
        printKnightsTour(chess, r+1, c-2, upcomingMove+1);
        printKnightsTour(chess, r-1, c-2, upcomingMove+1);
        printKnightsTour(chess, r-2, c-1, upcomingMove+1);
        chess[r][c] = 0; // Back Track
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}