import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traceBack(0, target, new ArrayList<>(), candidates);
        return res;
    }

    public void traceBack(int start, int target, List<Integer> cur, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        }
        for (int j = start; j < candidates.length; j++) {
            if (target - candidates[j] < 0) {
                return;
            }
            // 重点 排除掉已经被remove的相同的数
            if (j > start && candidates[j] == candidates[j - 1]) {
                continue;
            }
            cur.add(candidates[j]);
            traceBack(j + 1, target - candidates[j], cur, candidates);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end
