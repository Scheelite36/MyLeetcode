
/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 对所有数字进行异或操作即可以求出唯一一个的元素
        int single = 0;
        for (int i:nums){
            single ^= i;
        }
        return single;
    }
    // set 方法需要额外O(n)的空间，运行时间也不如前者
    // Set<Integer> set = new HashSet<>();
    // for(int i:nums){
    //     if (!set.add(i)){
    //         set.remove(i);
    //     }
    // }
    // return set.iterator().next();
}
