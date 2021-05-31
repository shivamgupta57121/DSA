import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int oneSide = arrangeBuildingsOneSide(n);
        System.out.println((long)oneSide * oneSide);
    }

    public static int arrangeBuildingsOneSide(int n){
        int countEndB = 1;
        int countEndS = 1;
        for(int i = 2 ; i <= n ; i++){
            int tempB = countEndS;
            int tempS = countEndB + countEndS;
            countEndB = tempB;
            countEndS = tempS;
        }
        return countEndB + countEndS;
    }
}