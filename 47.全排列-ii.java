import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int len = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        Arrays.sort(nums);
        traceBack(0, new ArrayList<>(), nums, new boolean[len]);
        return res;
    }
    void traceBack(int start, List<Integer> cur, int[] nums, boolean[] vis ){
        if (cur.size() == len){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i<len;i++){
            if (vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])){
                continue;
            }
            cur.add(nums[i]);
            vis[i] = true;
            traceBack(0, cur, nums, vis);
            vis[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end
