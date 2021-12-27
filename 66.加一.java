
/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int endOf9 = 0;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9)
                break;
            endOf9++;
        }
        if (endOf9 == len) {
            int[] newDigits = new int[endOf9 + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        digits[len - 1 - endOf9] += 1;
        while (endOf9 != 0) {
            digits[len - endOf9] = 0;
            endOf9--;
        }
        return digits;
    }
}
// @lc code=end
