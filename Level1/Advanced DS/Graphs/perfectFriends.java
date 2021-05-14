import java.io.*;
import java.util.*;

public class Main {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
   

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for(int i = 0; i < n ; i++){
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 0; i < k ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = 0;
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        ArrayList<ArrayList<Integer>> allComps = gcc(graph);
        int count = 0;
        // Method 1
        for(int i = 0 ; i < allComps.size() - 1; i++){
            for(int j = i+1 ; j < allComps.size(); j++){
                ArrayList<Integer> ith = allComps.get(i);
                ArrayList<Integer> jth = allComps.get(j);
                count += (ith.size() * jth.size());
            }
        }


        // Method 2
        // Possible pairs = Total possible pairs - possible pairs that both belong to same group 
        // nC2 - sizeC2 for each list 
        // nC2 can be calculated as n(n-1)/2

        // count = (n*(n-1))/2;
        // for(int i = 0 ; i < allComps.size() ; i++){
        //     ArrayList<Integer> list = allComps.get(i);
        //     count -= (list.size() * (list.size() - 1))/2;
        // }
        
        System.out.println(count);


    }

    // Iterative function to traverse visited array
    public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge> graph[]){
        ArrayList<ArrayList<Integer>> allComps = new ArrayList<>();
        
        boolean visited[] = new boolean[graph.length];
        
        for(int i = 0 ; i < graph.length ; i++){
            if(visited[i] == false){
                ArrayList<Integer> res = new ArrayList<>();
                gcc(graph, i, visited, res);
                allComps.add(res);
            }
        }
        
        return allComps;
    }
   
    // Recusive function to find all edges connected to a particular vertex
    public static void gcc(ArrayList<Edge> graph[], int vtx, boolean visited[], ArrayList<Integer> res){
        res.add(vtx);
        visited[vtx] = true;
        
        for(Edge e : graph[vtx]) {
            if(visited[e.nbr] == false){
                gcc(graph, e.nbr, visited, res);
            }
        }
    }

}