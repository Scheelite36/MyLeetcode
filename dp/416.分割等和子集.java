package dp;
/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 * 
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/partition-equal-subset-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for (int m:nums){
            sum += m;
        }
        if (sum % 2 == 1) return false;
        // dp[j] 表示能否选出和为j的数据
        // 由 dp[i][j]转移方程降维而来 到第i个数能否选出和为j的数据
        int capacity = sum / 2;
        boolean[] dp = new boolean[capacity+1];
        // 初始化
        dp[0] = true;
        for (int i=1; i<=n;i++){
            for(int j = capacity;j>=nums[i-1];j--){
                // 可以理解为基于不包含当前i ｜｜ 包含当前i 能否取出和为j的
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[capacity];
    }
}
// @lc code=end

