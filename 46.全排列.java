import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int len = 0;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        traceBack(0, new ArrayList<>(), nums);
        return res;
    }

    void traceBack(int start, List<Integer> cur, int[] nums) {
        if (cur.size() == len) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < len; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            traceBack(0, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end
