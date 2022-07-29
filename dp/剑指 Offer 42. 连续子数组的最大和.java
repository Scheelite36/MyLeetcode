package dp;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 
 * 要求时间复杂度为O(n)。
 * 
 *  
 * 
 * 示例1:
 * 
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[j] 为包含nums[j]的最大连续子数组 dp[j] = max(nums[j], dp[j]+nums[j])
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}