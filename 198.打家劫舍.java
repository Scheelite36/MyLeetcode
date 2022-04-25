/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // still dp array。after analyze the array usage, fixed the array to len of 4
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] dp = new int[4];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for (int i = 3; i < len; i++) {
            dp[3] = (dp[0] + nums[i]) > (dp[1] + nums[i]) ? dp[0] + nums[i] : dp[1] + nums[i];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[1] > dp[2] ? dp[1] : dp[2];
    }
}
// @lc code=end
