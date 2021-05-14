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

        // A hamiltonian path is such which visits all vertices without visiting any twice. 
        // A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
        // Here using hashmap <Integer, Boolean> instead of array for visited and using put/remove 
        // Need of hashmap - to check how many edges are visited that can be done using size in constant time
        // but in array we will need to traverse whole array to find that.
        findHamiltonianPathAndCycle(graph, src, new HashMap<>(), ""+src, src);

    }
    
    public static void findHamiltonianPathAndCycle(ArrayList<Edge> graph[], int vtx, HashMap<Integer, Boolean> visited, String psf, int osrc){
        // here we are checking for length - 1 since we had put only length -1 elements in hashmap when we call for last element 
        if(visited.size() == graph.length -1){
            boolean directEdge = false;
            for(Edge e : graph[vtx]){
                if(e.nbr == osrc){
                    directEdge = true;
                }
            }
            if(directEdge == true){
                System.out.println(psf + "*"); // hamiltonian cycle
            } else{
                System.out.println(psf + "."); // hamiltonian path
            }
            return ;
        } 
        visited.put(vtx,true);
        for(Edge e : graph[vtx]){
            if(visited.containsKey(e.nbr) == false){
                findHamiltonianPathAndCycle(graph, e.nbr, visited, psf+e.nbr, osrc);
            }
        }
        visited.remove(vtx);
    }
}