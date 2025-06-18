
package DynamicPrograming;
import java.util.*;
public class Fibonacci {
    static int helperMem(int n){
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = helperMem(n-1)+helperMem(n-2);
        return dp[n];
    }
    static int helperTab(int n){
        int []dp = new int[n+1];
        if(n<=1){
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    static int helperSpace(int n){
       
        int p1 = 0;
        int p2 = 1;
        for(int i =2;i<=n;i++){
            int curr = p1+p2;
            p1 = p2;
            p2 = curr;
        }
        return p2;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(helperMem(n));
        System.out.println(helperTab(n));
        System.out.println(helperSpace(n));
        
    }
}
