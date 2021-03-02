import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        printNQueens(new int[n][n] ,"",0);
        
    }

    public static void printNQueens(int[][] chess, String csf, int row) { // csf - configuration so far
        int n = chess.length;
        if(row == n){
            csf = csf + ".";
            System.out.println(csf);
            return;
        }
        
        for(int col = 0 ; col < n ; col++ ){
            
            if( isSafe(chess,row,col) == true ){
                chess[row][col] = 1;
                printNQueens(chess , csf + row + "-" + col + ", " , row+1);
                chess[row][col] = 0;
            }
            
        }
        
    }
    
    public static boolean isSafe(int[][] chess, int row, int col){
        int n = chess.length;
       
        // checking all 8 directions
        
        // for(int i = 0 ; i < n ; i++ ){
        //     for(int j = 0 ; j < n ; j++ ){
        //         if(chess[i][j] == 1){
        //             if( (i == row) || (j == col) || (i-j == row-col)  || (i+j == row+col) ) return false;
        //         }
        //     }
        // }
        // return true;
        
        
        // checking only 3 directions
        
        // v. up
        for(int i = row-1 , j = col ; i >= 0 ; i--){
            if(chess[i][j] == 1) return false;
        }
        
        // l. dia
        for(int i = row-1 , j = col-1 ; i >= 0 && j >= 0 ; i-- , j-- ){
            if(chess[i][j] == 1) return false;
        }
        
        // r. dia
        for(int i = row-1 , j = col+1 ; i >= 0 && j < n ; i-- , j++ ){
            if(chess[i][j] == 1) return false;
        }
        
        //implies queen can be placed
        return  true;
        
    }
}