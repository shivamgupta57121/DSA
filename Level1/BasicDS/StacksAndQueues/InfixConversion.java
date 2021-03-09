import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    solve(exp);
 }
 
 public static void solve(String exp){
    Stack<Character> operator = new Stack<>();
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    
    
    for(int idx = 0 ; idx < exp.length() ; idx++){
        char ch = exp.charAt(idx);
        
        if( ch == '(' ){
            operator.push(ch);
        } else if(ch == '*' || ch == '/' || ch == '+' || ch == '-'){
            while(operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)){
                performOperation(operator,prefix,postfix);
            }
            operator.push(ch);
        } else if( ch == ')'){
            while( operator.peek() != '(' ){
                performOperation(operator,prefix,postfix);
            }
            operator.pop();
            
        } else {
            prefix.push(ch+"");
            postfix.push(ch+"");
        }
    
    }
    
    while(operator.size() > 0 ){
        performOperation(operator,prefix,postfix);
    }
    System.out.println(postfix.pop());
    System.out.println(prefix.pop());
 }

 public static void performOperation(Stack<Character> operator, Stack<String> prefix, Stack<String> postfix){
    char op = operator.pop();

    String v2pre = prefix.pop();
    String v1pre = prefix.pop();
    prefix.push(op+v1pre+v2pre);
    
    String v2post = postfix.pop();
    String v1post = postfix.pop();
    postfix.push(v1post+v2post+op);
 }
 
 public static int precedence(char op){
    if(op == '+' || op == '-')
        return 2;
    else 
        // op == '*' || op =='/'
        return 4;
 }
 
}