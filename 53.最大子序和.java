/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        //initialize a dp array,dp[i] represent the max sub array include i
        int[] dp = new int[len+1];
        // save the max array
        dp[len] = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            dp[len] = Math.max(dp[i], dp[len]);
        }
        return dp[len];
    }
}
// @lc code=end

