//https://leetcode.com/problems/jump-game-iv/description/
package Graph;
import java.util.*;

import javax.imageio.plugins.bmp.BMPImageWriteParam;
public class JumpGameIV {
    static int bfs(int []arr){
        int n = arr.length;
        if(n<=1){
            return 0; //this gives the answer if we have only 1 element we are already at destination
        }
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0;i<n;i++){
            graph.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.offer(0);
        vis[0] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int i =  q.poll();
                if(i==n-1){
                    return steps;
                }
                if(i-1>=0&&!vis[i-1]){
                    vis[i-1] = true;
                    q.offer(i-1);
                }
                if(i+1<n&&!vis[i+1]){
                    vis[i+1] = true;
                    q.offer(i+1);
                }
                if(graph.containsKey(arr[i])){
                    for(int j :graph.get(arr[i])){
                       if(!vis[j]){
                        vis[j] = true;
                       q.offer(j);
                    }
                }
                graph.remove(arr[i]);
            } 
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) {
       int []arr = {100,-23,-23,404,100,23,23,23,3,404};
       System.out.println(bfs(arr));


    }
}
