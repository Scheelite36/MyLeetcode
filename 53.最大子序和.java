/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        //initialize a dp array,dp[i] represent the max sub array include i
        int[] dp = new int[3];
        // save the max array
        dp[2] = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[1] = Math.max(dp[0]+nums[i], nums[i]);
            dp[2] = Math.max(dp[1], dp[2]);
            dp[0] = dp[1];
        }
        return dp[2];
    }
}
// @lc code=end

