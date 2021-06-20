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
        int tFee = scn.nextInt();
        
        System.out.println(buyAndSellTranFee(prices, tFee));
    }
    // Dyanamic Programming
    public static int buyAndSellTranFee(int prices[], int tFee){
        int oBSP = 0, oSSP = 0;
        
        for(int day = 0 ; day < prices.length ; day++){
            if(day == 0){
                oBSP = -prices[0];
            } else {
                int nBSP = Math.max(oSSP - prices[day], oBSP);
                int nSSP = Math.max(prices[day] - tFee + oBSP,oSSP);
                
                oBSP = nBSP;
                oSSP = nSSP;
            }
        }

        return oSSP;
    }
     // Dyanamic Programming - Code With State
    public static int buyAndSellTranFeeState(int prices[], int tFee){
        int oBSP = 0, oSSP = 0;
        String oBS = "", oSS = "";

        for(int day = 0 ; day < prices.length ; day++){
            if(day == 0){
                oBSP = -prices[0];
                oBS += "B"+0;
            } else {
                int nBSP = Math.max(oSSP - prices[day], oBSP);
                int nSSP = Math.max(prices[day] - tFee + oBSP,oSSP);
                
                String nBS = "", nSS = "";
                if(nBSP != oBSP){
                    nBS = oSS + "B"+day;
                }
                if(nSSP != oSSP){
                    nSS = oBS + "S"+day;
                }
                
                if(nBSP != oBSP){
                    oBS = nBS;
                }
                if(nSSP != oSSP){
                    oSS = nSS;
                }
                oBSP = nBSP;
                oSSP = nSSP;
            }
        }
        System.out.println(oSS);
        return oSSP;
    }
}