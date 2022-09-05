package doublePoint;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] strs = s.toCharArray();
        int n = strs.length;
        int max = 0;
        for (int i = 0, j=0; i < n; i++) {
            while(j<=i && !set.add(strs[i])){
                set.remove(strs[j]);
                j++;
            }
            max = Math.max(max, i-j+1);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring("aab"));;
    }
}
