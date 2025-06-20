//https://www.geeksforgeeks.org/dsa/maximum-sum-such-that-no-two-elements-are-adjacent-set-2/
package DynamicPrograming;
import java.util.*;
public class MaxSumNoEleAdj {
    static int helperRec(int []arr,int index){
        int n = arr.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        if(index==0){
            return arr[0];
        }
        if(index<0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick = arr[index] + helperRec(arr, index-2);
        int noPick = 0+helperRec(arr, index-1);

        dp[index] = Math.max(pick,noPick);
        return dp[index];
    }
    static int helperTab(int []arr){
        int n = arr.length;

        // Handle edge cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        int []dp = new int[n];

        // Initialize base cases for dp array
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]); // At index 1, max is either arr[0] or arr[1]

        // Iterate from the third element onwards
        for(int i = 2; i < n; i++){
            // Option 1: Include arr[i]
            // If arr[i] is included, arr[i-1] cannot be included.
            // So, we add arr[i] to the maximum sum obtained up to arr[i-2].
            int pick = arr[i] + dp[i-2];

            // Option 2: Exclude arr[i]
            // If arr[i] is excluded, the maximum sum up to this point
            // is simply the maximum sum obtained up to arr[i-1].
            int noPick = dp[i-1];

            // Store the maximum of the two options
            dp[i] = Math.max(pick, noPick);
        }

        return dp[n-1]; // The result is the maximum sum at the last index
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 3, 8, 2, 4};  //OP=>19
        System.out.println(helperRec(arr,arr.length-1));
        System.out.println(helperTab(arr));
    }
}
