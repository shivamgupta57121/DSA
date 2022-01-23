import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int low = scn.nextInt();
        int high = scn.nextInt();
        for (int a = low; a <= high; a++) {
            int num = a;
            int flag = 0;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                System.out.println(a);
        }
    }
}