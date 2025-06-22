//https://leetcode.com/problems/jump-game-ii/
package DynamicPrograming;
import java.util.*;
public class JumpGameII {
    static int jump(int []nums){
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    static int helper(int []nums,int index,int []dp){
        int n = nums.length;
         if(index>=n-1){
            return 0;
         }
         if(dp[index]!=-1){
            return dp[index];
         }
         int minJumps = Integer.MAX_VALUE;
         for(int i = 1;i<=nums[index];i++){
           if(index+i<n){
            int jumps = helper(nums,index+i,dp);
            if(jumps!=Integer.MAX_VALUE){
                minJumps = Math.min(minJumps,1+jumps);
            }
           }
         }
         dp[index] = minJumps;
         return dp[index];
    }
    static int greedy(int []nums){
        int ans = 0;
        int currEnd = 0;
        int currFar = 0;
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            currFar = Math.max(nums[i]+i,currFar);
            if(i==currEnd){
                ans++;
                currEnd = currFar;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int []nums = {2,3,1,1,4};  //OP=>2
        System.out.println(jump(nums));
        System.out.println(greedy(nums));
    }
    
}
