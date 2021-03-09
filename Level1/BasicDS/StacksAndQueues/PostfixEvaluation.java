import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    solve(exp);
 }
 
 public static void solve(String exp){
    Stack<Integer> ans = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
    for(int idx = 0 ; idx < exp.length() ; idx++){
        char ch = exp.charAt(idx);
        if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            evaluation(ans,ch);
            infixExpBuild(infix,ch);
            prefixExpBuild(prefix,ch);
        }
        else{
            ans.push(Integer.parseInt(ch+""));
            infix.push(ch+"");
            prefix.push(ch+"");
        }
    }
    
    System.out.println(ans.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
    
 }
 
 public static void evaluation(Stack<Integer> ans, char op){
    int v2 = ans.pop(), v1 = ans.pop();
    if(op == '+'){
        ans.push(v1+v2);
    } else if( op == '-' ){
        ans.push(v1-v2);    
    } else if( op == '*' ){
        ans.push(v1*v2);    
    } else if( op == '/' ){
        ans.push(v1/v2);    
    }
    
 }
 public static void infixExpBuild(Stack<String> infix, char op){
    String v2 = infix.pop(), v1 = infix.pop();
    infix.push("("+v1+op+v2+")");
 }
 public static void prefixExpBuild(Stack<String> prefix, char op){
    String v2 = prefix.pop(), v1 = prefix.pop();
    prefix.push(op+v1+v2);
 }
 
}

















