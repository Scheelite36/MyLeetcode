package slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <=
 * t ，同时又满足 abs(i - j) <= k 。
 * 
 * 如果存在则返回 true，不存在返回 false。
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 滑动窗口+集合 避免int溢出 使用long类型
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 桶排序思想+滑动窗口
        Map<Long, Integer> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id))
                return true;
            if (map.containsKey(id - 1) && Math.abs((long)nums[i] - (long)map.get(id - 1)) <= t)
                return true;
            if (map.containsKey(id + 1) && Math.abs((long)nums[i] - (long) map.get(id + 1)) <= t)
                return true;
            map.put(id, nums[i]);
            if (i >= k)
                map.remove(getId(nums[i-k], w));
        }
        return false;
    }

    public long getId(long n, long w) {
        if (n >= 0)
            return n / w;
        // 确保 -1 放置在 编号为-1的桶
        long t = w - 1;
        return (n - t) / w;
    }
}
