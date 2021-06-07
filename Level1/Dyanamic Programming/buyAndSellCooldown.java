import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            prices[i] = scn.nextInt();
        }
        System.out.println(buyAndSellCooldown(prices));
    }
    // Dyanamic Programming
    public static int buyAndSellCooldown(int prices[]){
        // Bought State Profit
        // Sell State Profit
        // Cooldown State Profit
        int oBSP = 0, oSSP = 0, oCSP = 0;
        for(int day = 0 ; day < prices.length ; day++){
            if(day == 0){
                oBSP = -prices[0];
            } else {
                int nBSP = Math.max(oBSP, oCSP - prices[day]);
                int nSSP = Math.max(oSSP, prices[day] + oBSP);
                int nCSP = oSSP;
                
                oBSP = nBSP;
                oSSP = nSSP;
                oCSP = nCSP;
            }
        }
        return oSSP;
    }
}