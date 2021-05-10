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

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      // write all your codes here
      allPath(graph, src, dest, new boolean[vtces], ""+src);
    }
    
    public static void allPath(ArrayList<Edge>[] graph, int vtx, int dest, boolean visited[], String psf){
        // logic
        if(vtx == dest){
            System.out.println(psf);
            return ;
        }
        visited[vtx] = true;
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                allPath(graph, e.nbr, dest, visited, psf+e.nbr);
            }
        }
        visited[vtx] = false;
    }


}