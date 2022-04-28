/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int res = 0;
        // while(n!=0){
        // res += n & 1;
        // n >>>= 1;
        // }
        // return res;
        // 2.
        // n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        // n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        // n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        // n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        // n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        // return n;
        // 3. see source code. generate from func 2
        return Integer.bitCount(n);
    }
}
// @lc code=end
