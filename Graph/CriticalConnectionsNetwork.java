//https://leetcode.com/problems/critical-connections-in-a-network/
package Graph;
import java.util.*;
public class CriticalConnectionsNetwork {
    static List<List<Integer>> connectionsDfs(int n, List<List<Integer>> connections){
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(List<Integer> edge:connections){
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //We will temporarily remove an edge to find the bridge
        for(List<Integer> edge:connections){
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).remove(Integer.valueOf(v));
            graph.get(v).remove(Integer.valueOf(u));
            boolean []vis = new boolean[n];
            dfs(0,graph,vis);
            if(!allVis(vis)){
                result.add(Arrays.asList(u,v));
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return result;
    }
    private static void dfs(int node,Map<Integer,List<Integer>> graph,boolean []vis){
        vis[node] = true;
        for(int neighbor:graph.get(node)){
            if(!vis[neighbor])
            dfs(neighbor,graph,vis);
        }
    }
    private static boolean allVis(boolean []vis){
        for(boolean v:vis){
            if(!v){
                return false;
            }
          
        }
        return true;    }
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(2, 0),
            Arrays.asList(1, 3)
        );  //OP =>[1,3]
        System.out.println(connectionsDfs(n, connections));
        
    }
    
}
