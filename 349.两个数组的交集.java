import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> setRes = new HashSet<>();
        for (int i:nums1){
            set1.add(i);
        }
        for (int i:nums2){
            if(set1.contains(i)){
                setRes.add(i);
            }
        }
        int[] res = new int[setRes.size()];
        int index = 0;
        for(int i:setRes){
            res[index] = i;
            index++;
        }
        return res;
    }
}
// @lc code=end
