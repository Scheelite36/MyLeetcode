import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        trackBack(0, target, new ArrayList<>(), candidates);
        return res;
    }

    public void trackBack(int i, int target, List<Integer> cur, int[] candidates){
        if(i == candidates.length){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        // 跳过当前元素
        trackBack(i+1, target, cur, candidates);
        // 选择当前元素
        if(target-candidates[i]>=0){
            cur.add(candidates[i]);
            trackBack(i, target-candidates[i], cur, candidates);
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end

