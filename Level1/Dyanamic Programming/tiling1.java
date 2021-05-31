import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // no of ways will be equal to fibonacci of n+1
        System.out.println(fibonacci(n+1));
    }
    
    public static int fibonacci(int n){
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n ; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}