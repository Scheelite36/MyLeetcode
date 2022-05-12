import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    int n;
    
    public List<List<Integer>> subsets(int[] nums) {
        // 列举
        // List<List<Integer>> res = new ArrayList<>();
        // res.add(new ArrayList<>());
        // for (int n : nums){
        //     List<List<Integer>> temp = new ArrayList<>();
        //     for (List<Integer> list : res) {
        //         list.add(n);
        //         temp.add(new ArrayList<>(n));
        //     }
        //     res.addAll(temp);
        // }
        // return res;

        // 回溯
        n = nums.length;
        for (int k=0; k<=n; k++){
            traceBack(0, k, new ArrayList<>(), nums);
        }
        return res;
    }
    public void traceBack(int start, int k, List<Integer> cur, int[] nums){
        if (k == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i=start; i<n; i++){
            cur.add(nums[i]);
            traceBack(i+1, k-1, cur, nums);
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end

