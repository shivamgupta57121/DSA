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
        
        System.out.println(buyAndSellInfTransaction(prices));
    }
    
    public static int buyAndSellInfTransaction(int prices[]){
        int maxProfit = 0;
        
        // for(int day = 1; day < prices.length; day++){
        //     if(prices[day] > prices[day-1]){
        //         maxProfit += prices[day] - prices[day-1];
        //     } 
        // }
        // return maxProfit;
        
        // Method - 2 (Logical Approach)
        // Buy when local minima 
        // Sell when local maxima
        int bp = 0, sp = 0;
        for(int day = 1 ; day < prices.length; day++){
            if(prices[day] >= prices[day - 1]){
                sp = day;
            }
            else {
                maxProfit += prices[sp] - prices[bp];
                bp = day;
                sp = day;
            }
        }
        return maxProfit + prices[sp] - prices[bp];   
    }
}