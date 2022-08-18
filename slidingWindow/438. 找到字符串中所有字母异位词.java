package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultBoundedRangeModel;
import javax.xml.stream.EventFilter;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution438 {
    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int ls = s.length(), lp = p.length();
        if (ls < lp) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        // 初始化窗口
        for (int i = 0; i < lp; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < lp; i++) {
            Character c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        for (int i = lp - 1; i < ls; i++) {
            if (i != lp - 1) {
                Character left = s.charAt(i);
                map.put(left, map.getOrDefault(left, 0) + 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                Character right = s.charAt(i - lp);
                map.put(right, map.getOrDefault(right, 0) - 1);
                if (map.get(right) == 0) {
                    map.remove(right);
                }
            }
            if (map.isEmpty()) {
                res.add(i - lp + 1);
            }
        }
        return res;
    }
}

class Solution438_1 {
    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        // 用数组保存字符计数
        List<Integer> res = new ArrayList<>();
        int ls = s.length(), lp = p.length();
        if (ls < lp) {
            return res;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        // 初始化滑动窗口
        for (int i=0;i<lp;i++){
            arr1[s.charAt(i)-'a']++;
            arr2[p.charAt(i)-'a']++;
        }
        if (Arrays.equals(arr1, arr2))
            res.add(0);
        for (int i=lp;i<ls;i++){
            arr1[s.charAt(i)-'a']++;
            arr1[s.charAt(i-lp)-'a']--;
            if (Arrays.equals(arr1, arr2))
                res.add(i-lp+1);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution438_1 s = new Solution438_1();
        s.findAnagrams("baa","aa");
    }
}