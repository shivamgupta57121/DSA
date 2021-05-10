import java.util.*;
public class Intro{
    public static class Edges{
        int src, dest, wt;
        Edges(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        public String toString(){
            return src+" -> "+ dest + " @ " + wt;
        }
    }
    public static void main(String[] args){
        ArrayList<Edges> graph[] = new ArrayList[7];

        for(int i = 0 ; i < graph.length ; i++ ){
            graph[i] = new ArrayList();
        }

        graph[0].add(new Edges(0,1,10));
        graph[0].add(new Edges(0,3,40));
        
        graph[1].add(new Edges(1,0,10));
        graph[1].add(new Edges(1,2,10));

        graph[2].add(new Edges(2,1,10));
        graph[2].add(new Edges(2,3,10));

        graph[3].add(new Edges(3,0,40));
        graph[3].add(new Edges(3,2,10));
        graph[3].add(new Edges(3,4,10));

        graph[4].add(new Edges(4,3,10));
        graph[4].add(new Edges(4,5,3));
        graph[4].add(new Edges(4,6,8));

        graph[5].add(new Edges(5,6,3));
        graph[5].add(new Edges(5,4,3));

        graph[6].add(new Edges(6,4,8));
        graph[6].add(new Edges(6,5,3));


        for(int i = 0 ; i < graph.length ; i++){
            System.out.println(i+" "+graph[i]);
        }
    }
}