package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hard
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 * 
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        // 滑动窗口
        List<Integer> res = new ArrayList<>();
        int n = words.length, m = words[0].length(), l = s.length();
        // 划分单词 后面不够的忽略
        for (int i = 0; i < m; i++) {
            if (i + m * n > l) {
                break;
            }
            // 添加初始窗口
            Map<String, Integer> map = new HashMap<>();
            for (int j = i; j < i + m * n; j += m) {
                String sub = s.substring(j, j + m);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) - 1);
                if (map.get(w) == 0) {
                    map.remove(w);
                }
            }
            // 移动滑动窗口
            for (int j = i; j < l - m * n + 1; j += m) {
                if (j != i) {
                    String right = s.substring((n - 1) * m + j, m * n + j);
                    map.put(right, map.getOrDefault(right, 0) + 1);
                    if (map.get(right) == 0) {
                        map.remove(right);
                    }
                    String left = s.substring(j - m, j);
                    map.put(left, map.getOrDefault(left, 0) - 1);
                    if (map.get(left) == 0) {
                        map.remove(left);
                    }
                }
                if (map.isEmpty()) {
                    res.add(j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution30 s = new Solution30();
        s.findSubstring("aaa", new String[] {"a","a"});
    }
}