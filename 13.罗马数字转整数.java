/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        char[] sa = s.toCharArray();
        int n = getInt(sa[sa.length - 1]);
        int sum = n;
        // iterate from the end, if num smaller than the last one, sum subtract this one
        for (int i = sa.length - 2; i > -1; --i) {
            int m = getInt(sa[i]);
            sum = m < n ? sum - m : sum + m;
            n = m;

        }
        return sum;
    }

    public int getInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
// @lc code=end
