import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge> graph[]){
        ArrayList<ArrayList<Integer>> allComp = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            if(visited[i] == false){
                ArrayList<Integer> res = new ArrayList<>();
                gcc(graph, visited, i, res);
                allComp.add(res);
            }
        }
        return allComp;
    }
    
    public static void gcc(ArrayList<Edge> graph[], boolean visited[], int vtx, ArrayList<Integer> res){
           
        visited[vtx] = true;
        res.add(vtx);
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                gcc(graph, visited, e.nbr, res);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        ArrayList<ArrayList<Integer>> comp = gcc(graph);
        System.out.println(comp.size() == 1);
    }
}