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
    public static void main(String[] args) {
       int []nums = {2,3,1,1,4}; //OP=> true 
       System.out.println(jump(nums));  
    }
}
