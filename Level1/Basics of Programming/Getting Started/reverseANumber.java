import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int rev = 0;
        while (n != 0) {
            System.out.println(n % 10);
            n /= 10;
        }
    }
}