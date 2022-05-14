import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    // 回溯
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        traceBack(1, k, new ArrayList<>(), n);
        return res;
    }

    public void traceBack(int start, int k, List<Integer> cur, int n) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        while (start < n+1) {
            cur.add(start++);
            traceBack(start, k-1, cur, n);
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end
