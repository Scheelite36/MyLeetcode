package dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
 * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        // 空字符串组成方式只有一种
        dp[0] = 1;
        // 第一个字符串组成方式只有一种
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = Integer.valueOf(s.substring(i - 2, i));
            // i如果能和前一个数字拼合 那组合方式可以是从i-1过来也可以是i-2过来
            dp[i] = temp > 25 || temp < 10 ? dp[i - 1] : dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}