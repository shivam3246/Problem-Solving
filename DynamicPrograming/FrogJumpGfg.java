//https://www.geeksforgeeks.org/problems/geek-jump/1
package DynamicPrograming;
import java.util.*;

public class FrogJumpGfg {

    static int helperMem(int[] height, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solveRec(n - 1, height, dp);
    }

    // Top-down recursive helper with memoization
    static int solveRec(int i, int[] height, int[] dp) {
        if (i == 0) return 0;

        if (dp[i] != -1) return dp[i];

        int left = solveRec(i - 1, height, dp) + Math.abs(height[i] - height[i - 1]);

        int right = Integer.MAX_VALUE;
        if (i > 1)
            right = solveRec(i - 2, height, dp) + Math.abs(height[i] - height[i - 2]);

        return dp[i] = Math.min(left, right);
    }
    static int helperTab(int[] height, int n) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int oneStep = dp[i - 1] + Math.abs(height[i] - height[i - 1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] height = {20, 30, 40, 20}; // Expected Output: 20
        int n = height.length;
        System.out.println(helperMem(height, n));
        System.out.println(helperTab(height, n));
    }
}
