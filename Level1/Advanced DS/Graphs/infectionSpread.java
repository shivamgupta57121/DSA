import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static class Pair{
        int vtx, time;
        Pair(int vtx, int time){
            this.vtx = vtx;
            this.time = time;
        }
    }
    
    public static int spreadOfInfection(ArrayList<Edge> graph[], int src, int t){     boolean visited[] = new boolean[graph.length];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src,1));
        int count = 0;
        while(queue.size() > 0 ){
            Pair pair = queue.remove();
            if(visited[pair.vtx] == false && pair.time <= t){
                
                visited[pair.vtx] = true;
                count++;
                for(Edge e : graph[pair.vtx]){
                    if(visited[e.nbr] == false){
                        queue.add(new Pair(e.nbr, pair.time+1));
                    }
                }
            }
        }
        return count;
        
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        
        // write your code here
        System.out.println(spreadOfInfection(graph, src, t));
    }

}