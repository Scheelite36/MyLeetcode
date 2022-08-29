package divideAndConquer;


/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution395 {
    // 分治法 当字串中某个字符出现1～k-1 次 那么这个字串就不成立
    // 分治法通过dfs 拆成合适的字串
    public int longestSubstring(String s, int k) {
        int n = s.length();
        char[] sa = s.toCharArray();
        return dfs(0, n - 1, sa, k);
    }

    public int dfs(int l, int r, char[] s, int k) {
        if (l > r || r - l < k - 1) {
            return 0;
        }
        int[] alpha = new int[26];
        for (int i = l; i <= r; i++) {
            alpha[s[i] - 'a']++;
        }
        for (int i = l; i <= r; i++) {
            if (alpha[s[i] - 'a'] < k) {
                return Math.max(dfs(l, i - 1, s, k), dfs(i + 1, r, s, k));
            }
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        Solution395 s = new Solution395();
        s.longestSubstring("aaabb", 3);
    }
}

class Solution395_1 {
    // 以字符种类数量作为虚拟的滑动窗口 不太推荐 应该使用分治算法 效率更高
    public int longestSubstring(String s, int k) {
        int n = s.length(), max = 0;
        // 最少一个字符 最多n个字符
        for (int t = 1; t <= n; t++) {
            // 初始化左右边界，滑动窗口内的字符种类数量，滑动窗口内满足出现k次的字符数量
            int l = 0, r = 0, tot = 0, less = 0;
            int[] alpha = new int[26];
            while (r < n) {
                int i = s.charAt(r) - 'a';
                alpha[i]++;
                if (alpha[i] == 1) {
                    tot++;
                }
                if (alpha[i] == k) {
                    less++;
                }
                // 判断左边界的移动
                while (tot > t && r - l + 1 >= k) {
                    int j = s.charAt(l) - 'a';
                    alpha[j]--;
                    if (alpha[j] == k - 1) {
                        less--;
                    }
                    if (alpha[j] == 0) {
                        tot--;
                    }
                    l++;
                }
                if (less == tot) {
                    max = Math.max(max, r - l + 1);
                }
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution395 s = new Solution395();
        s.longestSubstring("ababbc", 2);
    }
}