import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        if (numRows == 1){
            return res;
        }
        res.add(Arrays.asList(1,1));
        if (numRows == 2){
            return res;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> newLine = new ArrayList<>();
            newLine.add(1);
            for (int j=1; j<i; j++){
                newLine.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
            }
            newLine.add(1);
            res.add(newLine);
        }
        return res;
    }
}
// @lc code=end

