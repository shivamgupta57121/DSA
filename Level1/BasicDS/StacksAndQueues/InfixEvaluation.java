import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    System.out.println(solve(exp));
 }
 
 public static int solve(String exp){
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operator = new Stack<>();
    
    for(int idx = 0 ; idx < exp.length() ; idx++){
        char ch = exp.charAt(idx);
        
        if( ch == '(' ){
            operator.push(ch);
        } else if(ch == '*' || ch == '/' || ch == '+' || ch == '-'){
            while(operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)){
                performOperation(operands,operator);
            }
            operator.push(ch);
        } else if( ch == ')'){
            while( operator.peek() != '(' ){
                performOperation(operands,operator);
            }
            operator.pop();
            
        } else if( ch >= '0' && ch <= '9'){
            operands.push(Integer.parseInt(ch+""));
        }
        
        // System.out.println("Stack operands"+operands);
        // System.out.println("Stack operands"+operator);
    }
    
    while(operator.size() > 0 ){
        performOperation(operands,operator);
    }
    return operands.pop();
 }

 public static void performOperation(Stack<Integer> operands , Stack<Character> operator){
    char op = operator.pop();
    int v2 = operands.pop();
    int v1 = operands.pop();
    if(op == '*') operands.push(v1*v2);
    else if(op == '/') operands.push(v1/v2);
    else if(op == '+') operands.push(v1+v2);
    else if(op == '-') operands.push(v1-v2);
 }
 
 public static int precedence(char op){
    if(op == '+' || op == '-')
        return 2;
    else 
        // op == '*' || op =='/'
        return 4;
 }
 
}