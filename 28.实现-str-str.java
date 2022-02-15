
/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }     
        char[] needles = needle.toCharArray();
        char[] haystacks = haystack.toCharArray();
        // 待匹配的串更长的话直接返回-1
        if (haystacks.length < needles.length) {
            return -1;
        }
        int[] nextVal = getNextVal(needles);
        int ans = 0;
        int i = 0;
        // 逐个匹配
        while (ans < haystacks.length && i < needles.length) {
            if (i == -1 || haystacks[ans] == needles[i]) {
                // 主串直接前进
                ++ans;
                ++i;
            } else {
                // 未匹配上 跳转相应位置
                i = nextVal[i];
            }
        }
        // 匹配成功
        if (i == needles.length) {
            return ans - i;
        }
        return -1;
    }

    int[] getNextVal(char[] needles) {
        int len = needles.length;
        int[] nextVal = new int[len];
        // 代表匹配失败后模式串需要移动到的模式串的位置下标。第一个为-1
        int j = -1;
        // 对应模式串/nextVal数组的下标
        int i = 0;
        nextVal[i] = j;
        while (i < len - 1) {
            if (j == -1 || needles[i] == needles[j]) {
                ++i;
                ++j;
                // 此时如果如果满足i和j位置的字符相同 则nextVal中相应位置上值相同
                if (needles[i] == needles[j]) {
                    nextVal[i] = nextVal[j];
                } else {
                    // 否则nextVal的i对应位置设置为j (公共前后缀+1)
                    nextVal[i] = j;
                }
            } else {
                // 如果当前位置没有匹配上，对于下一个i来说公共前后缀为0
                j = nextVal[j];
            }
        }
        return nextVal;
    }
}
// @lc code=end
