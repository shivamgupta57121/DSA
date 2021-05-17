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
    static class BPair{
        int vtx, level;
        BPair(int vtx, int level){
            this.vtx = vtx;
            this.level = level;
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
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            if(visited[i] == false){
                boolean res = isCompBipartite(graph, i, visited);
                if(res == false){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isCompBipartite(ArrayList<Edge>[] graph, int vtx, boolean visited[]){
        Queue<BPair> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        queue.add(new BPair(vtx,0));
        while(queue.size() > 0){
            BPair pair = queue.remove();
            if(visited[pair.vtx] == true){
                if(pair.level%2 != hm.get(pair.vtx)%2){
                    return false;
                }
            } else {
                visited[pair.vtx] = true;
                hm.put(pair.vtx, pair.level);
                for(Edge e : graph[pair.vtx]){
                    if(visited[e.nbr] == false){
                        queue.add(new BPair(e.nbr, pair.level+1));
                    }
                }
            }
        }
        return true;
    }
}