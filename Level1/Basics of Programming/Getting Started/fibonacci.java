import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a = 0, b = 1;
        for (int count = 1; count <= n; count++) {
            System.out.println(a);
            int c = a + b;
            a = b;
            b = c;
        }
    }
}