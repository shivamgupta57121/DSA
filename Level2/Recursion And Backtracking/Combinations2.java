import java.io.*;
import java.util.*;

public class Main {
  // Perspective - object chooses
  public static void combinations(int[] boxes, int ci, int ti, int lb){
    // boxes - current placement of items
    // ci - current item to be placed
    // ti - total item to be placed
    // lb - last box used
    if(ci > ti){
        for(int v1 : boxes) {
            if(v1 != 0) {
                System.out.print('i');
            } else { 
                System.out.print('-');
            }
        }
        System.out.println();
        return ;
    }
    for(int idx = lb + 1 ; idx < boxes.length ; idx++){
        boxes[idx] = 1;                     // place item
        combinations(boxes, ci+1, ti, idx); // recursive call to place next
        boxes[idx] = 0;                     // backtrack
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}