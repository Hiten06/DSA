import java.io.*;
import java.util.*;

public class Main {
    public static class Edge{
        int src;
        int nbr;
        public Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    public static void  topological(ArrayList<Edge>[] graph,Stack<Integer> stk, boolean[] visited,int src){
        visited[src] =true;
        for(Edge e:graph[src]){
            if(visited[e.nbr]  == false){
                topological(graph,stk,visited,e.nbr);
            }
        }
        
        stk.push(src);
    }
    
    public static void dfscount(ArrayList<Edge>[] graph,boolean[] visited,int src){
        visited[src] =true;
        for(Edge e:graph[src]){
            if(visited[e.nbr]  == false){
                dfscount(graph,visited,e.nbr);
            }
        }
    }
	public static void main(String args[]) throws Exception {
                Scanner sc = new Scanner(System.in);
                int v=sc.nextInt();
                int e=sc.nextInt();
                ArrayList<Edge>[] graph = new ArrayList[v+1];
                for(int i=1;i<=v;i++){
                    graph[i]=new ArrayList<>();
                }
                for(int i=0;i<e;i++){
                    int v1=sc.nextInt();
                    int v2=sc.nextInt();
                    graph[v1].add(new Edge(v1,v2));
                }
                boolean[] visited = new boolean[v+1];
                  Stack<Integer> stk = new Stack<>();
                for(int i=1;i<=v;i++){
                    if(visited[i]==false){
                        topological(graph,stk,visited,i);
                    }
                }
                //System.out.println(stk);
                ArrayList<Edge>[] revgraph = new ArrayList[v+1];
                for(int i=1;i<=v;i++){
                    revgraph[i]= new ArrayList<>();
                }
                
                for(int i=1;i<=v;i++){
                    for(Edge e1: graph[i]){
                        revgraph[e1.nbr].add(new Edge(e1.nbr,i));                    
                    }
                }
                int count=0;
                visited=new boolean[v+1];
                while(stk.size()>0){
                    int node =stk.pop();
                    if(visited[node] == false){
                        count++;
                        dfscount(revgraph,visited,node);
                    }
                }

              System.out.println(count);
            
		}

}
