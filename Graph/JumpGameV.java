//https://leetcode.com/problems/jump-game-v/description/
package Graph;
import java.util.*;
public class JumpGameV {
    static int solve(int []arr,int d){
        int n = arr.length;
        int []memo = new int[n];
        int result = 0;
        for(int i = 0;i<n;i++){
            result = Math.max(result,helper(arr,d,i,memo));
        }
        return result;
    }
    static int helper(int []arr,int d,int i,int []memo){
        if(memo[i]!=0){
            return memo[i];
        }
        int max = 1;
        //Check left
        for(int j = i-1;j>=Math.max(0,i-d)&&arr[j]<arr[i];j--){
           max = Math.max(max,1+helper(arr,d,j,memo));
        }
        for(int j = i+1;j<=Math.min(i+d,arr.length-1)&&arr[j]<arr[i];j++){
            max = Math.max(max,1+helper(arr,d,j,memo));
        }
        memo[i] = max;
        return max;
    }
    public static void main(String[] args) {
        int []arr = {6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;
        System.out.println(solve(arr, d));

    }
}
