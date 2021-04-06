import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  static int dia;
  public static int diameter(Node node){
      int lh = -1, slh = -1;
      for(Node child : node.children ){
         int cht = diameter(child); 
         if(cht > lh){
             slh = lh;
             lh = cht;
         } else if(cht > slh){
             slh = cht;
         }
         if(dia < lh + slh + 2) dia = lh + slh + 2;
      }
      return lh+1;
  }
  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    // Travel and change strategy
    // diameter is maximum number of edges between any two nodes in the tree
    // diameter = largest height + second largest height + 2
    // d = lh + slh + 2 
    dia = 0;
    diameter(root);
    System.out.println(dia);
  }

}