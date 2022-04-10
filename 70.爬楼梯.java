import java.util.concurrent.SubmissionPublisher;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        // define the dp array
        // dp[n] represent the number of ways to the n steps
        int[] dp = new int[3];
        // represent only first and second step's ways
        dp[0] = 1;
        dp[1] = 2;
        while (n-- > 2) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
// @lc code=end
