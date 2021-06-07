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
        // Greedy Approach - Direct formula
        System.out.println(buyAndSellOneTransaction(prices));
    }
    
    public static int buyAndSellOneTransaction(int prices[]){
        int maxProfit = 0, curProfit = 0, buyDay = 0;
        
        for(int day = 1; day < prices.length; day++){
            if(prices[day] < prices[buyDay]){
                buyDay = day;
            } 
            curProfit = prices[day] - prices[buyDay];
            if(curProfit > maxProfit){
               maxProfit = curProfit; 
            }
        }
        return maxProfit;
    }

}