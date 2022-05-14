import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int len = 0;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        len = nums.length;
        Arrays.sort(nums);
        for (int k = 0; k <= len; k++) {
            traceBack(0, k, new ArrayList<>(), nums);
        }
        return res;
    }

    public void traceBack(int start, int k, List<Integer> cur, int[] nums) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            traceBack(i + 1, k - 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end
