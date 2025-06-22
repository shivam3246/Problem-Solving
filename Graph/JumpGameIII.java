//https://leetcode.com/problems/jump-game-iii/description/
package Graph;
import java.util.*;

public class JumpGameIII {
    static boolean canReach(int []arr,int start){
        return dfs(arr,start,new boolean[arr.length]);
    }
    private static boolean dfs(int []arr,int i,boolean []visited){
        if(i<0||i>=arr.length||visited[i]){
            return false;
        }
        if(arr[i]==0){
            return true;
        }
        visited[i] = true;

        return dfs(arr,i+arr[i],visited)||dfs(arr,i-arr[i],visited);
    }
    private static boolean bfs(int []arr,int start){
        int n = arr.length;
        boolean []vis = new boolean[n];
        Queue<Integer>q = new LinkedList<>();
        q.offer(start);
        vis[start] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(arr[curr]==0){
                return true;
            }
            int []nextStep = {curr+arr[curr],curr-arr[curr]};
            for(int next:nextStep){
                if(next>=0&&next<n&&!vis[next]){
                    q.offer(next);
                    vis[next]=true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int []arr ={4,2,3,0,3,1,2} ;
        int start = 5;
        System.out.println(canReach(arr, start));
        System.out.println(bfs(arr, start));
    }

}
