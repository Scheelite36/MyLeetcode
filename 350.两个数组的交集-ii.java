import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 遍历保存进hashmap，将出现个数进行删减
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums1){
            if(map.containsKey(i)){
                map.replace(i, map.get(i)+1);
                continue;
            }
            map.put(i, 1);
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for(int i:nums2){
            if(map.containsKey(i) && map.get(i)>0){
                map.replace(i, map.get(i)-1);
                res[index++] = i;
            }
        }
        int[] ress = Arrays.copyOfRange(res, 0, index--);
        return ress;
    }

            // 遍历一个为列表，添加到新表，删除旧表元素 效率低
        // List<Integer> list = new ArrayList<>();
        // List<Integer> resList = new ArrayList<>();
        // for (int i:nums1){
        //    list.add(i); 
        // }
        // for(int i: nums2){
        //     int index = list.indexOf(i);
        //     if(index != -1){
        //         resList.add(i);
        //         list.remove(index);
        //     }
        // }
        // int[] res = new int[resList.size()];
        // int index = 0;
        // for(int i:resList){
        //     res[index] = i;
        //     index++;
        // }
        // return res;

}
// @lc code=end

