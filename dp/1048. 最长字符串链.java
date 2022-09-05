package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。

如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。

例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。

从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
 

示例 1：

输入：words = ["a","b","ba","bca","bda","bdca"]
输出：4
解释：最长单词链之一为 ["a","ba","bda","bdca"]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-string-chain
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1048 {
    /**
     * 长度比较器
     */
    Comparator<String> cmp = new Comparator<String>() {
        @Override
        public int compare(String a, String b){
            return a.length()-b.length();
        }
    };

    /**
     * 判断a是不是可以添加一个数变成b
     * @param a 前一个数
     * @param b
     * @return
     */
    public boolean check(String a, String b){
        if (a.length()+1 != b.length()) return false;
        int j = 0;
        for (int i = 0; i < b.length(); i++) {
            while(j < a.length() && a.charAt(j) == b.charAt(i)){
                j++;
            }
        }
        return j == a.length();
    }
    public int longestStrChain(String[] words) {
        Collections.sort(Arrays.asList(words), cmp);
        int n = words.length;
        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (check(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution1048 s = new Solution1048();
        System.out.println(s.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
