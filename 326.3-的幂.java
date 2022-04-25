/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0){
            return false;
        }
        long sum = 1;
        while (sum < n) {
            sum *= 9;
        }
        return sum == n || sum / 3 == n;
    }
}
// @lc code=end
