/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int m = x^y;
        int sum = 0;
        while(m!=0){
            sum += m & 1;
            m >>>= 1;
        }
        return sum;
    }
}
// @lc code=end

