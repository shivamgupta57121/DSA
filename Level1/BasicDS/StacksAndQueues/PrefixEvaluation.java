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
    Stack<String> postfix = new Stack<>();
    
    for(int idx = exp.length() - 1 ; idx >= 0 ; idx--){
        char ch = exp.charAt(idx);
        if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            evaluation(ans,ch);
            infixExpBuild(infix,ch);
            postfixExpBuild(postfix,ch);
        }
        else{
            ans.push(Integer.parseInt(ch+""));
            infix.push(ch+"");
            postfix.push(ch+"");
        }
    }
    
    System.out.println(ans.pop());
    System.out.println(infix.pop());
    System.out.println(postfix.pop());
    
 }
 
 public static void evaluation(Stack<Integer> ans, char op){
    int v1 = ans.pop(), v2 = ans.pop();
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
    String v1 = infix.pop(), v2 = infix.pop();
    infix.push("("+v1+op+v2+")");
 }
 public static void postfixExpBuild(Stack<String> postfix, char op){
    String v1 = postfix.pop(), v2 = postfix.pop();
    postfix.push(v1+v2+op);
 }
 
}

