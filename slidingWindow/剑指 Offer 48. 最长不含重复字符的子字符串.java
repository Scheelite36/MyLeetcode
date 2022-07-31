package slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            // 不重复字符滑动窗口的左边界右移
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 滑动窗口右边界右移
            while (rk < n && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                ++rk;
            }
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }

}
