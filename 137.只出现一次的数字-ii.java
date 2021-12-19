import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 计数的map
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            if(map.containsKey(num)){
                if(map.get(num)==2){
                    map.remove(num);
                    continue;
                }
                map.put(num, map.get(num)+1);
                continue;
            }
            map.put(num, 1);
        }
        return map.keySet().iterator().next();

        // 推荐使用位运算 时间复杂度较优
        // int res = 0;
        // for (int i = 0; i < 32; i++) {
        //     int bTotal = 0;
        //     for (int num : nums) {
        //         // 所有数字二进制第i位的总和
        //         bTotal += ((num >> i) & 1);
        //     }
        //     if (bTotal % 3 != 0) {
        //         res |= (1 << i);
        //     }
        // }
        // return res;
    }
}
// @lc code=end
