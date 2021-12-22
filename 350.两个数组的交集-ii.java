import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        for (int i:nums1){
           list.add(i); 
        }
        for(int i: nums2){
            int index = list.indexOf(i);
            if(index != -1){
                resList.add(i);
                list.remove(index);
            }
        }
        int[] res = new int[resList.size()];
        int index = 0;
        for(int i:resList){
            res[index] = i;
            index++;
        }
        return res;
    }
}
// @lc code=end

