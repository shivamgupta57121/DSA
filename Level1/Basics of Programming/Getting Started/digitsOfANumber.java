import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int num = n;
        long div = 1, count = 0;
        while (n != 0) {
            div *= 10;
            n /= 10;
            count++;
        }
        while (count != 0) {
            div /= 10;
            long digit = num / div;
            System.out.println(digit);
            num %= div;
            count--;
        }
    }
}