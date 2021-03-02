import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr,0,0,"");
    }


    public static void floodfill(int[][] maze, int row, int col, String asf) {
        
        int n = maze.length;
        int m = maze[0].length;
        
        if(row<0 || col<0 || row>=n || col>=m || maze[row][col]==1){
            return ;
        }
        if(row==n-1 && col==m-1){
            System.out.println(asf);
            return ;
        }
        
        maze[row][col] = 1;
        floodfill(maze, row-1, col, asf+"t");
        floodfill(maze, row, col-1, asf+"l");
        floodfill(maze, row+1, col, asf+"d");
        floodfill(maze, row, col+1, asf+"r");
        maze[row][col] = 0;
        
    }
}