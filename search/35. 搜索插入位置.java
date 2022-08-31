package search;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution35 {
    int[] nums;

    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        int l = binarySearch(target, 0, nums.length - 1);
        // 对于要添加在数组最后的数需要+1
        if (l == nums.length - 1 && nums[nums.length - 1] < target)
            return l + 1;
        return l;
    }

    public int binarySearch(int target, int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
