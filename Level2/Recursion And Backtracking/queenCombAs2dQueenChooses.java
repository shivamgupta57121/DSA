import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        // qpsf  - queen placed so far
        // tq    - total queen
        // chess - current placement of queen on board
        // i,j   - co-ordinates where last queen placed

        if(qpsf == tq){
            for(boolean row[] : chess){
                for(boolean vl : row){
                    if(vl){
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int c = j+1 ; c < chess[0].length ; c++){
            chess[i][c] = true;
            queensCombinations(qpsf+1, tq, chess, i, c);
            chess[i][c] = false;
        }

        for(int r = i+1 ; r < chess.length ; r++){
            for(int c = 0 ; c < chess[0].length ; c++){
                chess[r][c] = true;
                queensCombinations(qpsf+1, tq, chess, r, c);
                chess[r][c] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}