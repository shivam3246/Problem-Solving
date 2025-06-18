//https://leetcode.com/problems/climbing-stairs/description/
package DynamicPrograming;
import java.util.*;

public class ClimbingStairs {
    static int helperMem(int n){
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = helperMem(n-1)+helperMem(n-2);
        return dp[n];
    }
    static int helperTab(int n){
        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            dp[n-1] = dp[i-2]+dp[i-1]; 
        }
        return dp[n-1];
    }
    static int helperSpac(int n){
        if(n<=2){
            return n;
        }
        int p1= 2;
        int p2 = 1;
        
        
        for(int i =2;i<=n;i++){
            int curr = p1+p2;
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(helperMem(n));
        System.out.println(helperTab(n));
        System.out.println(helperSpac(n));
    }
}
