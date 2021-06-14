import java.io.*;
import java.util.*;

public class Main {
  // Perspective - Permutation 1 (object chooses)
  public static void permutations(int[] boxes, int ci, int ti){
    // boxes - current placement of items
    // ci - current item to be placed
    // ti - total item to be placed
    if(ci > ti){
        for(int v1 : boxes){
            System.out.print(v1);
        }
        System.out.println();
        return ;
    }
    for(int idx = 0 ; idx < boxes.length ; idx++){
        if(boxes[idx] == 0){
            boxes[idx] = ci;                    // place item
            permutations(boxes, ci+1, ti);      // recursive call to place next
            boxes[idx] = 0;                     // backtrack
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}