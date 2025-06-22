//https://leetcode.com/problems/jump-game/
package DynamicPrograming;
import java.util.*;
public class JumpGame {
    static boolean jump(int []nums){
       int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums,0,dp);
    }
    static boolean helper(int []nums,int index,int []dp){
         if(index>=nums.length-1){
            return true;
         }
         if(dp[index]!=-1){
            return dp[index]==0?false:true;
         }
         for(int i =  1;i<=nums[index];i++){
            if(helper(nums, index+i, dp)==true){
                dp[index] = 1;
                return true;
            }
         }
         dp[index] = 0;
         return false;
    }
    static boolean jumpTab(int []nums){
        int n = nums.length;
        boolean []dp = new boolean[n];
        dp[n-1] = true;
        for(int i = n-2;i>=0;i--){
            for(int j=1;j<=nums[i]&&i+j<=n;j++){
              if(dp[i+j]==true){
                dp[i] = true;
                break;
              }
            }
        }
        return dp[0];
        
    }
    static boolean jumpsGreed(int []nums){
          int maxi = 0;
          for(int i =0;i<nums.length;i++){
            if(i>maxi){
                return false;
            }
            maxi = Math.max(maxi,nums[i]+i);
            if(maxi>=nums.length-1){
                return true;
            }
          }
          return false;
    }
    public static void main(String[] args) {
       int []nums = {2,3,1,1,4}; //OP=> true 
       System.out.println(jump(nums));  
       System.out.println(jumpTab(nums));
       System.out.println(jumpsGreed(nums));
    }
}
